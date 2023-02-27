package com.app.inventory.facadeimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.inventory.Repository.RoleRepository;
import com.app.inventory.facade.IRole;
import com.app.inventory.model.Rol;


@Service
public class RoleDao implements IRole {
	@Autowired
	private RoleRepository rolerepo;
	
	@Override
	public List<Rol>Encontrarrole(){
		return rolerepo.findAll();
	}
}
