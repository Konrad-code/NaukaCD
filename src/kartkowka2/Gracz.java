package kartkowka2;

public class Gracz extends Postac{
	
	Gracz(int pozycjaX, int pozycjaY){
		super(pozycjaX, pozycjaY);
	}

	public boolean sprawdzRuch(char wprowadzonyRuch, char[][] mapa) {
		
		if(wprowadzonyRuch == 'W') {
			if(getPozycjaX() == 0) {
//				System.out.println("Probujesz przejsc przez sciane do gory");
				if((mapa[mapa.length - 1][this.getPozycjaY()] == ' ') || (mapa[mapa.length - 1][this.getPozycjaY()] == 'K')) {
//					System.out.println("Pozwalamy przejsc przez sciane do gory");
					return true;
				}
			}else if((mapa[this.getPozycjaX() - 1][this.getPozycjaY()] == ' ') || (mapa[this.getPozycjaX() - 1][this.getPozycjaY()] == 'K')) {
				return true;
			}
		}else if(wprowadzonyRuch == 'S') {
			if(getPozycjaX() == (mapa.length - 1)) {
				if((mapa[0][this.getPozycjaY()] == ' ') || (mapa[0][this.getPozycjaY()] == 'K'))
					return true;
			}else if((mapa[this.getPozycjaX() + 1][this.getPozycjaY()] == ' ') || (mapa[this.getPozycjaX() + 1][this.getPozycjaY()] == 'K')) {
				return true;
			}
		}else if(wprowadzonyRuch == 'A') {
			if(getPozycjaY() == 0) {
				if((mapa[this.getPozycjaX()][mapa[getPozycjaX()].length - 1] == ' ') || (mapa[this.getPozycjaX()][mapa[getPozycjaX()].length - 1] == 'K'))
					return true;
			}else if((mapa[this.getPozycjaX()][this.getPozycjaY() - 1] == ' ') || (mapa[this.getPozycjaX()][this.getPozycjaY() - 1] == 'K')) {
				return true;
			}
		}else if(wprowadzonyRuch == 'D') {
			if(getPozycjaY() == (mapa[getPozycjaX()].length - 1)){
				if((mapa[this.getPozycjaX()][0] == ' ') || (mapa[this.getPozycjaX()][0] == 'K'))
					return true;
			}else if((mapa[this.getPozycjaX()][this.getPozycjaY() + 1] == ' ') || (mapa[this.getPozycjaX()][this.getPozycjaY() + 1] == 'K')) {
				return true;
			}
		}
		return false;
	}
	
	//	METODA ODPOWIADAJACA ZA RUCH OBIEKTOW KLASY Gracz NA GRANICACH MAPY - PRZECHODZENIE NA DRUGA STRONE PRZEZ SCIANY
	
	@Override
	public char[][] wykonajRuchGraniczny(char wprowadzonyRuch, char[][] mapa) {
		if(wprowadzonyRuch == 'W') {
			if(mapa[mapa.length - 1][this.getPozycjaY()] == 'K') {
				boolean czyWeszlo = false;
				for(Potwor p: Potwor.potwory) {
					if(((mapa.length - 1) == p.getPozycjaX()) && (this.getPozycjaY() == p.getPozycjaY())) {
						p.setSkasowanyPotwor(true);
						czyWeszlo = true;
					}
				}
				if(czyWeszlo)
					System.out.println("Potwor skasowany, punkt dodany");
				mapa[mapa.length - 1][this.getPozycjaY()] = 'G';
				mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
				this.moveW(mapa);					
			}else if(mapa[mapa.length - 1][this.getPozycjaY()] == ' ') {
				mapa[mapa.length - 1][this.getPozycjaY()] = 'G';
				mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
				this.moveW(mapa);
			}
			
		}else if(wprowadzonyRuch == 'S') {
			if(mapa[0][this.getPozycjaY()] == 'K') {
				boolean czyWeszlo = false;
				for(Potwor p: Potwor.potwory) {
					if((0 == p.getPozycjaX()) && (this.getPozycjaY() == p.getPozycjaY())) {
						p.setSkasowanyPotwor(true);
						czyWeszlo = true;
					}
				}
				if(czyWeszlo)
					System.out.println("Potwor skasowany, punkt dodany");
				mapa[0][this.getPozycjaY()] = 'G';
				mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
				this.moveS(mapa);					
			}else if(mapa[0][this.getPozycjaY()] == ' ') {
				mapa[0][this.getPozycjaY()] = 'G';
				mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
				this.moveS(mapa);
			}
			
		}else if(wprowadzonyRuch == 'A') {
			if(mapa[this.getPozycjaX()][mapa[getPozycjaX()].length - 1] == 'K') {
				boolean czyWeszlo = false;
				for(Potwor p: Potwor.potwory) {
					if(((this.getPozycjaX()) == p.getPozycjaX()) && (mapa[getPozycjaX()].length - 1 == p.getPozycjaY())) {
						p.setSkasowanyPotwor(true);
						czyWeszlo = true;
					}
				}
				if(czyWeszlo)
					System.out.println("Potwor skasowany, punkt dodany");
				mapa[this.getPozycjaX()][mapa[getPozycjaX()].length - 1] = 'G';
				mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
				this.moveA(mapa);					
			}else if(mapa[this.getPozycjaX()][mapa[getPozycjaX()].length - 1] == ' ') {
				mapa[this.getPozycjaX()][mapa[getPozycjaX()].length - 1] = 'G';
				mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
				this.moveA(mapa);
			}
			
			
		}else if(wprowadzonyRuch == 'D') {
			if(mapa[this.getPozycjaX()][0] == 'K') {
				boolean czyWeszlo = false;
				for(Potwor p: Potwor.potwory) {
					if(((this.getPozycjaX()) == p.getPozycjaX()) && (0 == p.getPozycjaY())) {
						p.setSkasowanyPotwor(true);
						czyWeszlo = true;
					}
				}
				if(czyWeszlo)
					System.out.println("Potwor skasowany, punkt dodany");
				mapa[this.getPozycjaX()][0] = 'G';
				mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
				this.moveD(mapa);					
			}else if(mapa[this.getPozycjaX()][0] == ' ') {
				mapa[this.getPozycjaX()][0] = 'G';
				mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
				this.moveD(mapa);
			}
		}
		return mapa;
	}
	
//	METODA ODPOWIADAJACA ZA RUCH OBIEKTOW KLASY Gracz
	
