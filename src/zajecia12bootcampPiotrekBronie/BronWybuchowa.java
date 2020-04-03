package zajecia12bootcampPiotrekBronie;

class BronWybuchowa extends Bron implements IBronWybuchowa{

	private int poleRazenia;
	
	public BronWybuchowa(String nazwa, int poleRazenia) {
		super(nazwa);
		this.poleRazenia = poleRazenia;
	}

	@Override
	public void setZadawaneObrazenia(int zadawaneObrazenia) {
		super.zadawaneObrazenia = zadawaneObrazenia * poleRazenia;
	}

	@Override
	public void zadajObrazenia() {
		System.out.println("Moge wybuchaæ!");
	}

	@Override
	public String toString() {
		return "BronWybuchowa [poleRazenia=" + poleRazenia + ", zadawaneObrazenia=" + zadawaneObrazenia + "]";
	}
}