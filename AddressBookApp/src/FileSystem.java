import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileSystem {

	public FileSystem() {

	}

	private static final String FILENAME = "data.txt";
	private AddressBook adb;

	public AddressBook readFile() throws IOException {
		adb = new AddressBook();
		BufferedReader br = new BufferedReader(new FileReader(FILENAME));
		String[] entry = new String[5];
		while ((entry[0] = br.readLine()) != null) {
			for (int i = 1; i < 5; i++) {
				entry[i] = br.readLine();
			}
			adb.addPerson(entry[0], entry[1], entry[2], entry[3], entry[4]);
		}
		br.close();
		return adb;
	}

	public void writeFile(Person person) throws IOException {
		FileWriter fw = new FileWriter(FILENAME, true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);

		pw.println(person.getFirstName());
		pw.println(person.getLastName());
		pw.println(person.getCountry());
		pw.println(person.getAddress());
		pw.println(person.getPhone());

		pw.close();
	}

}
