package com.app.inventory.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.app.inventory.facadeimp.UserDao;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private  UserDao userdao;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userdao);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(
				"/registro",
				"/js/**",
				"/css/**",
				"/img/**",
				"/datatables/**",
				"/fontawesome/**",
				"/forgot_password",
				"/reset_password")
		.permitAll()
		.antMatchers("/").hasAnyAuthority("Invitado", "Mesero", "Bodeguero", "Administrador")
		.antMatchers("/mesero/**").hasAnyAuthority("Mesero", "Administrador")
		.antMatchers("/admin/ProdWEB").hasAnyAuthority("Mesero", "Bodeguero", "Administrador")
		.antMatchers("/Bodeguero/**").hasAnyAuthority("Bodeguero", "Administrador")
		.antMatchers("/admin/**").hasAuthority("Administrador")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout")
		.permitAll().and().exceptionHandling().accessDeniedPage("/ups");
	}
	
}
