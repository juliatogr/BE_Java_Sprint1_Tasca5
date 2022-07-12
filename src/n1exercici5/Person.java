package n1exercici5;
import java.io.Serializable;

public class Person implements Serializable{
	private String name;
	private String surname;
	private int age;
	
	public Person(String name, String surname, int age){
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public int getAge() {
		return this.age;
	}

	@Override
	public String toString() {
		return name +" " + surname + ", " + age + " years old";
	}
	
	
}
