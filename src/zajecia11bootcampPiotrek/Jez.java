package zajecia11bootcampPiotrek;

class Jez implements Ruch{

	int pozycja = 0;
	
	@Override
	public void wykonajRuch(int iloscJednostek) {
		while (iloscJednostek > 0) {
			pozycja += iloscJednostek--;
			System.out.printf("Je¿ wykona³ ruch o %d\n", iloscJednostek);
		}
	}
}