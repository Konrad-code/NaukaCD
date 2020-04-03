package kartkowka2;

import java.util.ArrayList;

public class Potwor extends Postac{
	private boolean skasowanyPotwor = false;

	static ArrayList<Potwor> potwory = new ArrayList<Potwor>();
	
	public Potwor(int pozycjaX, int pozycjaY) {
		super(pozycjaX, pozycjaY);
		potwory.add(this);
	}
	
	public boolean getSkasowanyPotwor() {
		return skasowanyPotwor;
	}

	public void setSkasowanyPotwor(boolean skasowanyPotwor) {
		this.skasowanyPotwor = skasowanyPotwor;
	}

	private boolean czyMozeSieRuszyc(char[][] mapa) {
		int iterator = 0;
		// 	W
		if(getPozycjaX() == 0) {
			if(mapa[mapa.length - 1][this.getPozycjaY()] == ' ')
				iterator++;
		}else if(mapa[this.getPozycjaX() - 1][this.getPozycjaY()] == ' ') 
			iterator++;
		//	S
		if(getPozycjaX() == (mapa.length - 1)) {
			if(mapa[0][this.getPozycjaY()] == ' ')
				iterator++;
		}else if(mapa[this.getPozycjaX() + 1][this.getPozycjaY()] == ' ')
			iterator++;
		//	A
		if(getPozycjaY() == 0) {
			if(mapa[this.getPozycjaX()][mapa[getPozycjaX()].length - 1] == ' ')
				iterator++;
		}else if(mapa[this.getPozycjaX()][this.getPozycjaY() - 1] == ' ')
			iterator++;
		//	D
		if(getPozycjaY() == (mapa[getPozycjaX()].length - 1)) {
			if(mapa[this.getPozycjaX()][0] == ' ')
				iterator++;
		}else if(mapa[this.getPozycjaX()][this.getPozycjaY() + 1] == ' ') {
			iterator++;
		}
		
		if(iterator > 0) {
//			System.out.println("Mob moze sie ruszyc");
			return true;
		}
		else {
//			System.out.println("Mob nie moze sie ruszyc");
			return false;
		}
	}
	
	private char losujRuch() {
		char wylosowanyRuch = 'W';
		int wylosowanaLiczba = (int) ((Math.random() * 4) + 1);
//		System.out.println(wylosowanaLiczba);
		if(wylosowanaLiczba == 1)
			wylosowanyRuch = 'W';
		else if(wylosowanaLiczba == 2)
			wylosowanyRuch = 'S';
		else if(wylosowanaLiczba == 3)
			wylosowanyRuch = 'A';
		else if(wylosowanaLiczba == 4)
			wylosowanyRuch = 'D';
//		System.out.println(wylosowanyRuch);
		return wylosowanyRuch;
	}
	
	public char[][] ruszPotwora(char[][] mapa) {
		char[][] temp = mapa;
		if(czyMozeSieRuszyc(mapa)) {
			char ruch;
			do {
				ruch = losujRuch();
			}while(!(sprawdzRuch(ruch, mapa)));
			
			temp = wykonajRuch(ruch, mapa);
		}
		return temp;
	}
	
public boolean sprawdzRuch(char wprowadzonyRuch, char[][] mapa) {
		
		if(wprowadzonyRuch == 'W') {
			if(getPozycjaX() == 0) {
//				System.out.println("Probujesz przejsc przez sciane do gory");
				if(mapa[mapa.length - 1][this.getPozycjaY()] == ' ') {
//					System.out.println("Pozwalamy przejsc przez sciane do gory");
					return true;
				}
			}else if(mapa[this.getPozycjaX() - 1][this.getPozycjaY()] == ' ') {
				return true;
			}
		}else if(wprowadzonyRuch == 'S') {
			if(getPozycjaX() == (mapa.length - 1)) {
				if(mapa[0][this.getPozycjaY()] == ' ')
					return true;
			}else if(mapa[this.getPozycjaX() + 1][this.getPozycjaY()] == ' ') {
				return true;
			}
		}else if(wprowadzonyRuch == 'A') {
			if(getPozycjaY() == 0) {
				if(mapa[this.getPozycjaX()][mapa[getPozycjaX()].length - 1] == ' ')
					return true;
			}else if(mapa[this.getPozycjaX()][this.getPozycjaY() - 1] == ' ') {
				return true;
			}
		}else if(wprowadzonyRuch == 'D') {
			if(getPozycjaY() == (mapa[getPozycjaX()].length - 1)){
				if(mapa[this.getPozycjaX()][0] == ' ')
					return true;
			}else if(mapa[this.getPozycjaX()][this.getPozycjaY() + 1] == ' ') {
				return true;
			}
		}
		return false;
	}
	
