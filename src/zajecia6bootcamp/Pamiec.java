package zajecia6bootcamp;

class Pamiec{
	private double czestotliwoscTaktowania;
	private int iloscKosci;
	private String producent;
	
	public Pamiec(double czestotliwoscTaktowania, int iloscKosci, String producent) {
		this.czestotliwoscTaktowania = czestotliwoscTaktowania;
		this.iloscKosci = iloscKosci;
		this.producent = producent;
	}
	
	public double getCzestotliwoscTaktowania() {
		return czestotliwoscTaktowania;
	}
	public void setCzestotliwoscTaktowania(int czestotliwoscTaktowania) {
		this.czestotliwoscTaktowania = czestotliwoscTaktowania;
	}
	public int getIloscKosci() {
		return iloscKosci;
	}
	public void setIloscKosci(int iloscKosci) {
		this.iloscKosci = iloscKosci;
	}
	public String getProducent() {
		return producent;
	}
	public void setProducent(String producent) {
		this.producent = producent;
	}

	@Override
	public String toString() {
		return "Pamiec [czestotliwoscTaktowania = " + czestotliwoscTaktowania + ", iloscKosci = " + iloscKosci
				+ ", producent = " + producent + "]";
	}
	
}