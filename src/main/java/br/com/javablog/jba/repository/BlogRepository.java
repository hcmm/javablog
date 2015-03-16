package br.com.javablog.jba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javablog.entity.Blog;
import br.com.javablog.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer>{
	
	List<Blog> findByUser(User user);

}
