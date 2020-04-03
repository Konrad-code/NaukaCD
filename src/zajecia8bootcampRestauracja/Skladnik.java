package zajecia8bootcampRestauracja;

public class Skladnik {
	private String[] skladnikiBurger = {"" , "ogorek", "jajko", "pomidor", "salata", "ser", "podwojny ser", "bekon", "kozi ser", "nachosy", "chorizo", "baklazan", "chalapeno"};
	private int[] cenySkladnikowBurger = {0,2,3,2,2,3,5,4,4,5,5,3,4};
	
	public Skladnik() {};

	public int getCenaSkladnikaBurger(int i) {
		return cenySkladnikowBurger[i];}
	
	public String getNazwaSkladnikaBurger(int i) {
		return skladnikiBurger[i];}
}