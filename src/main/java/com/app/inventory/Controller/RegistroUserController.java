package com.app.inventory.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.inventory.Dto.UserRegistroDTO;
import com.app.inventory.facadeimp.UserDao;



@Controller
@RequestMapping("/registro")
public class RegistroUserController {

	private UserDao userdao;

	public RegistroUserController(UserDao userdao) {
		super();
		this.userdao = userdao;
	}
	@ModelAttribute("usuario")
	public UserRegistroDTO retornarNuevoUsuarioRegistroDTO() {

		return new UserRegistroDTO();
	}
	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "registro";
	}
	@PostMapping
	public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UserRegistroDTO registroDTO) { 
		userdao.save(registroDTO);
		return "redirect:/registro?exito";
	}
}
