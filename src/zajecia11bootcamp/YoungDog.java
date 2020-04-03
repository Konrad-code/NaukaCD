package zajecia11bootcamp;

public class YoungDog implements Dog{
	
	@Override
	public void bark(int iloscSzczekniec) {
		for(int i = 0; i < iloscSzczekniec; i++) {
			System.out.print("hau ");
		}
		System.out.println();
	}
}
