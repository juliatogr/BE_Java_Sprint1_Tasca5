package n1exercici1;

import java.io.File;
import java.io.IOException;

public class N1_E1_main {

	public static void main(String[] args) throws ArrayIndexOutOfBoundsException, IOException {

		try {
			
			File dir = new File(args[0]);
		    File[] fileList = dir.listFiles();
		    for (File f : fileList) {
		    	System.out.println(f.getName());
		    }

		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			System.out.println("You must introduce a path when executing the file.");
			System.out.println("For example: java N1_E1_main.java D:/Documentos");
		}
	}

}
