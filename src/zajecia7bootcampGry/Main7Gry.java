package zajecia7bootcampGry;

import java.io.PrintWriter;
import java.nio.file.FileSystemNotFoundException;
import java.util.Scanner;

public class Main7Gry {
	public static void main(String[] args) {
		
		
		
		
		
		
		
		public static void zapiszDane(Gracz[] graczeDoZapisu) throws FileSystemNotFoundException{
			PrintWriter output = new PrintWriter("dane.txt");
			
			for(Gracz g: graczeDoZapisu) {
				output.print(g.getTag() + "@");
				for(Gra gra: g.getGry()) {
					output.print(gra.zapisDanych());
					output.print("@");
				}
			}
			
		public static void odczytajDane(Gracz[] graczeDoZapisu) throws FileSystemNotFoundException{
			Scanner input = new Scanner(new File("dane"));
			
			while(input.hasNextLine()) {
				String dana = input.nextLine();
				String[] danaTab = dana.split("@");
				String tagGracza = danaTab[0];
				
				for(int i = 0; i < danaTab.length - 1; i++) {
					String danaGra = danaTab[i];
					
					String[] danaGraTab = danaGra.split("#");
					Gra gra = new Gra(danaGraTab[0], danaGraTab[1], )
							
				}
				
				
			}
			
		}
	}
}
