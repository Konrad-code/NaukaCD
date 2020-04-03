package zajecia8bootcampRestauracjaPiotrekv2;

import java.util.Scanner;

class Produkt {
	private String nazwa;
	private double cena;

	public Produkt(String nazwa, double cena) {
		this.nazwa = nazwa;
		this.cena = cena;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nazwa + ", Cena: " + cena);
		
		return sb.toString();
	}
}

class Mieso extends Produkt {

	private int waga;

	public Mieso(String nazwa, double cena, int waga) {
		super(nazwa, cena);
		this.waga = waga;
	}

	@Override
	public String toString() {
		return super.toString() + ", [waga= " + waga + "gram]";
	}
}

class Dodatek extends Produkt {

	private boolean czyPremium;
	private int doplata = 2;
	
	public Dodatek(String nazwa, double cena) {
		super(nazwa, cena);
		this.czyPremium = czyPremium;

	}
	
	public Dodatek(String nazwa, double cena, boolean czyPremium) {
		super(nazwa, cena);
		this.czyPremium = czyPremium;

	}

	@Override
	public String toString() {
		return super.toString() + ", Premium: " + (czyPremium? "Tak, doplata=" + doplata + "z³ ": "Nie");
	}
}

class Napoj extends Dodatek{
	
	private int objetosc;
	
	public Napoj(String nazwa, double cena, int objetosc) {
		super(nazwa, cena);
		this.objetosc = objetosc;
	}

	@Override
	public String toString() {
		return super.toString() + "objetosc=" + objetosc;
	}
}

class Menu{
	
	private Produkt[] produkty;
	
	public Menu() {
		produkty = new Produkt[10];
		
		produkty[0] = new Mieso("Wieprzowina", 14, 100);
		produkty[1] = new Mieso("Wo³owina", 16, 100);
		produkty[2] = new Dodatek("Ziemniaczki", 6, false);
		produkty[3] = new Dodatek("Frytki", 7, true);
		produkty[4] = new Dodatek("Sa³atka Coles³aw", 5, false);
		produkty[5] = new Dodatek("Pomidory", 7, false);
		produkty[6] = new Dodatek("Mizeria", 9, false);
		produkty[7] = new Napoj("Cola", 8, 500);
		produkty[8] = new Napoj("Herbata",7, 400);
		produkty[9] = new Napoj("Fanta", 8, 500);
	}
	
	public void pokazMenu() {
		for(int i = 0; i < produkty.length; i++)
			System.out.printf("[%d] %s\n", i+1, produkty[i]);
	}
	
	public Produkt getProdukt(int idx) {
		return produkty[idx];
	}
}

class Koszyk{
	private Produkt[] produktyWKoszyku = new Produkt[0];
	
	public void dodajProdukt(Produkt nowyProdukt) {
		Produkt[] noweProdukty = new Produkt[produktyWKoszyku.length+1];
		
		for(int i = 0; i < produktyWKoszyku.length; i++) {
			noweProdukty[i] = produktyWKoszyku[i];
		}
		
		noweProdukty[noweProdukty.length-1] = nowyProdukt;
		produktyWKoszyku = noweProdukty;
	}
	
	public void pokazKoszyk() {
		for(int i = 0; i < produktyWKoszyku.length; i++)
			System.out.printf("[%d] %s\n", i+1, produktyWKoszyku[i]);
	}

	public void usunProdukt(int idx) {
		Produkt[] noweProdukty = new Produkt[produktyWKoszyku.length-1];
		int j = 0;
		
		for(int i =0; i < produktyWKoszyku.length; i++)
			if(idx != i)
				noweProdukty[j++] = produktyWKoszyku[i];
		
		produktyWKoszyku = noweProdukty;
	}
}
public class Bufet {

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.pokazMenu();
		
		String komenda;
		Scanner scanner = new Scanner(System.in);
		Koszyk koszyk = new Koszyk();
		
		do {
			komenda = scanner.nextLine();
			if(!komenda.equalsIgnoreCase("koniec")) {
				try{
					int idx = Integer.parseInt(komenda);
					koszyk.dodajProdukt(menu.getProdukt(idx-1));
				}catch(NumberFormatException e) {
					System.out.println("Wprowadziles niepoprawnie liczbe");
				}catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("Podales liczbe poza numeracja listy");
				}
			}
			
		}while(!komenda.equalsIgnoreCase("koniec"));
		
		koszyk.pokazKoszyk();
		
		do {
			System.out.println("Co usunac?");
			
			komenda = scanner.nextLine();
			try {
				if(!komenda.equalsIgnoreCase("koniec")) {
					int idx = Integer.parseInt(komenda);
					koszyk.usunProdukt(idx-1);
				}
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Chciales usunac pozycje wykraczajaca poza liste");
			} catch(NumberFormatException e) {
				System.out.println("Blednie wprowadziles numer pozycji do usuniecia. Podaj liczbe odpowiadajaca pozycji z listy");
			}
			koszyk.pokazKoszyk();
		}while(!komenda.equalsIgnoreCase("koniec"));
		koszyk.pokazKoszyk();
		
		scanner.close();
	}
}
