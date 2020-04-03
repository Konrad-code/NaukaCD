package zajecia11bootcampPiotrek;

class Rootkit extends SzkodliweOprogramowanie{

	public Rootkit(int stopienZagrozenia) {
		super(stopienZagrozenia);
	}

	@Override
	public void wyrzadzSzkode() {
		System.out.println("Wrprowadzam nieodwracalne zmiany w systemie.");
	}

	@Override
	public void autoUsuniecie() {
		System.out.println("Brak mo¿liwosci cywilizowanego usuniecia.");
	}
}