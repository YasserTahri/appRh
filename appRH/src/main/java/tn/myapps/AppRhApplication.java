package tn.myapps;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.myapps.dao.UserRepository;

import tn.myapps.entities.User;

@SpringBootApplication
public class AppRhApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(AppRhApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		userRepository.save(new User("yasser","USER","pwdyass"));
		userRepository.save(new User("med","USER","pwdmed"));
		
	}
	

}
