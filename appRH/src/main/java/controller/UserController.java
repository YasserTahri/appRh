package controller;

import java.security.Principal;

import java.util.ArrayList;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;
import tn.myapps.dao.RoleRepository;
import tn.myapps.entities.Role;
import tn.myapps.entities.User;
import tn.myapps.services.UserService;
import util.CustomErrorType;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("account")
public class UserController {
	
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoleRepository roleRepository;
	
	
	
	

	// request method to create a new account by a guest
	@CrossOrigin
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User newUser) {
		if (userService.find(newUser.getUsername()) != null) {
			logger.error("username Already exist in " + newUser.getUsername());
			return new ResponseEntity(
					new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
					HttpStatus.CONFLICT);
		}
		newUser.setRole("USER");
		
		return new ResponseEntity<User>(userService.save(newUser), HttpStatus.CREATED);
	}

	// this is the login api/service
	 
	@RequestMapping(value="/login")
	public Principal user(Principal principal) {
		
		logger.info("user logged "+principal);
		return principal;
	}
	
	

}
