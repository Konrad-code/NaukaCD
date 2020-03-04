package zajecia6bootcamp;

public class Komputer {
	Procesor procesor;
	private Pamiec pamiec;
	private int rozmiarDysku;
	private String ekran;
	private String kartaGraficzna;
	Zasilacz zasilacz;

	public Komputer() {};
	
	public Komputer(Procesor procesor, Pamiec pamiec, Zasilacz zasilacz)
	{
		this.procesor = procesor;
		this.pamiec = pamiec;
		this.zasilacz = zasilacz;
	}
	
	public Komputer(Procesor procesor)
	{
		this(procesor, null, null);
	}
	
	public String getKartaGraficzna() {
		return kartaGraficzna;}
	
	public void setKartaGraficzna(String kartaGraficzna) {
		this.kartaGraficzna = kartaGraficzna;}
	
	public Zasilacz getZasilacz() {
		return zasilacz;}
	
	public void setZasilacz(Zasilacz zasilacz) {
		this.zasilacz = zasilacz;}
	
	public Procesor getProcesor() {
		return procesor;}
	
	public void setProcesor(Procesor procesor) {
		this.procesor = procesor;}
	
	public String getEkran() {
		return ekran;}
	
	public void setEkran(String ekran) {
		this.ekran = ekran;	}
	
	public Pamiec getPamiec(){
		return pamiec;}
	
	public void setPamiec(Pamiec pamiec){
		this.pamiec = pamiec;}
	
	public void setRozmiarDysku(int rozmiar){
		if(rozmiar > 0)
			this.rozmiarDysku = rozmiar;}
	
	public int getRozmiarDysku(){
		return rozmiarDysku;}
	
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append("Rozmiar procesora to: " + procesor + "\n");
		result.append("Rozmiar pamieci to: " + pamiec + "\n");
		result.append("Rozmiar zasilacza to: " + zasilacz + "\n");
		
		return result.toString();
	}
	

}