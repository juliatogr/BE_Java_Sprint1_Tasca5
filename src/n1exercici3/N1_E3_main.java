package n1exercici3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class N1_E3_main {

	public static void main(String[] args) throws ArrayIndexOutOfBoundsException, IOException {

		try {
			File dir = new File(args[0]);
			saveDirectoryFiles(dir);
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			System.out.println("You must introduce a path when executing the file.");
			System.out.println("For example: java N1_E1_main.java src/n1exercici1");
		}
	}
	
	public static void saveDirectoryFiles(File dir) {
		
		String nomFitxer = "files.txt";
		boolean error = false;
		
	    File[] fileList = dir.listFiles();
	    for (File f : fileList) {
	    	try {
				FileOutputStream files = new FileOutputStream(nomFitxer);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(files));
				saveDirectoryFilesRec(dir, bw);
		        bw.close();
		    } catch (IOException e) {
		    	error = true;
		    	System.out.println("No s'han pogut guardar els fitxers  del directori en el fitxer" + nomFitxer);
		        e.printStackTrace();
		    }
	    }
	    
	    if (!error) {
	    	System.out.println("Fitxers guardats en el fitxer " + nomFitxer);
	    }
	}
	
	public static void saveDirectoryFilesRec(File dir, BufferedWriter bw) {
		
		String nomFitxer = "files.txt";
		
		String pattern = "yyyy-MM-dd hh:mm aa";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		Date lastModDate = new Date(dir.lastModified());
			
		try {
	        if (dir.isDirectory()) {
	        	bw.write("(D)" + dir.getName() + " Last Modified: " + simpleDateFormat.format(lastModDate));
	        	bw.newLine();
	        	for (File f : dir.listFiles()) {
		    		saveDirectoryFilesRec(f, bw);
		    	}
		    } else {
		    	bw.write("	(F)" + dir.getName() + " Last Modified: " + simpleDateFormat.format(lastModDate));
		    	bw.newLine();
		    }
	
		} catch (IOException e) {
	        System.out.println("No s'ha pogut guardar el fitxer del directori en el fitxer" + nomFitxer);
	        e.printStackTrace();
	    }
	}

}
