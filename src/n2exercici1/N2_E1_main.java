package n2exercici1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class N2_E1_main {

	public static void main(String[] args) throws ArrayIndexOutOfBoundsException, IOException {

		Properties properties= new Properties();
		
		try {
			properties.load(new FileInputStream(new File("src/n2exercici1/properties")));
			File dir = new File(properties.getProperty("DIR"));
			saveDirectoryFiles(dir, properties.getProperty("RES_DIR"), properties.getProperty("RES_NAME"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
	    } catch (IOException e2) {
	    	System.out.println(e2.getMessage());
	    } catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void saveDirectoryFiles(File dir, String outputDir, String outputName) {
		
		boolean error = false;
		String completePath = outputDir+outputName;
	    File[] fileList = dir.listFiles();
	    for (File f : fileList) {
	    	try {
				FileOutputStream files = new FileOutputStream(completePath);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(files));
				saveDirectoryFilesRec(dir, bw);
		        bw.close();
		    } catch (IOException e) {
		    	error = true;
		    	System.out.println(e.getMessage());
		    	System.out.println("Could not save the files on " + dir + " to the file " + outputDir+ outputName);
		    }
	    }
	    
	    if (!error) {
	    	System.out.println("Files saved on " + outputDir + outputName);
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
			System.out.println(e.getMessage());
	        System.out.println("Could not save the files on " + dir + " to the file " + nomFitxer);
	    }
	}

}
