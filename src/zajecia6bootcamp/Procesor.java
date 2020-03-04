package zajecia6bootcamp;

public class Procesor {

	private double czestotliwoscTaktowania;
	private int iloscRdzeni;
	private int gwarancja;
	private String producent;
	
	Procesor(double czestotliwoscTaktowania, int iloscRdzeni, int gwarancja, String producent)
	{
		this.czestotliwoscTaktowania = czestotliwoscTaktowania;
		this.iloscRdzeni = iloscRdzeni;
		this.gwarancja = gwarancja;
		this.producent = producent;
	}
	
	public double getCzestotliwoscTaktowania() {
		return czestotliwoscTaktowania;}
	
	public void setCzestotliwoscTaktowania(double czestotliwoscTaktowania) {
		this.czestotliwoscTaktowania = czestotliwoscTaktowania;}
	
	public int getIloscRdzeni() {
		return iloscRdzeni;}
	
	public void setIloscRdzeni(int iloscRdzeni) {
		this.iloscRdzeni = iloscRdzeni;}
	
	public int getGwarancja() {
		return gwarancja;}
	
	public void setGwarancja(int gwarancja) {
		this.gwarancja = gwarancja;}
	
	public String getProducent() {
		return producent;}
	
	public void setProducent(String producent) {
		this.producent = producent;}
	
	@Override
	public String toString()
	{
		return "Zasilacz [czestotliwoscTaktowania = " + czestotliwoscTaktowania + ", iloscRdzeni = " + iloscRdzeni
				+ ", gwarancja = " + gwarancja + ", producent = " + producent + "]";
	}
}
