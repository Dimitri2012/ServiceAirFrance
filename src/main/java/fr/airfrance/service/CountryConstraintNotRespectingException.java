package fr.airfrance.service;

public class CountryConstraintNotRespectingException extends Exception {
	
	public CountryConstraintNotRespectingException() {
		super("Country's constraint is not respecting. it should be \"France\"");
	}

}
