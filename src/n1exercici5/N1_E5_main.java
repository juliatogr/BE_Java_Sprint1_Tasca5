package n1exercici5;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class N1_E5_main {

	public static void main(String[] args) throws ArrayIndexOutOfBoundsException, IOException, ClassNotFoundException {

		System.out.println("****Instantiating a person****");
		Person p1 = new Person("Marta", "Pons", 30);
		System.out.println(p1);
		
		System.out.println();
		
		System.out.println("Serializing & deserializing the person...");
		
	    FileOutputStream fileOutputStream = new FileOutputStream("test.ser");
	    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
	    objectOutputStream.writeObject(p1);
	    objectOutputStream.flush();
	    objectOutputStream.close();
	    
	    FileInputStream fileInputStream = new FileInputStream("test.ser");
	    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	    
	    System.out.println();
	    
	    System.out.println("****Deserialized person****");
	    Person p2 = (Person) objectInputStream.readObject();
	    System.out.println(p2);
	    objectInputStream.close(); 
	}
}
