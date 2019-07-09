package topcoder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Hackathon {
	
	
	
	public void readFile () {
		
		System.out.println("main");
		
		String fileName = "D:\\google_prac\\topcoder\\src\\topcoder\\dictionary.txt";
				
		try (Stream <String> stream = Files.lines(Paths.get(fileName))) {
			
			//stream.forEach(System::println);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main (String [] args) {
		
		System.out.println("main");
		

	}

}