	//	METODA ODPOWIADAJACA ZA RUCH OBIEKTOW KLASY Potwor NA GRANICACH MAPY - PRZECHODZENIE NA DRUGA STRONE PRZEZ SCIANY
	
	@Override
	public char[][] wykonajRuchGraniczny(char wprowadzonyRuch, char[][] mapa) {
		if(wprowadzonyRuch == 'W') {
			if(mapa[mapa.length - 1][this.getPozycjaY()] == ' ') {
				mapa[mapa.length - 1][this.getPozycjaY()] = 'K';
				mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
				this.moveW(mapa);
			}
			
		}else if(wprowadzonyRuch == 'S') {
			if(mapa[0][this.getPozycjaY()] == ' ') {
				mapa[0][this.getPozycjaY()] = 'K';
				mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
				this.moveS(mapa);
			}
			
		}else if(wprowadzonyRuch == 'A') {
			if(mapa[this.getPozycjaX()][mapa[getPozycjaX()].length - 1] == ' ') {
				mapa[this.getPozycjaX()][mapa[getPozycjaX()].length - 1] = 'K';
				mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
				this.moveA(mapa);
			}
			
		}else if(wprowadzonyRuch == 'D') {
			if(mapa[this.getPozycjaX()][0] == ' ') {
				mapa[this.getPozycjaX()][0] = 'K';
				mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
				this.moveD(mapa);
			}
		}
		return mapa;
	}
	
//	METODA ODPOWIADAJACA ZA RUCH OBIEKTOW KLASY Potwor
	
	@Override
	public char[][] wykonajRuch(char wprowadzonyRuch, char[][] mapa) {
		
		if(wprowadzonyRuch == 'W') {
			if(this.getPozycjaX() == 0) 
				wykonajRuchGraniczny(wprowadzonyRuch, mapa);
			else if(mapa[this.getPozycjaX() - 1][this.getPozycjaY()] == ' ') {
					mapa[this.getPozycjaX() - 1][this.getPozycjaY()] = 'K';
					mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
					this.moveW(mapa);
				}
			
		}else if(wprowadzonyRuch == 'S') {
			if(this.getPozycjaX() == (mapa.length - 1)) 
				wykonajRuchGraniczny(wprowadzonyRuch, mapa);
			else if(mapa[this.getPozycjaX() + 1][this.getPozycjaY()] == ' ') {
					mapa[this.getPozycjaX() + 1][this.getPozycjaY()] = 'K';
					mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
					this.moveS(mapa);
				}
			
		}else if(wprowadzonyRuch == 'A') {
			if(this.getPozycjaY() == 0) 
				wykonajRuchGraniczny(wprowadzonyRuch, mapa);
			else if(mapa[this.getPozycjaX()][this.getPozycjaY() - 1] == ' ') {
					mapa[this.getPozycjaX()][this.getPozycjaY() - 1] = 'K';
					mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
					this.moveA(mapa);
				}
			
		}else if(wprowadzonyRuch == 'D') {
			if(this.getPozycjaY() == (mapa[getPozycjaX()].length - 1)) 
				wykonajRuchGraniczny(wprowadzonyRuch, mapa);
			else if(mapa[this.getPozycjaX()][this.getPozycjaY() + 1] == ' ') {
					mapa[this.getPozycjaX()][this.getPozycjaY() + 1] = 'K';
					mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
					this.moveD(mapa);
				}
		}
		return mapa;
	}
}
