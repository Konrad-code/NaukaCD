package zajecia8bootcampRestauracja;

public class BurgerMiesnyPastrami1 extends BurgerMiesnyPastrami{
	private static int masa;
	private static String nazwa;

	public BurgerMiesnyPastrami1() {
		super(nazwa, masa);
		BurgerMiesnyPastrami1.nazwa = "Pierwszy burger pastrami";
		BurgerMiesnyPastrami1.masa = 350;
	}
}
