import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;

public class AddressBook {
	FileReader in;
	FileWriter out;
	private List<Person> personList;
	
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
	
//	public List<Person> sortByCountry(){
//		return personList.sort(new personList<>);
//	}
	
}
