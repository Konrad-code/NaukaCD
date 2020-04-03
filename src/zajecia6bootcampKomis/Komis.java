package zajecia6bootcampKomis;

public class Komis {
	public Auto[] stan = {
			new Auto(1, "BMW", "E46", "sedan", 2.2, "benzyna", 2003, 260000, 25000, false),
			new Auto(2, "Renault", "Megane 2", "coupe", 1.9, "TDI", 2004, 230000, 3000, true),
			new Auto(3, "BMW", "E39", "touring", 2.5, "klekot", 1999, 300000, 8000, false),
			new Auto(4, "Maseratti", "Quattroporte", "GT", 4.0, "benzyna", 2004, 120000, 55000, false),
	};
	
	public void wypiszStan(){
		for(Auto s: stan)
			System.out.println(s + "\n\n");
		}
	
	public void dodajAuto(Auto noweAuto){
		Auto[] newTab = new Auto[stan.length + 1];
		for(int i = 0; i < stan.length; i++)
			newTab[i] = stan[i];
		
		newTab[newTab.length - 1] = noweAuto;
		noweAuto.setNumer(newTab.length);
		stan = newTab;
	}
	
	public void sprzedajAuto(int indeks){
		Auto[] pomniejszonyStan = new Auto[stan.length - 1];
		int j = 0;
		System.out.println("Auto do sprzedania o numerze: " + indeks + " znajdujace sie w tablicy pod indeksem: " + (indeks - 1));
		for(int i = 0; i < stan.length; i++)
			if((indeks - 1) != i) {
				System.out.println(i);
				pomniejszonyStan[j++] = stan[i];
//				pomniejszonyStan[j].setNumer(j + 1);	// nie wiem czemu to mi wysypuje NullPointerException :(
			}
		stan = pomniejszonyStan;
		for(int i = 0; i < stan.length; i++) {
			stan[i].setNumer(i + 1);
		}
	}

}
