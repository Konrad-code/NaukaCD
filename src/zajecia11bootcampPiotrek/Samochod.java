package zajecia11bootcampPiotrek;

class Samochod implements Ruch {

	int pozycja = 0;

	@Override
	public void wykonajRuch(int iloscJednostek) {

		while (iloscJednostek > 0) {
			pozycja += (iloscJednostek/=10);
			System.out.printf("Samochód wykona³ ruch o %d\n", iloscJednostek);
		}
	}
}