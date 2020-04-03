package zajecia12bootcamp;

public class Kotek {
		String imie;
		static int numer = 0;
		int numerKotka = 0;
		private static Kotek single_instance = null;
		
		public Kotek(String imie) {
			this.imie = imie;
			this.numerKotka = numer;
			numer++;
	}
		
		private Kotek() {
			this.imie = "Koteczek";
		}
		
		public static Kotek getInstance()
	    {
	        if (single_instance == null)
	            single_instance = new Kotek();
	        return single_instance;
	    }
}
