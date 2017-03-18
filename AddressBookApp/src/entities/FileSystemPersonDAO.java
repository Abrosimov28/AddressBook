package entities;

import java.io.IOException;
import java.util.ArrayList;

public interface FileSystemPersonDAO<T> {

	ArrayList<T> readFile() throws IOException;
	
	void writeFile(Person person) throws IOException;

	void deletePerson(Person person) throws IOException;
}
