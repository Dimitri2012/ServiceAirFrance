package fr.airfrance.dao;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.airfrance.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
	User findById(int id);

	List<User> findBySurname(String surname);

	List<User> findByAge(int age);

	
	
}
