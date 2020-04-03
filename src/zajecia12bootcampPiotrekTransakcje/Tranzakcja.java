package zajecia12bootcampPiotrekTransakcje;

import java.util.ArrayList;

public class Tranzakcja {
	static ArrayList<Tranzakcja> tranzakcje = new ArrayList<Tranzakcja>();
	
	Klient kupujacy;
	Firma sprzedajacy;
	int kasa;
	
	public Tranzakcja(Klient k, Firma s, int kasa) {
		
		k.kasa -= kasa;
		s.kasa += kasa;
		
		this.kupujacy = k;
		this.sprzedajacy = s;
		this.kasa = kasa;
		tranzakcje.add(this);
	}
	
	@Override
	public String toString() {
		return "Tranzakcja [kupujacy=" + kupujacy + ", sprzedajacy=" + sprzedajacy + ", kasa=" + kasa + "]";
	}
}
