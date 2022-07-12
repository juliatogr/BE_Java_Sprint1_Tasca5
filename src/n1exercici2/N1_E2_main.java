package n1exercici2;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class N1_E2_main {

	public static void main(String[] args) throws ArrayIndexOutOfBoundsException, IOException {

		try {
			
			File dir = new File(args[0]);
		    File[] fileList = dir.listFiles();
		    for (File f : fileList) {
		    	printDirectoryFiles(f);
		    }

		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			System.out.println("You must introduce a path when executing the file.");
			System.out.println("For example: java N1_E2_main.java D:/Documentos");
		}
	}
	
	public static void printDirectoryFiles(File dir) {
		
		String pattern = "yyyy-MM-dd hh:mm aa";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		Date lastModDate = new Date(dir.lastModified());
		
		if (dir.isDirectory()) {
			System.out.println("(D)" + dir.getName() + " Last Modified: " + simpleDateFormat.format(lastModDate));
	    	for (File f : dir.listFiles()) {
	    		printDirectoryFiles(f);
	    	}
	    } else {
	    	System.out.println("	(F)" + dir.getName() + " Last Modified: " + simpleDateFormat.format(lastModDate));
	    }
	}	

}
