package zajecia11bootcamp;

import java.util.ArrayList;

public class Person {
	private String name;
	ArrayList<Wear> listaCiuchow = new ArrayList<Wear>();
	
	public Person(String name) {
		this.name = name;
	}
	
	public void addWear(Wear wear) {
		listaCiuchow.add(wear);
	}
	
	public void dressUp(String[] ubrania) {
		System.out.println("Imie to: " + name);
			for(Wear l : listaCiuchow) {
			System.out.println();
	}
	
	}
}
