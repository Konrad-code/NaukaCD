package zajecia7bootcampGry;

import java.io.PrintWriter;
import java.nio.file.FileSystemNotFoundException;

public class Gracz {
	private String nick;
	private int numerIDGracza;
	private int iloscGodzin;
	Gra[] listaGier;
	
	public Gracz() {}
	
	public Gracz(String nick, int numerIDGracza, int iloscGodzin, Gra[] listaGier)
	{
		this.nick = nick;
		this.numerIDGracza = numerIDGracza;
		this.iloscGodzin = iloscGodzin;
		this.listaGier = listaGier;
	}
	
	public Gracz(Gra[] listaGier)
	{
		this("losowy gracz", 4, 400, listaGier);
	}

	public void dodajGre(Gra[] gra, Gra nowaGra) {
		int nowyRozmiar = listaGier.length + 1;
		Gra[] nowaTablica = new Gra[nowyRozmiar];
		for(int i = 0; i < gra.length; i++)
			nowaTablica[i] = gra[i];
		nowaTablica[nowaTablica.length - 1] = nowaGra;
		listaGier = nowaTablica;							// wazne - brakowalo mi tego
	}
	
	public int getNumerIDGracza() {
		return numerIDGracza;}

	public void setNumerIDGracza(int numerIDGracza) {
		this.numerIDGracza = numerIDGracza;}

	public String getNick() {
		return nick;}

	public void setNick(String nick) {
		this.nick = nick;}

	public int getIloscGodzin() {
		return iloscGodzin;}

	public void setIloscGodzin(int iloscGodzin) {
		this.iloscGodzin = iloscGodzin;
	}
	
	
	}
	
}
