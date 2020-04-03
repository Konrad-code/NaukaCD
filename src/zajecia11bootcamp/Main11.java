package zajecia11bootcamp;

public class Main11 {
	
	public static void main(String[] args) {
		YoungDog youngDog = new YoungDog();
		OldDog oldDog = new OldDog();
		AdultDog adultDog = new AdultDog();
		
		youngDog.bark(5);
		oldDog.bark(10);
		adultDog.bark(15);
		
		Skirt skirt = new Skirt();
		Jeans jeans = new Jeans();
		Socks socks = new Socks();
		Jacket jacket = new Jacket();
		Hat hat = new Hat();
		hat.put();
		jeans.put();
		socks.put();
		skirt.put();
		jacket.put();
		
		Wear obiektWear = new Wear() {
			@Override
			public void put() {
			}
		};
		
		Wear[] wearTab = {socks, jeans, skirt, jacket, hat};
		
	}
}
