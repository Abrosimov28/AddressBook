package addressbook;
import java.util.Comparator;

import entities.Person;

public class FlexibleComparator implements Comparator<Person> {
	
	public enum sortBy {NAME, COUNTRY};
	private sortBy sb;
	
	
	@Override
	public int compare(Person person_1, Person person_2){
		switch(sb){
		case COUNTRY : return person_1.getCountry().compareTo(person_2.getCountry());
		case NAME : return person_1.getLastName().compareTo(person_2.getLastName());
		}
		throw new RuntimeException("Practically unreachable code, can't be thrown");
	}
	
	public void setSortBy(sortBy sortBy){
		this.sb = sortBy;
	}
	
	
}
