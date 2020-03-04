package zajecia6bootcamp;

public class Zasilacz {
	
	private double napiecie;
	private int moc;
	private int gwarancja;
	private String producent;
	
	Zasilacz(double napiecie, int moc, int gwarancja, String producent)
	{
		this.napiecie = napiecie;
		this.moc = moc;
		this.gwarancja = gwarancja;
		this.producent = producent;
	}
	
	public double getNapiecie() {
		return napiecie;}
	
	public void setnapiecie(double napiecie) {
		this.napiecie = napiecie;}
	
	public int getMoc() {
		return moc;}
	
	public void setMoc(int moc) {
		this.moc = moc;}
	
	public int getGwarancja() {
		return gwarancja;}
	
	public void setGwarancja(int gwarancja) {
		this.gwarancja = gwarancja;}
	
	public String producent() {
		return producent;}
	
	public void setProducent(String producent) {
		this.producent = producent;}
	
	@Override
	public String toString()
	{
		return "Zasilacz [napiecie = " + napiecie + ", moc = " + moc
		+ ", gwarancja = " + gwarancja + ", producent = " + producent + "]";
	}
	
}
