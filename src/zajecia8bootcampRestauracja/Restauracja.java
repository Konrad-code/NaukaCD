package zajecia8bootcampRestauracja;

public class Restauracja {
	public static void main(String[] args) {
		
		BurgerMiesnyPastrami burger1 = new BurgerMiesnyPastrami1();
		System.out.println(burger1.cena);
		BurgerMiesnyWolowina burger2 = new BurgerMiesnyWolowina("Burgerek", 400);
		System.out.println(burger2.cena);
		BurgerWege burger3 = new BurgerWege("Burgerek", 400);
		System.out.println(burger3.cena);
		BurgerMiesnyPastrami2 burger4 = new BurgerMiesnyPastrami2();
		System.out.println(burger4.cena);
	}
}
