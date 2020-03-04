package zajecia8bootcampGra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

class Gracz {

	private String nick;
	private String tag;
	private Gra[] gry;

	public Gracz(String nick, String tag) {
		this.nick = nick;
		this.tag = tag;
		this.gry = new Gra[0];
	}

	public void dodajGre(Gra gra) {
		Gra[] noweGry = new Gra[gry.length + 1];
		for (int i = 0; i < gry.length; i++)
			noweGry[i] = gry[i];

		noweGry[noweGry.length - 1] = gra;
		gry = noweGry;
	}

	public String getTag() {
		return tag;
	}

	public Gra[] getGry() {
		return gry;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nick: " + nick + "\n");
		sb.append("\tTag: " + tag + "\n");
		sb.append("\tGry: " + Arrays.toString(gry));
		return sb.toString();
	}

}

class Gra {

	private String tytul;
	private String wydawca;
	private int rokWydania;

	public Gra(String tytul, String wydawca, int rokWydania) {
		this.tytul = tytul;
		this.wydawca = wydawca;
		this.rokWydania = rokWydania;
	}

	@Override
	public String toString() {
		return tytul;
	}

	public String zapisDanych() {
		return String.format("%s#%s#%d", tytul, wydawca, rokWydania);
	}
}

public class Main8Gra {

	public static void main(String[] args) throws FileNotFoundException {
		Gracz[] gracze = { new Gracz("Wojownik", "R4323"), new Gracz("Ragnar", "R2345"), new Gracz("Fasolka2", "R9876"),
				new Gracz("Yoda", "R0021") };

//		zapiszDane(gracze);			// inicjalizacja pliku z lista powyzej utworzonych Graczy
		odczytDane(gracze);

		for (Gracz g : gracze)
			System.out.println(g);

		Scanner scanner = new Scanner(System.in);

		System.out.println("Podaj dane gry (Tytul@Wydawca@RokWydania): ");
		String daneGra = scanner.nextLine();

		System.out.println("Podaj numery graczy(nr1@nr2@nr3)");
		String graczeWGre = scanner.nextLine();

		String[] tabDaneGra = daneGra.split("@");
		System.out.println(Arrays.toString(tabDaneGra));
		Gra gra = new Gra(tabDaneGra[0], tabDaneGra[1], Integer.parseInt(tabDaneGra[2]));

		String[] tabGraczeWGre = graczeWGre.split("@");

		for (String idx : tabGraczeWGre)
			gracze[Integer.parseInt(idx)].dodajGre(gra);

		scanner.close();

		for (Gracz g : gracze)
			System.out.println(g);

		zapiszDane(gracze);

	}

	public static void odczytDane(Gracz[] gracze) throws FileNotFoundException {
		Scanner input = new Scanner(new File("dane"));

		while (input.hasNextLine()) {
			String dana = input.nextLine();
			String[] danaTab = dana.split("@");

			String tagGracza = danaTab[0];

			for (int i = 1; i < danaTab.length; i++) {
				String danaGra = danaTab[i];

				String[] danaGraTab = danaGra.split("#");
				Gra gra = new Gra(danaGraTab[0], danaGraTab[1], Integer.parseInt(danaGraTab[2]));

				for (Gracz g : gracze)
					if (g.getTag().equals(tagGracza))
						g.dodajGre(gra);
			}
		}
		input.close();

	}

	public static void zapiszDane(Gracz[] graczeDoZapisu) throws FileNotFoundException {
		PrintWriter output = new PrintWriter("dane");

		for (Gracz g : graczeDoZapisu) {
			output.print(g.getTag() + "@");
			for (Gra gra : g.getGry()) {
				output.print(gra.zapisDanych());
				output.print("@");
			}
			output.println("");
		}
		output.close();

	}

}
