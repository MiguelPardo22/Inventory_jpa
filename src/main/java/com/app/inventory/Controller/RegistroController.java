 package com.app.inventory.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.inventory.Repository.InventoryRepository;
import com.app.inventory.Repository.UserRepository;
import com.app.inventory.facadeimp.EmailDao;
import com.app.inventory.facadeimp.UserDao;
import com.app.inventory.model.Inventory;
import com.app.inventory.model.User;

@Controller
public class RegistroController {
	
	@Autowired
	EmailDao emaildao;
	
	@Autowired
	UserDao userdao;
	
	@Autowired
	InventoryRepository invenrepo;
	
	@Autowired
	UserRepository userrepo;
	
	@GetMapping("/login")
	public String login() {
	 return "login";
	}
	
	/*@GetMapping("/registro")
	public String registro() {
	 return "registro";
	}*/
	
	@GetMapping("/")
	public String VerPagina(Model modelo) {
		
		List<Inventory> lstinven = invenrepo.stock();
		modelo.addAttribute("stock", lstinven);
		
	 return "index";
	}
	
	@GetMapping("/index-particles")
	public String VerPagina2() {
	 return "index-particles";
	}
	
	@GetMapping("/ups")
	public String VerError() {
	 return "ups";
	}
	
	
	// --> Envio de Correos
	@GetMapping("/mail")
	public String enviarmail(Model modelo){ 
		
		List<User> lstadmin = userrepo.rolAdministrador();
		modelo.addAttribute("admin", lstadmin); 
		
	    List<User> lstBodeguero = userrepo.rolBodeguero();
		modelo.addAttribute("bodeguero", lstBodeguero); 
		
		List<User> lstmesero = userrepo.rolMesero();
		modelo.addAttribute("mesero", lstmesero);
		
		return "MailWEB";
	} 
	
	
	
	@PostMapping("/sendMail")
	public String sendMail(@RequestParam("name") String name, @RequestParam("mail") String mail,
			@RequestParam("subject") String subject, @RequestParam("body") String body, HttpServletRequest request) {
		
		String[] email = request.getParameterValues("emails");
		
		for (int i = 0; i < email.length; i++) {
		
		String message = body + "\n\n Datos del Contacto: " + "\nNombre: " + name + "\nE-Mail: " + mail;
		
		emaildao.sendListEmail("miangelpardo123@gmail.com", email[i], subject, message);
		
		}
		
		return "redirect:/mail";		
	}
	
}
