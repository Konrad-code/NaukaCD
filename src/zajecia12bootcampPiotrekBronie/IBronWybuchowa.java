package zajecia12bootcampPiotrekBronie;

interface IBronWybuchowa{
	public default void wybuchnij() {
		System.out.println("Zrobi�em bum!");
	}
	
	public void zadajObrazenia(); 
}