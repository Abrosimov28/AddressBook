package AddressBook;
import java.util.Comparator;

import Objects.Person;

public class FlexibleComparator implements Comparator<Person> {
	
	String sortBy = "Country";
	
	@Override
	public int compare(Person person_1, Person person_2){
		switch(sortBy){
		case "Country" : return person_1.getCountry().compareTo(person_2.getCountry());
		case "Name" : return person_1.getLastName().compareTo(person_2.getLastName());
		}
		throw new RuntimeException("Practically unreachable code, can't be thrown");
	}
	
	public void setSortBy(String sortBy){
		this.sortBy = sortBy;
	}
}
