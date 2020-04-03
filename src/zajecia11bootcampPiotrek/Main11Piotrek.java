package zajecia11bootcampPiotrek;

public class Main11Piotrek {
	
	public static void main(String[] args) {
		
		SzkodliweOprogramowanie szkodliweOprogramowanie = new SzkodliweOprogramowanie(5) {
			
			@Override
			public void wyrzadzSzkode() {
				System.out.println("Blokujê dostêp do internetu");
			}
			
			@Override
			public void autoUsuniecie() {
				System.out.println("Kasujê siê z dysku.");
			}
		};
		
		KeyLogger keyLogger = new KeyLogger(3);
		Rootkit rootkit = new Rootkit(7);
		
		SzkodliweOprogramowanie[] wirusy = {szkodliweOprogramowanie, keyLogger, rootkit};
		
		for(SzkodliweOprogramowanie so : wirusy)
			so.wyrzadzSzkode();
		
		Ruch ruch = new Ruch() {
			
			@Override
			public void wykonajRuch(int iloscJednostek) {
				System.out.println("Aninim wykona³ ruch.");
			}
		};
		
		Jez jez = new Jez();
		Samochod samochod = new Samochod();
		
		Ruch[] ruchome = {ruch, jez, samochod};
		
		for(Ruch r : ruchome)
			r.wykonajRuch(100);
	}
}
