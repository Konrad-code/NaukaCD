package zajecia12bootcampPiotrekBronie;

interface IBronWybuchowa{
	public default void wybuchnij() {
		System.out.println("Zrobi³em bum!");
	}
	
	public void zadajObrazenia(); 
}