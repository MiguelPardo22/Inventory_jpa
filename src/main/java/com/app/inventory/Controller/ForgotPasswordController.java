package com.app.inventory.Controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.inventory.Utilities.Utility;
import com.app.inventory.facadeimp.UserDao;
import com.app.inventory.model.User;

import net.bytebuddy.utility.RandomString;

@Controller
public class ForgotPasswordController {

	@Autowired
	UserDao userdao;

	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/forgot_password")
	public String MostrarFormularioOlvidasteTuContraseña(Model modelo) {
		modelo.addAttribute("pageTitle", "Forgot Password");
		return "ForgotPassword";
	}

	@PostMapping("/forgot_password")
	public String ForgotPasswor(HttpServletRequest request, Model modelo) {

		String email = request.getParameter("username");
		String token = RandomString.make(60);

		try {

			userdao.updateResetPasswordToken(token, email);
			String resetPasswordLink = Utility.getSiteUrl(request)+ "/reset_password?token=" + token;
			
			sendEmail(email, resetPasswordLink);
			
			modelo.addAttribute("message", "Hemos enviado un enlace de restablecimiento de contraseña a su correo electrónico. Por favor verifique");
			
		} catch (AccountNotFoundException e) {
			modelo.addAttribute("error", e.getMessage());
		} catch (UnsupportedEncodingException | MessagingException e) {
			modelo.addAttribute("error", "Ocurrio algo mientras se enviaba el email");
		}

		modelo.addAttribute("pageTitle", "Forgot Password");
		return "ForgotPassword";
	}

	private void sendEmail(String email, String resetPasswordLink) throws UnsupportedEncodingException, MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setFrom("1nv3torym@gmail.com", "Soporte de Contraseñas");
		helper.setTo(email);
		
		String subject = "Aqui esta el link donde usted puede reiniciar su contraseña";
		
		String contenido = "<p>Hola, </p>"
				+ "<p>Usted ha pedido reiniciar su contraseña</p>"
				+ "<p>Este es el enlace para reiniciar su contraseña</p>"
				+ "<p><b><a href=\"" + resetPasswordLink + "\">Reiniciar mi Contraseña</a></b></p>";	
		
		helper.setSubject(subject);
		helper.setText(contenido, true);
		
		mailSender.send(message);
	}

	@GetMapping("/reset_password")
	public String MostrarReiniciodeContraseña(@Param(value = "token") String token, Model model) {
		
		User us = userdao.get(token);
		
		if(us == null) {
			
			model.addAttribute("titlr", "Restablecimiento de Contraseña");
			model.addAttribute("message", "Sesion Invalida");
			
			return "message";
		}
		
		model.addAttribute("token", token);
		model.addAttribute("pageTitle", "Forgot Password");
		return "reset_password_form";
	}
	
    @PostMapping("/reset_password")
    public String processResetPassword(HttpServletRequest request, Model model) {
    	
    	String token = request.getParameter("token");
    	String password = request.getParameter("password");
    	
    	User us = userdao.get(token);
    	
        if(us == null) {
			
			model.addAttribute("titlr", "Restablecimiento de Contraseña");
			model.addAttribute("message", "Sesion Invalida");
			
			return "message";
		}else {
			
			userdao.updatePassword(us, password);
			model.addAttribute("message", "Ha Cambiado Exitosamente su contraseña");
		}
    	
    	return "message";
    }
	
}
