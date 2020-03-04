package zajecia6bootcampKomis;

public class Auto {

	private int numer;
	private String marka;
	private String model;
	private String nadwozie;
	private double pojemnoscSilnika;
	private String paliwo;
	private int rocznik;
	private int przebieg;
	private int cena;
	private boolean czyUszkodzony;
	
	public Auto(int numer, String marka, String model, String nadwozie, double pojemnoscSilnika, String paliwo, int rocznik, int przebieg, int cena, boolean czyUszkodzony) 
	{
		this.numer = numer;
		this.marka = marka;
		this.model = model;
		this.nadwozie = nadwozie;
		this.pojemnoscSilnika = pojemnoscSilnika;
		this.paliwo = paliwo;
		this.rocznik = rocznik;
		this.przebieg = przebieg;
		this.cena = cena;
		this.czyUszkodzony = czyUszkodzony;
	}
	
	public int getNumer() {
		return numer;}
	
	public void setNumer(int numer) {
		this.numer = numer;}
	
	public String getMarka() {
		return marka;}
	
	public void setMarka(String marka) {
		this.marka = marka;}
	
	public String getModel() {
		return model;}
	
	public void setModel(String model) {
		this.model = model;}
	
	public String getNadwozie() {
		return nadwozie;}
	
	public void setNadwozie(String nadwozie) {
		this.nadwozie = nadwozie;}
	
	public double getPojemnoscSilnika() {
		return pojemnoscSilnika;}
	
	public void setPojemnoscSilnika(double pojemnoscSilnika) {
		this.pojemnoscSilnika = pojemnoscSilnika;}
	
	public String getPaliwo() {
		return paliwo;}
	
	public void setPaliwo(String paliwo) {
		this.paliwo = paliwo;}
	
	public int getPrzebieg() {
		return przebieg;}
	
	public void setPrzebieg(int przebieg) {
		this.przebieg = przebieg;}
	
	public int getCena() {
		return cena;}
	
	public void setCena(int cena) {
		this.cena = cena;}
	
	public boolean getCzyUszkodzony() {
		return czyUszkodzony;}
	
	public void setCzyUszkodzony(boolean czyUszkodzony) {
		this.czyUszkodzony = czyUszkodzony;}
	
	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append("Numer: " + numer + "\n");
		result.append("Marka: " + marka + "\n");
		result.append("Model: " + model + "\n");
		result.append("Nadwozie: " + nadwozie + "\n");
		result.append("Pojemnosc silnika: " + pojemnoscSilnika + "\n");
		result.append("Paliwo: " + paliwo + "\n");
		result.append("Rok produkcji: " + rocznik + "\n");
		result.append("Przebieg: " + przebieg + "\n");
		result.append("Cena: " + cena + "\n");
		result.append("Stan: " + (!getCzyUszkodzony() ? " uszkodzony" : " nieuszkodzony") + "\n");
		
		return result.toString();
	}
}
