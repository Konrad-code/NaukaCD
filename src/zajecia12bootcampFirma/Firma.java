package zajecia12bootcampFirma;

public class Firma {
	
	private int szmalec;
	private String nazwa;
	private static Firma single_instance = null;
	
	private Firma() {
		this.nazwa = "Biedronka";
	}
	
	public static Firma getInstance()						// IMPLEMENTACJA WZORCA SINGLETON
    {
        if (single_instance == null)
            single_instance = new Firma();
        return single_instance;
    }

	public String getNazwa() {
		return nazwa;
	}

	public int getSzmalec() {
		return szmalec;
	}

	private void setSzmalec(int szmalec) {
		this.szmalec = szmalec;
	}
	
	public void addSzmalec(int szmalec) {
		int nowySzmalec = 0;
		nowySzmalec = getSzmalec() + szmalec;
		setSzmalec(nowySzmalec);
	}
	
	private void removeSzmalec(int szmalec) {									// METODA REALIZUJACA WYPLATY DLA PRACOWNIKOW
		int nowySzmalec = 0;
		nowySzmalec = getSzmalec() - szmalec;
		if(nowySzmalec >= 0)
			setSzmalec(nowySzmalec);
		else {
			setSzmalec(0);
			System.out.println("Firmy nie stac na wyplaty pensji - bankructwo");
		}
	}
	
	public int liczDochodSprzedaz() {											// METODA OBLICZAJACA DOCHOD Z TRANSAKCJI
		int dochod = 0;
		for(Transakcja t : Transakcja.transakcje)
			if(t.czySiePowiodla)
				dochod += t.getHajs();
		return dochod;
	}
	
	public int liczKosztaPracownikow() {										// METODA OBLICZAJACA KOSZTA FIRMY - SUME WYPLAT DLA PRACOWNIKOW
		int koszt = 0;
		for(Pracownik p : Pracownik.pracownicy)
			koszt += p.getWynagrodzenie();
		return koszt;
	}
	
	public void skeszujWyplatyPracownikow(int szmalec) {						// METODA ZLECAJACA REALIZACJE WYPLAT DLA PRACOWNIKOW
		removeSzmalec(szmalec);
	}
	
	public int saldo() {														// METODA LICZACA I ZWRACAJACA SALDO
		int saldo = this.liczDochodSprzedaz() - this.liczKosztaPracownikow();
		return saldo;
	}
}
