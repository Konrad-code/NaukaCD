package zajecia16Bootcamp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Pilka{
	int srednica;
	int wspX;
	int wspY;
	Color kolor;
	int kierunekX;
	int kierunekY;
	
	{
		kierunekX = 5;
		kierunekY = 3;
	}
	
	public Pilka(int srednica, int wspX, int wspY, Color kolor) {
		this.srednica = srednica;
		this.wspX = wspX;
		this.wspY = wspY;
		this.kolor = kolor;
	}
}


public class Main16 extends JPanel{
	
	// Graphics2D : https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics2D.html
	// Graphics : https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
	// ColorChooser 
	
	Pilka pilka = new Pilka(100, 50, 50, new Color(64, 50,168));
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(500, 500);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics2d = (Graphics2D)g;
		
		graphics2d.setColor(pilka.kolor);
		graphics2d.fillOval(pilka.wspX, pilka.wspY, pilka.srednica, pilka.srednica);
		
	}
	
	public void animacja() {
		while(true) {
			pilka.wspX = pilka.wspX + pilka.kierunekX;
			pilka.wspY = pilka.wspY + pilka.kierunekY;
			
			repaint();
			
			try {
				Thread.sleep(20);
			}catch(Exception exception) {}
		}
	}
	
	public static void main(String[] args) {
		JFrame window = new JFrame("Pileczka");
		Main16 panelRysowania = new Main16();
		
//		System.out.println(Toolkit.getDefaultToolkit().getScreenSize());
		
		window.getContentPane().add(panelRysowania);
		window.setLocation(200, 100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
		window.pack();
		
		panelRysowania.animacja();
		
	}
	
}