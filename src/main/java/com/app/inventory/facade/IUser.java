package com.app.inventory.facade;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.app.inventory.Dto.UserRegistroDTO;
import com.app.inventory.model.User;


public interface IUser  extends UserDetailsService {
    
	public User save(UserRegistroDTO registroDTO); 
	public List<User>EncontrarUser();
	public Optional<User>getOne(Long id_usu);
	public User findById(Long id_usu);
	public void create(User user);
	public void update(User user);
	public void delete(User user);

}
