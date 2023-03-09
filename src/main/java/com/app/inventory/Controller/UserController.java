package com.app.inventory.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.inventory.facadeimp.RoleDao;
import com.app.inventory.facadeimp.UserDao;
import com.app.inventory.model.Rol;
import com.app.inventory.model.User;

@Controller
@RequestMapping({"/admin"})
public class UserController {

	@Autowired
	UserDao userdao;
	
	@Autowired
	RoleDao roledao;
	
	@RequestMapping({"/UserWEB", "/"})
	public String ListUser(Model modelo){
		
		modelo.addAttribute("User", userdao.EncontrarUser());
		
		List<Rol> lstrole = roledao.Encontrarrole();
		modelo.addAttribute("Rol", lstrole); 
		
		return "UserWEB";
	}
	
	@RequestMapping({"/getOneUser"})
	@ResponseBody
	public Optional<User> getOne(Long id_usu){
		return userdao.getOne(id_usu);
	}
	
	@PostMapping({"/Usercrear"})
	public String create(User user){
		
		this.userdao.create(user);
		return "redirect:/admin/UserWEB";
	}
	
	@RequestMapping(value="/Userupdate", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(User user){
		this.userdao.update(user);
		return "redirect:/admin/UserWEB";
	}
	
	@RequestMapping(value="/Userdelete", method = {RequestMethod.PUT, RequestMethod.GET})
	public String delete(Long id_usu) {
		
		User us = userdao.findById(id_usu);
		us.setEst("Inactivo");
		
		this.userdao.delete(us);
		return "redirect:/admin/UserWEB";
	}
	
}
