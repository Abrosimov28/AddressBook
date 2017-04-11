package no.entities;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import no.addressbook.FlexibleComparator;
import no.addressbook.FlexibleComparator.SortBy;
import no.daos.DatabaseSystemPersonDAO;
import no.daos.FileSystemPersonDAO;
import no.daos.PersonDAO;

public class AddressBook {
	private List<Person> personList;
	private FlexibleComparator comp = new FlexibleComparator();
	private PersonDAO personDAO;
	
	public AddressBook() throws IOException{
		personDAO = new DatabaseSystemPersonDAO();
		personList = personDAO.loadPerson();
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(ArrayList<Person> personList) {
		this.personList = personList;
	}
	
	public void addPerson(Person person) throws IOException{
		personList.add(person);
		personDAO.savePerson(person);
	}
	
	public void updatePerson(int index, String address, String country, String phone){
		personList.get(index).setAddress(address);
		personList.get(index).setAddress(country);
		personList.get(index).setAddress(phone);
	}
	
	public void deletePersonFromFile(Person person){
		try {
			personDAO.deletePerson(person);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writePersonIntoFile(Person person){
		
	}
	
	public void removePerson(int index){
		personList.remove(index);
	}
	
	public int getNumberOfPersons(){
		return personList.size();
	}
	
	public void sortByCountry(){
		comp.setSortBy(SortBy.COUNTRY);
		Collections.sort(personList, comp);
	}
	
	public void sortByName(){
		comp.setSortBy(SortBy.NAME);
		Collections.sort(personList, comp);
		
	}
	
}


