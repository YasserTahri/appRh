package tn.myapps.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.myapps.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Role findByRole(String role);
}
