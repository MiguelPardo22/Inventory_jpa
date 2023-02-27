package com.app.inventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.inventory.model.Rol;

@Repository
public interface RoleRepository extends JpaRepository<Rol, Long>{

}
