package zajecia11bootcamp;

public class OldDog implements Dog{
	
	@Override
	public void bark(int iloscSzczekniec) {
		for(int i = 0; i < iloscSzczekniec; i++) {
			System.out.print("hauuu ");
		}
		System.out.println();
	}
}
