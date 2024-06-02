import java.awt.*;
import javax.swing.*;


public class BoardView extends JFrame {
	
	private JLabel display; //display of the board
	private JPanel buttonsPanel; //display of the buttons
	private JMenu options; //display the menu of options as a dropdown list
	
	public BoardView() {
		super("Deadwood");
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		options = new JMenu("Menu");
		menubar.add(options);
		
		JPanel displayPanel = new JPanel();
		add(displayPanel, BorderLayout.NORTH);
		
		display = new JLabel("Welcome to Deadwood");
		displayPanel.add(display);
		
		JMenuItem exitButton = new JMenuItem("Exit");
		options.add(exitButton);
		
		
		buttonsPanel = new JPanel();
		add(displayPanel, BorderLayout.NORTH);
		buttonsPanel.setLayout(new GridLayout(5, 1, 0, 0));
		String[] buttonStrings = {
								  "2 Players",
								  "3 Players",
								  "4 Players",
								  "5 Players",
								  "6 Players",
								  "7 Players",
								  "8 Players"
		};
		
		
	}

	public void registerListener(BoardController controller) {
		// TODO Auto-generated method stub
		
	}

}
