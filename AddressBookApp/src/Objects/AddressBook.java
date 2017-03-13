package Objects;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import AddressBook.FileSystem;
import AddressBook.FlexibleComparator;

public class AddressBook {
	private List<Person> personList;
	private FlexibleComparator comp = new FlexibleComparator();
	private FileSystem fileSystem;
	
	public AddressBook() throws IOException{
		fileSystem = new FileSystem();
		personList = fileSystem.readFile();
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}
	
	public void addPerson(String firstName, String lastName, 
			String address, String country, String phone){
		personList.add(new Person(firstName, lastName, address, country, phone));
	}
	
	public void updatePerson(int index, String address, String country, String phone){
		personList.get(index).setAddress(address);
		personList.get(index).setAddress(country);
		personList.get(index).setAddress(phone);
	}
	
	public void deletePersonFromFile(Person person){
		try {
			fileSystem.deletePerson(person);
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
		comp.setSortBy("Country");
		Collections.sort(personList, comp);
	}
	
	public void sortByName(){
		comp.setSortBy("Name");
		Collections.sort(personList, comp);
	}
	
}
