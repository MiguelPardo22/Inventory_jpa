package com.app.inventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.inventory.model.Rol;

@Repository
public interface RoleRepository extends JpaRepository<Rol, Long>{

  @Query(value = "SELECT * FROM rol WHERE rol.id_rol = 1",
			nativeQuery = true)
	List<Rol> rolInicial();
  
}
