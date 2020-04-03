package kartkowka2;

public abstract class Postac {
	private int pozycjaX;
	private int pozycjaY;
	
	public Postac(int pozycjaX, int pozycjaY) {
		this.setPozycjaX(pozycjaX);
		this.setPozycjaY(pozycjaY);
	}
	public abstract char[][] wykonajRuchGraniczny(char wprowadzonyRuch, char[][] mapa);
	
	public abstract char[][] wykonajRuch(char wprowadzonyRuch, char[][] mapa);
	
	public abstract boolean sprawdzRuch(char wprowadzonyRuch, char[][] mapa);

	public void moveW(char[][] mapa) {
		if(getPozycjaX() == 0)
			setPozycjaX(mapa.length - 1);
		else
			setPozycjaX(getPozycjaX() - 1);
	}
	
	public void moveS(char[][] mapa) {
		if(getPozycjaX() == (mapa.length - 1))
			setPozycjaX(0);
		else
			setPozycjaX(getPozycjaX() + 1);
	}
	
	public void moveA(char[][] mapa) {
		if(getPozycjaY() == 0)
			setPozycjaY(mapa[getPozycjaX()].length - 1);
		else
			setPozycjaY(getPozycjaY() - 1);
	}
	
	public void moveD(char[][] mapa) {
		if(getPozycjaY() == (mapa[getPozycjaX()].length - 1))
			setPozycjaY(0);
		else
			setPozycjaY(getPozycjaY() + 1);
	}
	
	public int getPozycjaX() {
		return pozycjaX;
	}

	public void setPozycjaX(int pozycjaX) {
		this.pozycjaX = pozycjaX;
	}

	public int getPozycjaY() {
		return pozycjaY;
	}

	public void setPozycjaY(int pozycjaY) {
		this.pozycjaY = pozycjaY;
	}
}
