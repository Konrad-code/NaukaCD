package zajecia8bootcampRestauracja;

public class BurgerMiesnyPastrami2 extends BurgerMiesnyPastrami{
	private static int masa;
	private static String nazwa;
	int[] skladniki = {1,4,7};
	
//	Skladnik skladnikZListy = new Skladnik();
	
	public BurgerMiesnyPastrami2() {
		super(nazwa, masa);
		BurgerMiesnyPastrami2.nazwa = "Drugi burger pastrami";
		BurgerMiesnyPastrami2.masa = 400;
	}
	
	{
		for(int i = 0; i < skladniki.length; i++) {
			cena += skladnikZListy.getCenaSkladnikaBurger(skladniki[i]);
//			System.out.println(skladnikZListy.getNazwaSkladnikaBurger(skladniki[i]));
	}
	}
}