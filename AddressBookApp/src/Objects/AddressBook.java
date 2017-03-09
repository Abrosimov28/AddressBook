import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddressBook {
	private List<Person> personList;
	private FlexibleComparator comp = new FlexibleComparator();
	
	AddressBook(){
		personList = new ArrayList<Person>();
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
