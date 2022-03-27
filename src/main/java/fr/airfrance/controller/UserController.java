package fr.airfrance.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import fr.airfrance.dao.UserRepository;
import fr.airfrance.model.Response;
import fr.airfrance.model.User;
import fr.airfrance.service.CountryConstraintNotRespectingException;
import fr.airfrance.service.Service;


@RestController
@RequestMapping("/users")
public class UserController {
	
	
	/**
	 * An instance of Service.
	 * a UserController has his own service to delegate tasks.
	 */
	@Autowired
	private Service service;
	/**
	 *  tries to find  a user by his id. 
	 * It calls his service field to do it.
	 * @param id 
	 * @return ResponseEntity{@literal<}?{@literal>}
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable int id) {
		long startTime = System.currentTimeMillis();

		try {
			User u = service.findById(id);
			System.out.println("getting user with id=" + id);

			long stopTime = System.currentTimeMillis();
			System.out.println("Processing time:" + (stopTime - startTime) + "ms");
			return ResponseEntity.status(HttpStatus.OK).body(u);

		} catch (NullPointerException e) {
			Response response = new Response("Nobody has this id", HttpStatus.NOT_FOUND.toString());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		} 
	}
	
	/**
	 *  enables to find users having a certain age. 
	 * If the param is not specified it will return the youngest users having eighteen years old.
	 * @param age
	 * @return ResponsEntity{@literal<}List{@literal<}User{@literal>}{@literal>}
	 */
	@GetMapping()
	public ResponseEntity<List<User>> getAllUserByAge(@RequestParam(defaultValue = "18") int age) {
		long startTime = System.currentTimeMillis();
		System.out.println("getting users...");

		List<User> u = service.findAllUsersByAge(age);
		long stopTime = System.currentTimeMillis();
		System.out.println("Processing time:" + (stopTime - startTime) + "ms");
		return ResponseEntity.status(HttpStatus.OK).body(u);

	}
   /**
    *  enables to save a new user
    * @param user
    * @return ResponseEntity{@literal<}Response{@literal>}
    */
	@PostMapping()
	public ResponseEntity<Response> postUser(@RequestBody User user) {

		long startTime = System.currentTimeMillis();
		System.out.println("getting users...");
		try {
			System.out.println("Saving new users...");
			service.save(user);

			Response response = new Response("New user saved", HttpStatus.OK.toString());
			long stopTime = System.currentTimeMillis();
			System.out.println("Processing time:" + (stopTime - startTime) + "ms");
			return ResponseEntity.status(HttpStatus.OK).body(response);

		} catch (CountryConstraintNotRespectingException e) {
			System.out.println("failed country constraint not respected");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new Response("Your country must be France", HttpStatus.BAD_REQUEST.toString()));
		}catch (ConstraintViolationException e) {

			Response response = new Response("You must be older or equals than 18", HttpStatus.BAD_REQUEST.toString());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

		} 

	}

}
