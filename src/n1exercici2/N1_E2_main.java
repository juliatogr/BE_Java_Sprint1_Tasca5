package n1exercici2;

import java.io.File;
import java.io.IOException;

public class N1_E2_main {

	public static void main(String[] args) throws ArrayIndexOutOfBoundsException, IOException {

		try {
			
			File dir = new File("D:/Documentos/Estudis");
		    File[] fileList = dir.listFiles();
		    for (File f : fileList) {
		    	printDirectoryFiles(f);
		    }

		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			System.out.println("You must introduce a path when executing the file.");
			System.out.println("For example: java N1_E1_main.java src/n1exercici1");
		}
	}
	
	public static void printDirectoryFiles(File dir) {
		if (dir.isDirectory()) {
			System.out.println("(D)" + dir.getName());
	    	for (File f : dir.listFiles()) {
	    		printDirectoryFiles(f);
	    	}
	    } else {
	    	System.out.println("	(F)" + dir.getName());
	    }
	}
	

}
