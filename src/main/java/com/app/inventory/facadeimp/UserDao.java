package com.app.inventory.facadeimp;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.app.inventory.Dto.UserRegistroDTO;
import com.app.inventory.Repository.RoleRepository;
import com.app.inventory.Repository.UserRepository;
import com.app.inventory.facade.IUser;
import com.app.inventory.model.Rol;
import com.app.inventory.model.User;

@Service
public class UserDao implements IUser {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	RoleRepository rolrepo;

	private UserRepository userrepo;

	public UserDao(UserRepository userrepo) {
		super();
		this.userrepo = userrepo;
	}

	@Override
	public User save(UserRegistroDTO registroDTO) {

		try {
		
		User us = new User(registroDTO.getIden(), registroDTO.getNom(),
				registroDTO.getTel(), registroDTO.getMail(),
				passwordEncoder.encode(registroDTO.getCon()),
				rolrepo.rolInicial());
		        us.setEst("Activo");
		return userrepo.save(us);
		} catch (DataIntegrityViolationException ex) {
            throw new RuntimeException("El correo electrónico debe ser único", ex);
        }
	}

	public void updateResetPasswordToken(String token, String mail) throws AccountNotFoundException {
		
		User user = userrepo1.findByMail(mail);
		
		if (user != null) {
			user.setResetPasswordToken(token);
			userrepo1.save(user);
		}else {
			
			throw new AccountNotFoundException("No se encontro ningun correo registrado: " + mail);
		}
				
	}
	
	public User get(String resetPasswordToken) {
		return userrepo1.findByResetPasswordToken(resetPasswordToken);
	}
	
	public void updatePassword(User user, String newPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodePassword = passwordEncoder.encode(newPassword);
		
		user.setCon(encodePassword);
		user.setResetPasswordToken(null);
		
		userrepo.save(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User us = userrepo.findByMail(username);

		if (us == null) {

			throw new UsernameNotFoundException("Usuario o Contraseña invalidos");

		}
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession(true);
		session.setAttribute("usuario", session);

		return new org.springframework.security.core.userdetails.User(us.getMail(), us.getCon(),
				mapearAutoridadesRoles(us.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {

		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNom())).collect(Collectors.toList());

	}

	@Autowired
	UserRepository userrepo1;

	@Override
	public List<User> EncontrarUser() {
		return userrepo.ListUser();
	}

	@Override
	public Optional<User> getOne(Long id_usu) {
		return userrepo1.findById(id_usu);
	}

	@Override
	public User findById(Long id_usu) {
		return userrepo1.getReferenceById(id_usu);
	}

	@Override
	public void create(User user) {
		this.userrepo1.save(user);

	}

	@Override
	public void update(User user) {
		this.userrepo1.save(user);
	}

	@Override
	public void delete(User user) {
		User us = this.userrepo1.getById(user.getId_usu());
		this.userrepo.save(us);
	}

}
