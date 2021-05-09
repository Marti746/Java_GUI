import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * CheckerBoard class that assigns the checker board pattern 
 * @author David Martin
 *
 */
public class CheckerBoard extends JPanel {

	/**
	 * Instance Variables for the CheckerBoard class
	 */
	//	char[][] boardStatus = new char[][]{
	//	{'e','b','e','b','e','b','e','b'},
	//	{'b','e','b','e','b','e','b','e'},
	//	{'e','b','e','b','e','b','e','b'},
	//	{'e','e','e','e','e','e','e','e'},
	//	{'e','e','e','e','e','e','e','e'},
	//	{'r','e','r','e','r','e','r','e'},
	//	{'e','r','e','r','e','r','e','r'},
	//	{'r','e','r','e','r','e','r','e'}
	//	};
	char[][] boardStatus;
	JPanel panel = new JPanel(new GridLayout(8,8));

	/**
	 * Methods for the CheckerBoard class that assigns the pieces to the board in certain spots
	 * With getter and setter methods for the boardStatus
	 * @throws IllegalCheckerboardArgumentException 
	 */
	public CheckerBoard(char[][] boardStatus) throws IllegalCheckerboardArgumentException {
		this.boardStatus = new char[8][8];
		//boardStatus = new char[8][8]; // NullPointerException
		//setLayout = new gridLayout(8,8);
		setLayout(new GridLayout(8,8));
		Color checker;
		for (int i = 0; i < boardStatus.length; i++) { // j < boardStatus.length - 1 (this only give me 7 rows)
			if (i % 2 == 0) {
				checker = Color.white;
			} else {
				checker = Color.green;
			}
			for (int j = 0; j < boardStatus[i].length; j++) { //j < boardStatus.length -1
				//panel.setSize(60, 60);
				//panel.setBackground(checker);
				//boardStatus[i][j] = boardStatus[i][j];
				this.boardStatus[i][j] = boardStatus[i][j];
				//add(CheckerPiece);
				add(new CheckerPiece(i, j, boardStatus[i][j])); //this.boardStatus[i][j]
			} // end j for loop
		} // end i for loop
	}

	/**
	 * Setting the boardStatus to the boardStatus for the checker pattern
	 * @param boardStatus
	 */
	public void setBoardStatus(char [][] boardStatus) {
		// Both work but the top one seems like it would be filling in an Empty array over and over
		//this.setBoardStatus(boardStatus);
		this.boardStatus = boardStatus;
	} // end of setBoardStatus

	/**
	 * Assigning the status with the row and column the checker piece will be put on
	 * @param row
	 * @param column
	 * @param status
	 */
	public void setCheckerPiece(int row, int column, char status) {
		//this.row = row;
		boardStatus[row][column] = status;
		getCheckerPiece(row, column);
		//((CheckerPiece) this.getComponent(row * 8 + column)).setStatus(status);
	}

//	public char[][] getBoardStatus() {
//		return boardStatus;
//	}

	/**
	 * Gets the CheckerPiece object using the row and column of that checker square
	 * @param row 
	 * @param column
	 * @return 
	 */
	public CheckerPiece getCheckerPiece(int row, int column) {
		// have to cast it as a checkerPiece object
		return ((CheckerPiece) this.getComponent(row * 8 + column)); // (row * 8 + column * 8)
	}

}
