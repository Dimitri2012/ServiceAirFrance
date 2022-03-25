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

	
	public User findById(int id) throws Exception {

		User user = userRepository.findById(id);
		if (user == null) {
			throw new Exception();
		}
		return userRepository.findById(id);

	}

	public List<User> findAllUsersByAge(int age) {
		return userRepository.findByAge(age);
	}

	public void save(User user) throws Exception {

		if (!(user.getCountry().equals("France"))) {
			throw new Exception();
		}
		if (user.getNickname() == null) {
			System.out.println(user.getNickname());
			user.setNickname("");
		}

		userRepository.save(user);

	}

}
