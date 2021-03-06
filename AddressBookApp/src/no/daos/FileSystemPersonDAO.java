package no.daos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import no.entities.Person;

public class FileSystemPersonDAO implements PersonDAO{

	public FileSystemPersonDAO() {
		
	}

	private static final String FILENAME = "data.txt";


	@Override
	public List<Person> loadPerson() throws IOException {
		List<Person> personList = new ArrayList<Person>();
		BufferedReader br = new BufferedReader(new FileReader(FILENAME));
		String[] entry = new String[5];
		while ((entry[0] = br.readLine()) != null) {
			for (int i = 1; i < 5; i++) {
				entry[i] = br.readLine();
			}
			personList.add(new Person(entry[0], entry[1], entry[2], entry[3], entry[4]));
		}
		br.close();
		return personList;
	}

	@Override
	public void savePerson(Person person) throws IOException {
		FileWriter fw = new FileWriter(FILENAME, true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);

		pw.println(person.getFirstName());
		pw.println(person.getLastName());
		pw.println(person.getAddress());
		pw.println(person.getCountry());
		pw.println(person.getPhone());

		pw.close();
		fw.close();
		pw.close();
	}
	
	@Override
	public void deletePerson(Person person) throws IOException{
		File write = new File("Temp.txt");
		BufferedReader br = new BufferedReader(new FileReader(FILENAME));
		BufferedWriter bw = new BufferedWriter(new FileWriter(write));
		PrintWriter pw = new PrintWriter(bw);
		String[] entry = new String[5];
		
		// loop will go through all Person objects in the file
		// if the found Person is the same as Person we are looking for, skip the writing of the person into temp file
		// else write the person into temp file
		while ((entry[0] = br.readLine()) != null
						&&  (entry[1] = br.readLine()) != null
						&&	(entry[2] = br.readLine()) != null
						&&	(entry[3] = br.readLine()) != null
						&&	(entry[4] = br.readLine()) != null){
			if (entry[0].equalsIgnoreCase(person.getFirstName())
					&& (entry[1].equalsIgnoreCase(person.getLastName()))
					&& (entry[2].equalsIgnoreCase(person.getAddress()))
					&& (entry[3].equalsIgnoreCase(person.getCountry()))
					&& (entry[4].equalsIgnoreCase(person.getPhone()))){
			}else{
				pw.println(entry[0]);
				pw.println(entry[1]);
				pw.println(entry[2]);
				pw.println(entry[3]);
				pw.println(entry[4]);
			}
		}
		br.close();
		Path f = FileSystems.getDefault().getPath(FILENAME);
		java.nio.file.Files.delete(f);
		pw.close();
		bw.close();
	    write.renameTo(new File(FILENAME));

	}

}
