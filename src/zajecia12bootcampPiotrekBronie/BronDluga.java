package zajecia12bootcampPiotrekBronie;

class BronDluga extends Bron{

	private int zasiegStrzalu;

	public BronDluga(String nazwa, int zadawaneObrazenia, int zasiegStrzalu) {
		super(nazwa);
		setZasiegStrzalu(zasiegStrzalu);
		setZadawaneObrazenia(zadawaneObrazenia);
	}

	private void setZasiegStrzalu(int zasiegStrzalu) {
		this.zasiegStrzalu = zasiegStrzalu;
	}

	@Override
	public void setZadawaneObrazenia(int zadawaneObrazenia) {
		if(zadawaneObrazenia > 0) super.zadawaneObrazenia = zadawaneObrazenia / zasiegStrzalu;
	}

	@Override
	public String toString() {
		return "BronDluga [nazwa="+ super.getNazwa() + " zasiegStrzalu=" + zasiegStrzalu + ", zadawaneObrazenia=" + zadawaneObrazenia + "]";
	}	
}