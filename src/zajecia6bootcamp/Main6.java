package zajecia6bootcamp;

public class Main6 {
	public static void main(String[] args)
	{
		Komputer k1 = new Komputer();
		k1.setRozmiarDysku(500);
		k1.setKartaGraficzna("GeForce GTX 1070Ti"); 
		k1.setEkran("LG 52263D");

		Procesor procesor1 = new Procesor(4.5, 4, 4, "Intel");
		Zasilacz zasilacz1 = new Zasilacz(120,4, 500, "Zalman");
		Pamiec pamiec1 = new Pamiec(3000, 4, "HyperX");
		Komputer k2 = new Komputer(procesor1, pamiec1, zasilacz1);
		
		k1.setPamiec(pamiec1);
		k1.setZasilacz(zasilacz1);
		k1.setProcesor(procesor1);
		
		System.out.println(k1);
		System.out.println(k2);
		
		
	}
}
