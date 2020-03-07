package com.example.demo.controllers;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.UserRepository;
import com.example.demo.pojos.User;
import com.example.demo.email.EmailService;;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/UserPortal")
public class UserController {
	@Autowired
	private UserRepository userrepo;
	@RequestMapping("/getAllUsers")
	public Iterable<User> getAllUsers(){
		return userrepo.findAll();
	}
	
	 @Autowired
	   private EmailService emailService;

	 @PostMapping("/saveUser")

	 public User saveUser(@RequestBody User user) {

	 System.out.println(user);

	 userrepo.save(user);



	 StringBuffer mailContain= new StringBuffer();

	 mailContain.append("Hi "+user.getUsername()+"\n");

	 mailContain.append("Please Click on Below Click to Confirm Your Email With Us\n");

	 mailContain.append("<a href='http://localhost:8096/UserPortal/confirmEmail/"+user.getEmail()+">Click</a>\n");

	 mailContain.append("Thanks And Regards\n CTS Participant\n");



	 emailService.sendMail(user.getEmail(),"Email Confirmation", mailContain.toString());

	    //emailService.sendPreConfiguredMail("Ho ho ho");

	 return user;

	 }
	 @PostMapping("/uploadImage")
	  public int handleFileUpload(@RequestParam("file") MultipartFile file, HttpSession session) {
	 Path rootLocation = Paths.get(session.getServletContext().getRealPath("/resources/images"));
	  System.out.println("rootLocation == " + rootLocation);
	  String nameExtension[] = file.getContentType().split("/");
	  String profileImage = System.currentTimeMillis() + "." + nameExtension[1];
	  try
	   {
	   System.out.println("ProfileImage :: " + profileImage);
	   }
	  catch(Exception exception)
	   {
	   }
	 return 1;
	  }
	@PutMapping("/updateUser/{username}")
	public User updateUser(@RequestBody User user,@PathVariable("username") String username) {
		user.setUsername(username);
		System.out.println(user);
		
		userrepo.save(user);
		return user;
	}
	@DeleteMapping("/deleteUser/{username}")
	public Boolean deleteUser(@PathVariable("username") String username) {
		System.out.println(username);
		userrepo.deleteById(username);
		return true;
	}
	@GetMapping("/findOneInAll6/{username}")
	 public User findoneinall(@PathVariable("username") String username)
	 {
	 Optional<User> user= userrepo.findById(username);
	 return user.get();
	 }
	@GetMapping("/confirmEmail/{emailId}")

	 public User confirmEmail(@PathVariable("emailId") String emailId)

	 {

	 Optional<User> user= userrepo.findByEmail(emailId);

	 if(user!=null && user.get()!=null)

	 {

	  User u=user.get();

	  u.setConfirm("Yes");

	  userrepo.save(u);

	  return u;
	 }
	 return user.get();
	 }
	
	@GetMapping("/findByUsernameAndPassword/{username}/{password}")
	 public User findByUsernameAndPassword(@PathVariable("username") String username,@PathVariable("password") String password)
	 {
		User user= userrepo.findByUsernameAndPasswordAndConfirm(username, password,"yes");
	 return user;
	 }

}
