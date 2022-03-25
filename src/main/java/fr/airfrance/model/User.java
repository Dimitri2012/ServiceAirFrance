package fr.airfrance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity 
@Table
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Column
	private String name;
	@NotNull
	@Column
	private String surname;
	@NotNull
	@Column
	@Min(value=18, message="must be equal or greater than 18")
	private int age;
	@NotNull
	@Column
	private String country;
	@Column
	private String nickname;
	
	//{"nickname":"Dim","name":"Dimitri","surname":"Arches","age":"26","country":"France"}
	//{"nickname":"Nana","name":"Vanina","surname":"Arches","age":"23","country":"France"}
	//{"name":"Melissa","surname":"Arches","age":"28","country":"France"}
	//{"name":"Skylar","surname":"Moreau","age":"17","country":"France"}
	//{"name":"Skylar","surname":"Moreau","age":"19","country":"France"}
	//{"name":"Omar","surname":"Bichr","age":"26","country":"Maroc"}
	
	
	
	
	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public User() { }

	
	
	public User( String name, String surname, int age,String country) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.country=country;
		
		
		
	}



	public User(String nickname, String name, String surname, int age, String country) {
		this(name,surname,age,country);
		this.nickname=nickname;
		

	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
