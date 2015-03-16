package br.com.javablog.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javablog.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByName(String name);

}
