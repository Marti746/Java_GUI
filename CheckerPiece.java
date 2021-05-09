import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
/**
 * CheckerPiece class that assigns all the rows/columns and pieces on where they will be placed on the board
 * @author David Martin
 *
 */
public class CheckerPiece extends JComponent {
	/**
	 * Instance variables for CheckerPiece class
	 */
	private char status;
	private int row, column;
	private int heightSq = 60;
	private int length = 40;

	/**
	 * Method to verify if the row and column are valid as well as the status
	 * also checks to see if the player wants to put a checker on the white space
	 * @param row
	 * @param column
	 * @param status
	 * @throws IllegalCheckerboardArgumentException 
	 */
	public CheckerPiece(int row, int column, char status) throws IllegalCheckerboardArgumentException {
		if ((row < 0 || row > 8) || (column < 0 || column > 8)) {
			// checks to see if the row and columns are within the bounds of 0-7
			throw new IllegalCheckerboardArgumentException();
			//System.out.println("Sorry your row or column is above or below the bounds of the board!");
		} else if (status != 'r' && status != 'b' && status != 'e') {
			// checks to see if the status is in one of the status that is accepted
			throw new IllegalCheckerboardArgumentException();
			//System.out.println("Sorry your status is something other then what we accept!");
		} else if ((status == 'r' || status == 'b') && (row % 2 == 0 && column % 2 == 0)) {
			// makes sure that they aren' trying to put it on a white space by checking to see if row/column are even
			throw new IllegalCheckerboardArgumentException();
			//System.out.println("Did you know your pieces can't go on the white spaces!");
		} else {
			// assigns the variables if they pass the conditions
			this.row = row;
			this.column = column;
			this.status = status;
		}
	} // end of CheckerPiece

	/**
	 * Paints the squares of the CheckerBoard onto the scene
	 */
	@Override
	public void paintComponent(Graphics g) {
		// checks to see what column and row we are at to paint
		//if (column % 2 == 0 && row % 2 == 0) {
		if ((column + row) % 2 == 0) {
		//if (column % 2 == 0) {
			//if (row % 2 == 0) {
			// if they are both even then it paints it white
			g.setColor(Color.WHITE);
			repaint();
			//} else {
				//g.setColor(Color.GREEN);
			//}
		} else { // if (column % 2 == 1 && row % 2 == 1) {
			//if (row % 2 == 1) {
			// if they aren't then it paints it green
			g.setColor(Color.GREEN);
			repaint();
			//} else {
				//g.setColor(Color.WHITE);
			//}
		}

		// paints the rectangles using the assigned height we have the correct color
		g.fillRect(0, 0, heightSq, heightSq);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, heightSq, heightSq);
		repaint();

		// checks to see what status we are for the individual pieces we need to make
		if (status == 'e') {
			return;
		}
		if (status == 'b') {
			//g.fillOval(0, 0, length, length);
			g.setColor(Color.BLACK);
			repaint();
		}
		if (status == 'r') {
			//g.fillOval(0, 0, length, length);
			g.setColor(Color.RED);
			repaint();
		}
		g.fillOval(10, 10, length, length);
	} // end paintComponent()

	/**
	 * getter and setter method for the status variable
	 * @return
	 */
	public char getStatus() {
		return status;
	}
	
	public void setStatus(char status) {
		this.status = status;
	}

} // end CheckerPiece class