	@Override
	public char[][] wykonajRuch(char wprowadzonyRuch, char[][] mapa) {
		//	W
		if(wprowadzonyRuch == 'W') {
			if(this.getPozycjaX() == 0) 
				wykonajRuchGraniczny(wprowadzonyRuch, mapa);
			else {
				if(mapa[this.getPozycjaX() - 1][this.getPozycjaY()] == 'K') {
					boolean czyWeszlo = false;
					for(Potwor p: Potwor.potwory) {
						if(((this.getPozycjaX() - 1) == p.getPozycjaX()) && (this.getPozycjaY() == p.getPozycjaY())) {
							p.setSkasowanyPotwor(true);
							czyWeszlo = true;
						}
					}
					if(czyWeszlo)
						System.out.println("Potwor skasowany, punkt dodany");
					mapa[this.getPozycjaX() - 1][this.getPozycjaY()] = 'G';
					mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
					this.moveW(mapa);					
				}else if(mapa[this.getPozycjaX() - 1][this.getPozycjaY()] == ' ') {
					mapa[this.getPozycjaX() - 1][this.getPozycjaY()] = 'G';
					mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
					this.moveW(mapa);
				}
			}
		//	S
		}else if(wprowadzonyRuch == 'S') {
			if(this.getPozycjaX() == (mapa.length - 1)) 
				wykonajRuchGraniczny(wprowadzonyRuch, mapa);
			else {
				if(mapa[this.getPozycjaX() + 1][this.getPozycjaY()] == 'K') {
					boolean czyWeszlo = false;
					for(Potwor p: Potwor.potwory) {
						if(((this.getPozycjaX() + 1) == p.getPozycjaX()) && (this.getPozycjaY() == p.getPozycjaY())) {
							p.setSkasowanyPotwor(true);
							czyWeszlo = true;
						}
					}
					if(czyWeszlo)
						System.out.println("Potwor skasowany, punkt dodany");
					mapa[this.getPozycjaX() + 1][this.getPozycjaY()] = 'G';
					mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
					this.moveS(mapa);					
				}else if(mapa[this.getPozycjaX() + 1][this.getPozycjaY()] == ' ') {
					mapa[this.getPozycjaX() + 1][this.getPozycjaY()] = 'G';
					mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
					this.moveS(mapa);
				}
			}
		//	A
		}else if(wprowadzonyRuch == 'A') {
			if(this.getPozycjaY() == 0) 
				wykonajRuchGraniczny(wprowadzonyRuch, mapa);
			else {
				if(mapa[this.getPozycjaX()][this.getPozycjaY() - 1] == 'K') {
					boolean czyWeszlo = false;
					for(Potwor p: Potwor.potwory) {
						if(((this.getPozycjaX()) == p.getPozycjaX()) && (this.getPozycjaY() - 1 == p.getPozycjaY())) {
							p.setSkasowanyPotwor(true);
							czyWeszlo = true;
						}
					}
					if(czyWeszlo)
						System.out.println("Potwor skasowany, punkt dodany");
					mapa[this.getPozycjaX()][this.getPozycjaY() - 1] = 'G';
					mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
					this.moveA(mapa);					
				}else if(mapa[this.getPozycjaX()][this.getPozycjaY() - 1] == ' ') {
					mapa[this.getPozycjaX()][this.getPozycjaY() - 1] = 'G';
					mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
					this.moveA(mapa);
				}
			}
		//	D
		}else if(wprowadzonyRuch == 'D') {
			if(this.getPozycjaY() == (mapa[getPozycjaX()].length - 1)) 
				wykonajRuchGraniczny(wprowadzonyRuch, mapa);
			else {
				if(mapa[this.getPozycjaX()][this.getPozycjaY() + 1] == 'K') {
					boolean czyWeszlo = false;
					for(Potwor p: Potwor.potwory) {
						if(((this.getPozycjaX()) == p.getPozycjaX()) && (this.getPozycjaY() + 1 == p.getPozycjaY())) {
							p.setSkasowanyPotwor(true);
							czyWeszlo = true;
						}
					}
					if(czyWeszlo)
						System.out.println("Potwor skasowany, punkt dodany");
					mapa[this.getPozycjaX()][this.getPozycjaY() + 1] = 'G';
					mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
					this.moveD(mapa);					
				}else if(mapa[this.getPozycjaX()][this.getPozycjaY() + 1] == ' ') {
					mapa[this.getPozycjaX()][this.getPozycjaY() + 1] = 'G';
					mapa[this.getPozycjaX()][this.getPozycjaY()] = ' ';
					this.moveD(mapa);
				}
			}
		}
		return mapa;
	}
}
