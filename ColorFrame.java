import java.awt.Color;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * ColorFrame class that extends JFrame to make items of red, green, and blue
 * Create a “Colors” menu with three menu items: Red, Green, and Blue. The ColorFrame class also contains a JPanel object that changes to the
appropriate color when the user selects a menu item.
 * @author David Martin
 *
 */
public class ColorFrame extends JFrame implements ActionListener {

	final int WIDTH = 300;
	final int HEIGHT = 350;
	private JMenuBar menuBar;
	private JMenu menuColor;
	private JMenuItem menuItem1, menuItem2, menuItem3;
	private JPanel panel;
	
	public ColorFrame() {
		createComponents();
		setSize(WIDTH, HEIGHT);
	}
	
	/**
	 * Method to add the Menu components onto the menu bar and then add action listeners for the menuItems
	 */
	private void createComponents() {
		menuBar = new JMenuBar();
		menuColor = new JMenu("Colors");
		menuItem1 = new JMenuItem("Red");
		menuItem2 = new JMenuItem("Green");
		menuItem3 = new JMenuItem("Blue");
		
		panel = new JPanel();
		
		menuColor.add(menuItem1);
		menuColor.add(menuItem2);
		menuColor.add(menuItem3);
		menuBar.add(menuColor);
		
		setJMenuBar(menuBar);
		this.add(panel);
		
		menuItem1.addActionListener(this);
		menuItem2.addActionListener(this);
		menuItem3.addActionListener(this);
	}
	
	public static void main(String[] args) {
		// ColorFrame frame = new ColorFrame();
		JFrame frame = new ColorFrame();
		frame.setTitle("Colors");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

//	public void setBackground(Color color) {
//		
//	}

	/**
	 * actionPerfomer that checks to see which menuItem is pressed and changes the color to that color
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str == "Red") {
			panel.setBackground(Color.RED);
		} else if (str.equals("Green")) {
			panel.setBackground(Color.GREEN);
		} else if (str.equals("Blue")) {
			panel.setBackground(Color.BLUE);
		}
	}
}
