package zajecia12bootcamp;

public interface PosrednikBroniWybuchowej {
	public default void wybuchnij() {
		System.out.println("Zrobi�em bum!");
	}
	
	public void zadajObrazenia();	
}
