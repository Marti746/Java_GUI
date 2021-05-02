import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Emoticon class that draws faces on the canvas
 * @author David Martin
 *
 */
public class Emoticon extends JFrame {

	private innerEmoji canvas;
	
	/**
	 * Constructor for the Emoticon class
	 */
	public Emoticon() {
		// Create an object of the inner class
		canvas = new innerEmoji();
		add(canvas);
	}
	
	/**
	 * Inner class to draw the components of the smiley face to the frame
	 * @author David Martin
	 * paintComponenets where all the drawing will happen in
	 */
	class innerEmoji extends JComponent {
		public void paintComponent(Graphics g) {
			g.setColor(Color.YELLOW);
			g.fillOval(100, 100, 300, 300); // draw the background face
			g.setColor(Color.BLACK);
			g.fillOval(180, 150, 50, 50); // right eye
			g.fillOval(280, 150, 50, 50); // left eye
			g.setColor(Color.red);
			g.drawArc(180, 220, 150, 100, 180, 190); // draw smile 
			
			g.setColor(Color.YELLOW);
			g.fillOval(500, 100, 300, 300); // draw the background face
			g.setColor(Color.BLACK);
			g.fillOval(580, 150, 50, 50); // right eye
			g.fillOval(680, 150, 50, 50); // left eye
			g.setColor(Color.red);
			g.drawArc(580, 250, 150, 100, 180, -190); // draw frown 
			
			g.setColor(Color.YELLOW);
			g.fillOval(900, 100, 300, 300); // draw the background face
			g.setColor(Color.BLACK);
			g.fillOval(980, 150, 50, 50); // right eye
			g.fillOval(1080, 150, 50, 50); // left eye
			g.setColor(Color.red);
			g.drawOval(1025, 250, 50, 50); // draw open mouth
			
			g.setColor(Color.YELLOW);
			g.fillOval(1300, 100, 300, 300); // draw the background face
			g.setColor(Color.BLACK);
			g.fillOval(1380, 150, 50, 50); // right eye
			g.drawLine(1480, 180, 1520, 180); 
			g.setColor(Color.red);
			g.drawArc(1380, 220, 150, 100, 180, 190); // draw smile 
		}
	}
	
	public static void main(String[] args) {
		
		Emoticon smiles = new Emoticon();
		smiles.setSize(1800, 600);
		smiles.setTitle("Smiley Face Time");
		smiles.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		smiles.setVisible(true);
	}
	
}
