package practice;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Playground {

	
	
	public static String test () {
		
		
		
		//InputStream is = classLoader.getResourceAsStream(TASK_PIDS_VHM_MAPPING_FILE);
		InputStream is = null;
	    String vhmPidXmlJsonMap = null;
	    //if (is != null) {
	        vhmPidXmlJsonMap = new BufferedReader(new InputStreamReader(is))
	                .lines().parallel().collect(Collectors.joining("\n"));
	    //}
	    
	    System.out.println(vhmPidXmlJsonMap.toString());
	    
	    if (vhmPidXmlJsonMap != null) {
	    	return vhmPidXmlJsonMap.toString();
	    }
	    else return null;

	}
	
	
	public static void main (String [] args) {
		
		System.out.println("Test");
		
		test();
		
	}
}
