package laberinto;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

	public class Juego extends JPanel{
		
		Laberinto laberinto = new Laberinto();
		Personaje personaje = new Personaje();
		
		public Juego() {
			addKeyListener(new KeyListener() {

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyPressed(KeyEvent e) {
					personaje.teclaPresionada(e);
				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
			setFocusable(true);
		}
		
		
		public void paint(Graphics grafico){
			grafico.clearRect(0, 0,getWidth(),getHeight());
			laberinto.paint(grafico);
			personaje.paint(grafico);
			personaje.paint(grafico);
		}
		
		public static void main(String[] args) {
			JFrame miventana = new JFrame("EL reto del laberinto");
			Juego game = new Juego();
			miventana.add(game);
			
			miventana.setSize(920,540);
			miventana.setLocation(300,200);
			miventana.setVisible(true);
			
			miventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			while(true) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException ex) {
					Logger.getLogger(Juego.class.getName()).log(Level.SEVERE,null, game);
				}
				game.repaint();
			}
		}
	}
