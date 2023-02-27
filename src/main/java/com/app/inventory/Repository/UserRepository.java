package com.app.inventory.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.inventory.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public User findByMail(String mail);
	
	@Query(value = "SELECT * FROM usuario where usuario.estado = 'Activo'",
			nativeQuery = true)
	List<User> ListUser();
	
}
