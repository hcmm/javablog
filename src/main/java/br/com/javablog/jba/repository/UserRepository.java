package br.com.javablog.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javablog.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String name);

}
