import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * CheckerGame class for putting everything onto the frame
 * @author David Martin
 *
 */
public class CheckerGame extends JFrame implements ActionListener {
	/**
	 * Instance variables for the CheckerGame frame
	 */
	private int WIDTH = 505;
	private int HEIGHT = 585;
	private JPanel panel, panelBottom;
	private JMenuBar menuBar;
	private JMenu menuGame, menuHelp;
	private JMenuItem newMenu, exitMenu, ruleMenu, aboutMenu;
	private CheckerBoard chB;
	private char[][] boardStatus = new char[][]{
		{'e','b','e','b','e','b','e','b'},
		{'b','e','b','e','b','e','b','e'},
		{'e','b','e','b','e','b','e','b'},
		{'e','e','e','e','e','e','e','e'},
		{'e','e','e','e','e','e','e','e'},
		{'r','e','r','e','r','e','r','e'},
		{'e','r','e','r','e','r','e','r'},
		{'r','e','r','e','r','e','r','e'}
	};

	/**
	 * Adds the components to the JFrame and adds all the buttons we need
	 * @throws IllegalCheckerboardArgumentException 
	 */
	private void createComponents() throws IllegalCheckerboardArgumentException {
		chB = new CheckerBoard(boardStatus);
		panelBottom = new JPanel(new GridLayout(2,1));
		//setSize(WIDTH, HEIGHT);
		
		// sets the lower bar to the screen
		JLabel statusBla = new JLabel("Number of Black Pieces: 12      Number of red Pieces: 12", JLabel.CENTER);
		//JLabel statusRed = new JLabel("Number of red Pieces:   12", JLabel.CENTER);
		JLabel infoLab = new JLabel("This game was developed by David Martin", JLabel.CENTER);
		panelBottom.add(statusBla);
		//panelBottom.add(statusRed);
		panelBottom.add(infoLab);
		
		// Game Menu bar
		menuBar = new JMenuBar();
		menuGame = new JMenu("Game");
		menuHelp = new JMenu("Help");
		newMenu = new JMenuItem("New");
		newMenu.addActionListener(this);
		exitMenu = new JMenuItem("Exit");
		exitMenu.addActionListener(this);
		ruleMenu = new JMenuItem("Checker Game Rules");
		ruleMenu.addActionListener(this);
		aboutMenu = new JMenuItem("About Checker Game App");
		aboutMenu.addActionListener(this);

		panel = new JPanel();

		menuGame.add(newMenu);
		menuGame.add(exitMenu);
		menuHelp.add(ruleMenu);
		menuHelp.add(aboutMenu);
		menuBar.add(menuGame);
		menuBar.add(menuHelp);

		// Adding components to the frame
		setJMenuBar(menuBar);
		//panel.add(statusBar, BorderLayout.SOUTH);
		panel.add(chB, BorderLayout.CENTER);
		add(chB, BorderLayout.CENTER);
		add(panelBottom, BorderLayout.SOUTH);
		//panel.add(infoLab);
		//this.add(panel);
	}

	public CheckerGame() throws IllegalCheckerboardArgumentException {
		createComponents();
		setSize(WIDTH, HEIGHT);
	}

	/**
	 * Main Branch that calls the other methods in order to put everything together
	 * @param args
	 * @throws IllegalCheckerboardArgumentException 
	 */
	public static void main(String[] args) throws IllegalCheckerboardArgumentException {
		JFrame frame = new CheckerGame();
		frame.setTitle("Checker Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * Action listener for the menu bar items
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str == "New") {
			JOptionPane.showMessageDialog(null, "This game is currently in beta for the playable version");
			//reset();
			//panel.setBackground(Color.RED);
		} else if (e.getActionCommand().equals("Exit")) {
			//exit
			dispose();
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} else if (str.equals("Checker Game Rules")) {
			//panel.setBackground(Color.BLUE);
			JOptionPane.showMessageDialog(null, "These are the riles of the game: \n Visit this site: https://www.ultraboardgames.com/checkers/game-rules.php");
		} else if (str.equals("About Checker Game App")) {
			// display name, address, and university name
			JOptionPane.showMessageDialog(null, "Game by: David Martin \nAddress: 650 High Street Benton \n        Miami Universtiy");
		}

	}

	/**
	 * Resets the checker board and all the related fields
	 */
	//private void reset() {
		//chB.reset(boardStatus);
	//}

}
