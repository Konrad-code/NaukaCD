package zajecia7bootcampGry;

public class Gra {
	
	private String nazwa;
	private int rokProdukcji;
	private String dystrybutor;
	
	
	public Gra() {}



	public String getNazwa() {
		return nazwa;}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;}

	public int getRokProdukcji() {
		return rokProdukcji;}

	public void setRokProdukcji(int rokProdukcji) {
		this.rokProdukcji = rokProdukcji;}

	public String getDystrybutor() {
		return dystrybutor;}

	public void setDystrybutor(String dystrybutor) {
		this.dystrybutor = dystrybutor;}
	
	@Override
	public String toString() {
		return getNazwa();
	}
	
	public String zapisDanych() {
		return String.format("%s#%d#%s");
	}
	
}
