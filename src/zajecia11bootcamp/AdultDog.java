package zajecia11bootcamp;

public class AdultDog implements Dog{
	
	@Override
	public void bark(int iloscSzczekniec) {
		for(int i = 0; i < iloscSzczekniec; i++) {
			System.out.print("grrrr HAU ");
		}
		System.out.println();
	}
}
