package zajecia11bootcampPiotrek;

abstract class SzkodliweOprogramowanie {
	
	private int stopienZagrozenia;
	public abstract void wyrzadzSzkode();
	public abstract void autoUsuniecie();
	
	public SzkodliweOprogramowanie(int stopienZagrozenia) {
		this.stopienZagrozenia = stopienZagrozenia;
	}
}
