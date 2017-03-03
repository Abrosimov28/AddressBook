import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileSystem {
	
	public FileSystem(){
		
	}
	
	private AddressBook adb;
	
	
	public AddressBook readFile() throws IOException{
		adb = new AddressBook();
		BufferedReader br = new BufferedReader(new FileReader("data.txt"));
		String line = null;
		String[] entry = new String[5];
		while ((entry[0] = br.readLine()) != null){
			 for (int i = 1; i<5; i++){
				 entry[i] = br.readLine();
			 }
			 adb.addPerson(entry[0], entry[1], entry[2], entry[3], entry[4]);
		}
		return adb;
		
	}
	
	
}
