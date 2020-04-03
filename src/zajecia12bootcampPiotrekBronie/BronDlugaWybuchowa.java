package zajecia12bootcampPiotrekBronie;

class BronDlugaWybuchowa extends BronDluga implements IBronWybuchowa{

	private int poleRazenia;
	
	public BronDlugaWybuchowa(String nazwa, int zadawaneObrazenia, int zasiegStrzalu, int poleRazenia) {
		super(nazwa, zadawaneObrazenia, zasiegStrzalu);
		this.poleRazenia = poleRazenia;
	}

	@Override
	public void zadajObrazenia() {
		System.out.println("Moge i wybuchaæ i strzelaæ!");
	}

	@Override
	public String toString() {
		return "BronDlugaWybuchowa [poleRazenia=" + poleRazenia + ", zadawaneObrazenia=" + zadawaneObrazenia + "]";
	}
}