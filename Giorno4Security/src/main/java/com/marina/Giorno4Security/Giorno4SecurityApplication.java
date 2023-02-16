package com.marina.Giorno4Security;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.marina.Giorno4Security.config.Beans;
import com.marina.Giorno4Security.entities.Role;
import com.marina.Giorno4Security.entities.RoleType;
import com.marina.Giorno4Security.entities.User;
import com.marina.Giorno4Security.services.DaoService;

@SpringBootApplication
public class Giorno4SecurityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Giorno4SecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		boolean x = false;
		if (x) {
			populate();
		}
	}
	
	@Autowired
	private DaoService dao;
	
	private void populate() {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
	
		User u1 = (User)ctx.getBean("user", "Amadeus", "amadeusonoio", "ama");
		Role r1 = (Role)ctx.getBean("role", RoleType.ROLE_PRESENTATORE);
		
		User u2 = (User)ctx.getBean("user", "Lazza", "lazzino", "cenere");
		Role r2 = (Role)ctx.getBean("role", RoleType.ROLE_CANTANTE);
		
		User u3 = (User)ctx.getBean("user", "Pubblico", "pubblico", "pubblico");
		Role r3 = (Role)ctx.getBean("role", RoleType.ROLE_PUBBLICO);
		
		u1.setRoles(new HashSet<>() {{
			add(r1);
		}});
		
		u2.setRoles(new HashSet<>() {{
			add(r2);
		}});
		
		u3.setRoles(new HashSet<>() {{
			add(r3);
		}});
		
		dao.saveRole(r1);
		dao.saveRole(r2);
		dao.saveRole(r3);
		
		dao.saveUser(u1);
		dao.saveUser(u2);
		dao.saveUser(u3);
		
		((AnnotationConfigApplicationContext)ctx).close();
	}

}
