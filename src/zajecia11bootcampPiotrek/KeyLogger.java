package zajecia11bootcampPiotrek;

class KeyLogger extends SzkodliweOprogramowanie{

	public KeyLogger(int stopienZagrozenia) {
		super(stopienZagrozenia);	
	}

	@Override
	public void wyrzadzSzkode() {
		System.out.println("�ledz� Twoj� dzia�alno�� na komputerze.");
	}

	@Override
	public void autoUsuniecie() {
		System.out.println("Kasuj� si�.");
	}
}