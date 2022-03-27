package fr.airfrance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import fr.airfrance.dao.UserRepository;
import fr.airfrance.model.User;

@Repository
public class Service {

	@Autowired
	private UserRepository userRepository;

	/**
	 * check if a user has this id in the base.
	 * Then it returns the user or throws an Exception.
	 * @param id
	 * @return User
	 * @throws NullPointerException
	 */
	public User findById(int id) throws NullPointerException {

		User user = userRepository.findById(id);
		if (user == null) {
			throw new NullPointerException();
		}
		return userRepository.findById(id);

	}
	/**
	 *  find users having a certain age in the base.
	 * @param age
	 * @return List {@literal <}User {@literal >}
	 */
	public List<User> findAllUsersByAge(int age) {
		return userRepository.findByAge(age);
	}
	/**
	 *  try to save a new user if it respects severals constraints.
	 * Essentially if the user has at least eighteen and his county is France.
	 * @param user 
	 * @throws CountryConstraintNotRespectingException
	 */
	public void save(User user) throws CountryConstraintNotRespectingException {

		if (!(user.getCountry().equals("France"))) {
			throw new CountryConstraintNotRespectingException();
		}
		if (user.getNickname() == null) {
			System.out.println(user.getNickname());
			user.setNickname("");
		}

		userRepository.save(user);

	}

}
