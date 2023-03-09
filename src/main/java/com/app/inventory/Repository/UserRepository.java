package com.app.inventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.inventory.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public User findByMail(String mail);
	
	public User findByResetPasswordToken(String token);
	
	@Query(value = "SELECT * FROM usuario where usuario.estado = 'Activo'",
			nativeQuery = true)
	List<User> ListUser();
	
	@Query(value = "select u.id_usu, ur.usuario_id, ur.rol_id, u.mail, u.contraseña, u.estado, u.identificacion, u.nombre_completo, u.telefono, u.reset_password_token from usuario u join usuarios_roles ur on u.id_usu = ur.usuario_id where ur.rol_id = 2;",
			nativeQuery = true)
	List<User> rolAdministrador();
	
	@Query(value = "select u.id_usu, ur.usuario_id, ur.rol_id, u.mail, u.contraseña, u.estado, u.identificacion, u.nombre_completo, u.telefono, u.reset_password_token from usuario u join usuarios_roles ur on u.id_usu = ur.usuario_id where ur.rol_id = 3;",
			nativeQuery = true)
	List<User> rolBodeguero();
	
	@Query(value = "select u.id_usu, ur.usuario_id, ur.rol_id, u.mail, u.contraseña, u.estado, u.identificacion, u.nombre_completo, u.telefono, u.reset_password_token from usuario u join usuarios_roles ur on u.id_usu = ur.usuario_id where ur.rol_id = 4;",
			nativeQuery = true)
	List<User> rolMesero();

}
