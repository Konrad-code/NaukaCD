package zajecia10bootcampLogowanie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class ZaKrotkie extends Exception{
	ZaKrotkie(){
		System.out.println("Wprowadziles za krotkie haslo. Ma byc co najmniej 8 znakow");
	}
}

class BrakDuzej extends Exception{
	BrakDuzej(){
		System.out.println("Wprowadziles propozycje pozbawiona duzej litery. W hasle ma byc co najmniej 1 duza litera.");
	}
}

class BrakMalej extends Exception{
	BrakMalej(){
		System.out.println("Wprowadziles propozycje pozbawiona malej litery. W hasle ma byc co najmniej 1 mala litera.");
	}
}

class BrakCyfry extends Exception{
	BrakCyfry(){
		System.out.println("Wprowadziles propozycje pozbawiona cyfry. W hasle ma byc co najmniej 1 cyfra.");
	}
}

class BrakZnaku extends Exception{
	BrakZnaku(){
		System.out.println("Wprowadziles propozycje pozbawiona znaku. W hasle ma byc co najmniej 1 znak.");
	}
}

class ZnakNiedopuszczalny extends Exception{
	ZnakNiedopuszczalny(){
		System.out.println("Wprowadziles propozycje hasla zawierajaca niedopuszczalny znak.");
	}
}

public class Main10Logowanie {
	public static void main(String[] args) {
		
    	File baza = new File("C:\\Users\\mHm_MaXi\\Desktop\\AKADEMIA KODU\\bazaLogowania.txt");
		
    	HashMap<String, String> mapaHasel = new HashMap<>();
    	ArrayList<String> listaLoginow = new ArrayList<String>();
    	
    	String odczytaneHasla = "";
    	try{
            Scanner odczytHasel = new Scanner(baza);
            while(odczytHasel.hasNextLine()){
            	odczytaneHasla = odczytHasel.nextLine();
                String[] odczytTab = odczytaneHasla.split("#");
                mapaHasel.put(odczytTab[0], odczytTab[1]);
                listaLoginow.add(odczytTab[0]);
            }
            odczytHasel.close();
        }catch(FileNotFoundException ef){
            System.out.println("Brak hasel w bazie translatora (pusta baza = brak pliku)");
            ef.printStackTrace();
        }
		
		int licznikMalych = 0, licznikDuzych = 0, licznikZnakow = 0, licznikCyfr = 0;
		boolean a, b, c, d, e, f;
		a = b = c = d = e = f = true;
    	String wyraz;
    	System.out.println("Wprowadz dane: ");
    	Scanner input = new Scanner(System.in);
    	while(a && b && c && d && e && f) {
    		wyraz = input.nextLine();
    		licznikDuzych = licznikMalych = licznikCyfr = licznikZnakow = 0;
    		a = b = c = d = e = f = false;
    		try {
    			if(wyraz.length() < 8)
    				throw new ZaKrotkie();
    			for(int i = 0; i < wyraz.length(); i++) {
    				if((wyraz.charAt(i) <= 'Z') && (wyraz.charAt(i) >= 'A'))
    					licznikDuzych++;
    				if((wyraz.charAt(i) <= 'z') && (wyraz.charAt(i) >= 'a'))
    					licznikMalych++;
    				if((wyraz.charAt(i) <= 57) && (wyraz.charAt(i) >= 48))
    					licznikCyfr++;
    				if((wyraz.charAt(i) <= 47) && (wyraz.charAt(i) >= 33) || (wyraz.charAt(i)) <= 64 && (wyraz.charAt(i) >= 58))
    					licznikZnakow++;
    				if((licznikZnakow + licznikCyfr + licznikMalych + licznikDuzych) < i)
    					throw new ZnakNiedopuszczalny();
    			}
    			if(licznikDuzych < 1)
    				throw new BrakDuzej();
    			if(licznikMalych < 1)
    				throw new BrakMalej();
    			if(licznikCyfr < 1)
    				throw new BrakCyfry();
    			if(licznikMalych < 1)
    				throw new BrakZnaku();
    		}catch(ZaKrotkie mw) {
    			a = true;
    		}catch(BrakDuzej bd) {
    			b = true;
    		}catch(BrakMalej bm) {
    			c = true;
    		}catch(BrakCyfry bc) {
    			d = true;
    		}catch(BrakZnaku bz) {
    			e = true;
    		}catch(ZnakNiedopuszczalny zn) {
    			f = true;
    		}
    	}
    	a = b = c = d = e = f = true;
    	
    	while(input.hasNextLine()){
            wyraz = input.nextLine();
            String[] inputTab = wyraz.split(" ");
            String zapiszDo = inputTab[0];					// tutaj dorob getowanie z hashmapy, potem sklej zappenduj i wyswietl
            System.out.println(wyraz);
        }
    	input.close();
    	
	}
}
