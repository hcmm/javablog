package br.com.javablog.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.javablog.entity.Blog;
import br.com.javablog.entity.Item;
import br.com.javablog.entity.Role;
import br.com.javablog.entity.User;
import br.com.javablog.jba.repository.BlogRepository;
import br.com.javablog.jba.repository.ItemRepository;
import br.com.javablog.jba.repository.RoleRepository;
import br.com.javablog.jba.repository.UserRepository;

@Transactional
@Service
public class InitDbService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@PostConstruct
	public void init(){
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setEnabled(true);
		userAdmin.setName("admin");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("admin"));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		
		Blog blogjava = new Blog();
		blogjava.setName("BlogJava");
		blogjava.setUrl("http://google.com");
		blogjava.setUser(userAdmin);
		blogRepository.save(blogjava);
		
		Item item1 = new Item();
		item1.setBlog(blogjava);
		item1.setTitle("first");
		item1.setLink("http://google.com");
		item1.setPublisheDate(new Date());
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setBlog(blogjava);
		item2.setTitle("Second");
		item2.setLink("http://google.com");
		item2.setPublisheDate(new Date());
		itemRepository.save(item2);
	}

}
