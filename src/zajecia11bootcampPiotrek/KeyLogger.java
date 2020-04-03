package zajecia11bootcampPiotrek;

class KeyLogger extends SzkodliweOprogramowanie{

	public KeyLogger(int stopienZagrozenia) {
		super(stopienZagrozenia);	
	}

	@Override
	public void wyrzadzSzkode() {
		System.out.println("Œledzê Twoj¹ dzia³alnoœæ na komputerze.");
	}

	@Override
	public void autoUsuniecie() {
		System.out.println("Kasujê siê.");
	}
}