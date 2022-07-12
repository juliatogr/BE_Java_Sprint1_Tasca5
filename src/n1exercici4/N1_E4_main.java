package n1exercici4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class N1_E4_main {

	public static void main(String[] args) throws ArrayIndexOutOfBoundsException, IOException {

		try {
			File dir = new File(args[0]);
			readFile(dir);
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			System.out.println("You must introduce a path when executing the file.");
			System.out.println("For example: java N1_E4_main.java D:/Documentos/file.txt");
		}
	}
	
	public static void readFile(File dir) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(dir));
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			br.close();
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
	    }
		
	}
}
