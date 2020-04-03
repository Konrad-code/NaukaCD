package zajecia12bootcampPiotrekBronie;

abstract class Bron{
	
	protected int zadawaneObrazenia;
	private String nazwa;
	
	public Bron(String nazwa) {
		this.nazwa = nazwa;
	}

	protected String getNazwa() {
		return nazwa;
	}

	public int getZadawaneObrazenia() {
		return zadawaneObrazenia;
	}

	public abstract void setZadawaneObrazenia(int zadawaneObrazenia);

	@Override
	public String toString() {
		return "Bron [zadawaneObrazenia=" + zadawaneObrazenia + "]";
	}
}
