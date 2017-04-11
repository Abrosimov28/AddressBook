package no.daos;


import java.io.IOException;
import java.util.List;

import no.entities.Person;


public interface PersonDAO {

	List<Person> loadPerson() throws IOException;
	
	void savePerson(Person person) throws IOException;

	void deletePerson(Person person) throws IOException;
}



// sk.addressbook upravit nazov packagu, mat aspon v jednom zabalene
