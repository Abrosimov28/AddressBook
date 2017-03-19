package daos;


import java.io.IOException;
import java.util.List;

import entities.Person;


public interface PersonDAO {

	List<Person> loadPerson() throws IOException;
	
	void writeFile(Person person) throws IOException;

	void deletePerson(Person person) throws IOException;
}

// premenovat na personDAO
// premenovat na loadPersons, savePerson, deletePerson
// filesystemperson - filesystempersonDAO (data access object) 
// dao = repository
// sk.addressbook upravit nazov packagu, mat aspon v jednom zabalene
