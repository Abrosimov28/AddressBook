package no.addressbook;
import java.util.Comparator;

import no.entities.Person;

public class FlexibleComparator implements Comparator<Person> {
	
	public enum SortBy {NAME, COUNTRY};
	private SortBy sb;
	
	
	@Override
	public int compare(Person person_1, Person person_2){
		switch(sb){
		case COUNTRY : return person_1.getCountry().compareTo(person_2.getCountry());
		case NAME : return person_1.getLastName().compareTo(person_2.getLastName());
		}
		throw new RuntimeException("Practically unreachable code, can't be thrown");
	}
	
	public void setSortBy(SortBy sortBy){
		this.sb = sortBy;
	}
	
	
}

// FileSystemPersonDAO
// PersonDAO


// abstrakne triedy
// musim overridovat iba metody co su abstrakt

// design pattern builder pattern
// abstrakna trieda je iba jedna
// 