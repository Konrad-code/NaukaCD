package zajecia12bootcamp;

public abstract class Bron {
	public String nazwa;
	protected int obrazenia;
	
	public Bron(String nazwa){
		this.nazwa = nazwa;
	}
	
	public String getNazwa() {
		return nazwa;
	}

	public void setObrazenia(int noweObrazenia) {
		this.obrazenia = noweObrazenia;
	}
	
	public int getObrazenia() {
		return this.obrazenia;
	}
	
	public abstract void setZadawaneObrazenia(int zadawaneObrazenia);
	
	public void zadawaneObrazenia() {
		System.out.println("Wywolales metode Bron.zadawaneObrazenia()");
	}
	
	@Override
	public String toString() {
		return "Bron [obrazenia = " + obrazenia + "]";
	}
	
}
