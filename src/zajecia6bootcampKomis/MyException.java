package zajecia6bootcampKomis;

public class MyException extends Exception{
	public MyException() {
		System.out.println("Wprowdziles znak reprezentujacy probe wyboru opcji spoza dostepnych w menu");
	}
}
