package zajecia12bootcamp;

public interface PosrednikBroniWybuchowej {
	public default void wybuchnij() {
		System.out.println("Zrobi³em bum!");
	}
	
	public void zadajObrazenia();	
}
