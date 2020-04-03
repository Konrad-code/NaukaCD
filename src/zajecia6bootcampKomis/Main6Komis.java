package zajecia6bootcampKomis;

import java.util.Scanner;

public class Main6Komis {
	
	public static void wypiszMenu() {
		System.out.println("1. Wyswietl stan aut na sprzedaz w komisie");
		System.out.println("2. Dokonaj sprzedazy auta do komisu");
		System.out.println("3. Dokonaj zakupu auta z komisu");
		System.out.println("4. Wyjdz z komisu");
	}
	
	public static void main(String[] args) {
		
		Komis komis = new Komis();
		System.out.println("Witaj w komisie \"U Z³odzieja\"\nWprowadz jak¹ operacjê chcesz wykonaæ:");
		boolean czyWyjdz = true;
		boolean czyDobryZnak = true;
		Scanner scanner = new Scanner(System.in);
		while(czyWyjdz) {
			int temp = 0;
			czyDobryZnak = true;
			wypiszMenu();
			System.out.println("Wybierz opcje z menu sposrod dostepnych opcji 1 - 4: ");
			while(czyDobryZnak)
			try {
				String wyrazOdczytany = scanner.nextLine();
				if(wyrazOdczytany.length() != 1 || (wyrazOdczytany.charAt(0) < '1' || wyrazOdczytany.charAt(0) > '4'))
					throw new MyException();
				temp = wyrazOdczytany.charAt(0) - 48;
				czyDobryZnak = false;
			}catch(MyException me) {
				czyDobryZnak = true;
    		}
			if(temp == 1)
				komis.wypiszStan();
			if(temp == 2) {
//				System.out.println("Dokonaj sprzedazy auta do komisu");
				int rocznik = 0, cena = 0, przebieg = 0;
				double pojemnosc = 0.0;
				String model = "", marka = "", paliwo = "", nadwozie = "";
				boolean stan = true, legitCheck = true;
				boolean czyMarka, czyNadwozie, czyPojemnosc, czyPaliwo, czyRocznik, czyPrzebieg, czyCena, czyStan;
				czyMarka = czyNadwozie = czyPojemnosc = czyPaliwo = czyRocznik = czyPrzebieg = czyCena = czyStan = true;
				while(czyMarka) {
					try {
						System.out.println("Podaj nazwe marki (Aby wyjsc wpisz \"exit\")");
						String wyraz = scanner.nextLine();
						if(wyraz.length() == 0)
							throw new ExceptionConstructorString();
						for(int i = 0; i < wyraz.length(); i++) 
							if(!((wyraz.charAt(i) < 'z' && wyraz.charAt(i) > 'a') || ((wyraz.charAt(i) < 'Z' && wyraz.charAt(i) > 'A'))))
								throw new ExceptionConstructorString();
						czyMarka = false;
						marka = wyraz;
					}catch(ExceptionConstructorString ecs) {
						czyMarka = true;
					}
					if(marka.equals("exit"))
						legitCheck = false;
				}
				if(legitCheck) {
					System.out.println("Podaj nazwe modelu (Aby wyjsc wpisz \"exit\")");
					model = scanner.nextLine();
					if(model.equals("exit"))
						legitCheck = false;
				}
				if(legitCheck)
					while(czyNadwozie) {
						try {
							System.out.println("Podaj typ nadwozia auta (Aby wyjsc wpisz \"exit\")");
							String wyraz = scanner.nextLine();
							if(wyraz.length() == 0)
								throw new ExceptionConstructorString();
							for(int i = 0; i < wyraz.length(); i++) {
								if(!((wyraz.charAt(i) < 'z' && wyraz.charAt(i) > 'a') || ((wyraz.charAt(i) < 'Z' && wyraz.charAt(i) > 'A'))))
									throw new ExceptionConstructorString();}
							czyNadwozie = false;
							nadwozie = wyraz;
						}catch(ExceptionConstructorString ecs) {
							czyNadwozie = true;
						}
						if(nadwozie.equals("exit"))
							legitCheck = false;
					}
				if(legitCheck)
					while(czyPojemnosc) {
						try {
							System.out.println("Podaj pojemnosc silnika auta (Aby wyjsc wpisz \"exit\")");
							String wyraz = scanner.nextLine();
							if(wyraz.length() == 0)
								throw new ExceptionConstructorString();
							wyraz = wyraz.replaceAll(",","").trim();
							wyraz = wyraz.replaceAll(" ", "");
							czyPojemnosc = false;
							if(wyraz.equals("exit"))
								pojemnosc = 0.0;
							else try {
							    pojemnosc = Double.parseDouble(wyraz);
							}catch (NumberFormatException e) {
								czyPojemnosc = true;
							}
						}catch(ExceptionConstructorString ecs) {
							czyPojemnosc = true;
						}
						if(pojemnosc == 0.0)
							legitCheck = false;
					}
				if(legitCheck)
					while(czyPaliwo) {
						try {
							System.out.println("Podaj typ paliwa auta (Aby wyjsc wpisz \"exit\")");
							String wyraz = scanner.nextLine();
							if(wyraz.length() == 0)
								throw new ExceptionConstructorString();
							for(int i = 0; i < wyraz.length(); i++) 
								if(!((wyraz.charAt(i) < 'z' && wyraz.charAt(i) > 'a') || ((wyraz.charAt(i) < 'Z' && wyraz.charAt(i) > 'A'))))
									throw new ExceptionConstructorString();
							czyPaliwo = false;
							paliwo = wyraz;
						}catch(ExceptionConstructorString ecs) {
							czyPaliwo = true;
						}
						if(paliwo.equals("exit"))
							legitCheck = false;
					}
				if(legitCheck)
					while(czyRocznik) {
						try {
							System.out.println("Podaj rok produkcji auta (Aby wyjsc wpisz \"exit\")");
							String wyraz = scanner.nextLine();
							if(wyraz.length() == 0)
								throw new ExceptionConstructorString();
							wyraz = wyraz.replaceAll(",","").trim();
							wyraz = wyraz.replaceAll(" ", "");
							czyRocznik = false;
							if(wyraz.equals("exit"))
								rocznik = 0;
							else {
								try {
									for(int i = 0; i < wyraz.length(); i++) 
										if(wyraz.charAt(i) > '0' && wyraz.charAt(i) < '9')
											throw new ExceptionConstructorNumber();
								}catch(ExceptionConstructorNumber ecn) {
									czyRocznik = true;
								}
								try {
								    rocznik = Integer.parseInt(wyraz);
								}catch (NumberFormatException e) {
									czyRocznik = true;
								}
								if(rocznik < 1885 || rocznik > 2020)
									throw new ExceptionConstructorNumber();
							}
						}catch(ExceptionConstructorString ecs) {
							czyRocznik = true;
						}catch(ExceptionConstructorNumber ecn) {
							czyRocznik = true;
						}
						if(rocznik == 0)
							legitCheck = false;
					}
				if(legitCheck)
					while(czyPrzebieg) {
						try {
							System.out.println("Podaj przebieg auta (Aby wyjsc wpisz \"exit\")");
							String wyraz = scanner.nextLine();
							if(wyraz.length() == 0)
								throw new ExceptionConstructorString();
							wyraz = wyraz.replaceAll(",","").trim();
							wyraz = wyraz.replaceAll(" ", "");
							czyPrzebieg = false;
							if(wyraz.equals("exit"))
								przebieg = 0;
							else {
								try {
									for(int i = 0; i < wyraz.length(); i++) 
										if(wyraz.charAt(i) > '0' && wyraz.charAt(i) < '9')
											throw new ExceptionConstructorNumber();
								}catch(ExceptionConstructorNumber ecn) {
									czyPrzebieg = true;
								}
								try {
								    przebieg = Integer.parseInt(wyraz);
								}catch (NumberFormatException e) {
									czyPrzebieg = true;
								}
								if(przebieg < 0 || przebieg > 1000000)
									throw new ExceptionConstructorNumber();
							}
						}catch(ExceptionConstructorString ecs) {
							czyPrzebieg = true;
						}catch(ExceptionConstructorNumber ecn) {
							czyPrzebieg = true;
						}
						if(przebieg == 0)
							legitCheck = false;
					}
				if(legitCheck)
					while(czyCena) {
						try {
							System.out.println("Podaj cene auta (Aby wyjsc wpisz \"exit\")");
							String wyraz = scanner.nextLine();
							if(wyraz.length() == 0)
								throw new ExceptionConstructorString();
							wyraz = wyraz.replaceAll(",","").trim();
							wyraz = wyraz.replaceAll(" ", "");
							czyCena = false;
							if(wyraz.equals("exit"))
								cena = 0;
							else {
								try {
									for(int i = 0; i < wyraz.length(); i++) 
										if(wyraz.charAt(i) > '0' && wyraz.charAt(i) < '9')
											throw new ExceptionConstructorNumber();
								}catch(ExceptionConstructorNumber ecn) {
									czyCena = true;
								}
								try {
								    cena = Integer.parseInt(wyraz);
								}catch (NumberFormatException e) {
									czyCena = true;
								}
								if(cena < 0 || cena > 300000)
									throw new ExceptionConstructorNumber();
							}
						}catch(ExceptionConstructorString ecs) {
							czyCena = true;
						}catch(ExceptionConstructorNumber ecn) {
							czyCena = true;
						}
						if(cena == 0)
							legitCheck = false;
					}
				if(legitCheck)
					while(czyStan) {
						try {
							System.out.println("Czy auto jest uszkodzone? Jesli tak to wpisz \"true\", jesli nie to wpisz \"false\"  (Aby wyjsc wpisz \"exit\")");
							String wyraz = scanner.nextLine();
							if(wyraz.length() == 0)
								throw new ExceptionConstructorString();
							if(!(wyraz.equals("true") || wyraz.equals("false") || wyraz.equals("exit")))
									throw new ExceptionConstructorString();
							if(wyraz.equals("true"))
								stan = true;
							else if (wyraz.equals("false"))
								stan = false;
							else
								legitCheck = false;
						}catch(ExceptionConstructorString ecs) {
							czyStan = true;
						}
					}
				if(legitCheck) {
					Auto sprzedaneAuto = new Auto(0, marka, model, nadwozie, pojemnosc, paliwo, rocznik, przebieg, cena, stan);
					komis.dodajAuto(sprzedaneAuto);
				}
			}
			if(temp == 3) {
				System.out.println("Auto o ktorym numerze chcesz kupic? (Wprowadz \"0\" aby wyjsc)");
				boolean czyPoprawna = true;
				int numerDoZakupu = 0;
				while(czyPoprawna) {
					try {
						String opcja = scanner.nextLine();
						System.out.println(opcja);
						if(opcja.length() != 1 || (opcja.charAt(0) < '0' || opcja.charAt(0) > komis.stan.length + 48))
							throw new ExceptionConstructorNumber();
						czyPoprawna = false;
						numerDoZakupu = opcja.charAt(0);
//						System.out.println("Numer do zakupu: " + numerDoZakupu);
					}catch(ExceptionConstructorNumber ecn) {
						czyPoprawna = true;
					}
				}
				if((char)numerDoZakupu != '0')
					komis.sprzedajAuto(numerDoZakupu - 48);
			}
			if(temp == 4) {
				System.out.println("Do widzenia");
				czyWyjdz = false;
			}
		}
		scanner.close();
		

		
	
		/*		
	        {      
	            System.out.println("Podaj swoje imie: ");
	            String imie = scanner.nextLine();
	            System.out.println("Podaj swoje nazwisko: ");
	            String nazwisko = scanner.nextLine();
	            System.out.println("Podaj swoj wiek: ");
	            int wiek = Integer.parseInt(scanner.nextLine());
	            System.out.println("Podaj swoja pensje: ");
	            double pensja = (double)Integer.parseInt(scanner.nextLine());
	
	            System.out.printf("Twoje dane to:\nImie: %s\nNazwisko %s\nWiek: %d\nPensja: %f\n", imie, nazwisko, wiek, pensja);
	            System.out.println("Potwierdz dane wpisujac T");
	
	            potwierdzenie = scanner.nextLine();
	        }while(warunek.equals(potwierdzenie) != true);
	        
	        // 2 ZADANIE Z LISTY
	        
	        System.out.println("Wprowadz pierwsza zmienna");
	        int pierwsza = Integer.parseInt(scanner.nextLine());
	        System.out.println("Wprowadz druga zmienna");
	        int druga = Integer.parseInt(scanner.nextLine());
	        
	        System.out.println((pierwsza + druga)/2);

	        // 3 ZADANIE Z LISTY
	        
	        System.out.println("Wprowadz liczbe miejsc");
	        int miejsca = Integer.parseInt(scanner.nextLine());
	        System.out.println("Wprowadz liczbe rzedow");
	        int rzedy = Integer.parseInt(scanner.nextLine());
	        
	        if(miejsca % rzedy == 0)
	            System.out.println("W jednym rzedzie mozna usadzic " + miejsca / rzedy + " osob");
	        else
	        {
	            int i = 0, j = 0;
	            i = miejsca / (rzedy - 1);
	            j = miejsca % (rzedy - 1);
	            System.out.printf("W samolocie jest %d rzedow obsadzonych po %d osob a w ostatnim rzedzie znajduje sie %d osob", rzedy - 1, i, j);
	        }
	        System.out.println();
	        
	        // 4 ZADANIE Z LISTY
	        
		 */
	
	
	
	
	
	
	
	}
}
