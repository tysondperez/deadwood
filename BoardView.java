/*

   Deadwood GUI helper file
   Author: Moushumi Sharmin
   This file shows how to create a simple GUI using Java Swing and Awt Library
   Classes Used: JFrame, JLabel, JButton, JLayeredPane

*/

import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.util.ArrayList;

@SuppressWarnings("removal")

public class BoardView extends JFrame {

   // JLabels
   JLabel boardlabel;
   JLabel cardlabel;
   JLabel playerlabels[];
   JLabel mLabel;
   JLabel daysLeftLabel;
   JLabel scenesLeftLabel;
   JLabel activePlayerLabel;
   JLabel creditsLabel;
   JLabel dollarsLabel;
   JLabel invalidLabel;
   
   //JButtons
   JButton bAct;
   JButton bRehearse;
   JButton bMove;
   JButton bTake;
   JButton bUpgrade;
   JButton bEnd;
   JButton white;
   
   JComboBox<String> adjLoc;
   boolean isUserInput;

   // JLayered Pane
   JLayeredPane bPane;
   
   public BoardController controller;

   // Constructor
   public BoardView() {
      // Set the title of the JFrame
      super("Deadwood");
      // Set the exit option for the JFrame
      setDefaultCloseOperation(EXIT_ON_CLOSE);
   
      // Create the JLayeredPane to hold the display, cards, dice and buttons
      bPane = getLayeredPane();
   
      // Create the deadwood board
      boardlabel = new JLabel();
      ImageIcon icon =  new ImageIcon("images/board.jpg");
      boardlabel.setIcon(icon); 
      boardlabel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
   
      // Add the board to the lowest layer
      bPane.add(boardlabel, new Integer(0));
   
      // Set the size of the GUI
      setSize(icon.getIconWidth()+200,icon.getIconHeight());
      
      // Add a scene card to this room
      cardlabel = new JLabel();
      ImageIcon cIcon =  new ImageIcon("images/cards/01.png");
      cardlabel.setIcon(cIcon); 
      cardlabel.setBounds(20,65,cIcon.getIconWidth()+2,cIcon.getIconHeight());
      cardlabel.setOpaque(true);
   
      // Add the card to the lower layer
      bPane.add(cardlabel, new Integer(1));
      
   
      // Create the Menu for action buttons
      mLabel = new JLabel("MENU");
      mLabel.setBounds(icon.getIconWidth()+40,0,110,20);
      bPane.add(mLabel,new Integer(2));

      // Create Action buttons
      bAct = new JButton("ACT");
      bAct.setBackground(Color.white);
      bAct.setBounds(icon.getIconWidth()+10, 30,110, 20);
      bAct.addMouseListener(new boardMouseListener());
      
      bRehearse = new JButton("REHEARSE");
      bRehearse.setBackground(Color.white);
      bRehearse.setBounds(icon.getIconWidth()+10,60,110, 20);
      bRehearse.addMouseListener(new boardMouseListener());
      
      bMove = new JButton("MOVE");
      bMove.setBackground(Color.white);
      bMove.setBounds(icon.getIconWidth()+10,90,110, 20);
      bMove.addMouseListener(new boardMouseListener());

      bTake = new JButton("TAKE ROLE");
      bTake.setBackground(Color.white);
      bTake.setBounds(icon.getIconWidth()+10,120,110, 20);
      bTake.addMouseListener(new boardMouseListener());

      bUpgrade = new JButton("UPGRADE");
      bUpgrade.setBackground(Color.white);
      bUpgrade.setBounds(icon.getIconWidth()+10,150,110, 20);
      bUpgrade.addMouseListener(new boardMouseListener());

      bEnd = new JButton("END TURN");
      bEnd.setBackground(Color.white);
      bEnd.setBounds(icon.getIconWidth()+10,180,110, 20);
      bEnd.addMouseListener(new boardMouseListener());

      // Place the action buttons in the top layer
      bPane.add(bAct, new Integer(2));
      bPane.add(bRehearse, new Integer(2));
      bPane.add(bMove, new Integer(2));
      bPane.add(bTake, new Integer(2));
      bPane.add(bUpgrade, new Integer(2));
      bPane.add(bEnd, new Integer(2));




      white = new JButton("WHITEEEEEEEE");
      white.setBackground(Color.white);
      white.setBounds(991,248,201, 194);
      white.setVisible(false);
      bPane.add(white, new Integer(2));


      // create status info labels
      daysLeftLabel = new JLabel();
      daysLeftLabel.setBounds(icon.getIconWidth()+10, 270,110, 10);
      bPane.add(daysLeftLabel,new Integer(2));

      // invalidLabel = new JLabel();
      // invalidLabel.setBounds(500, 400 ,200, 50);
      // invalidLabel.setVisible(false);
      // bPane.add(invalidLabel,new Integer(2));

      adjLoc = new JComboBox<String>();
      adjLoc.setBounds(icon.getIconWidth()+10, 30,110, 20);
      adjLoc.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED && isUserInput) {
               System.out.println("triggered selection: "+(String) adjLoc.getSelectedItem());
               controller.handleMovePicked((String) adjLoc.getSelectedItem());
            }
         }
      });
      bPane.add(adjLoc, new Integer(2));
      adjLoc.setVisible(false);

      scenesLeftLabel = new JLabel();
      scenesLeftLabel.setBounds(icon.getIconWidth()+10, 285,110, 10);
      bPane.add(scenesLeftLabel,new Integer(2));

      activePlayerLabel = new JLabel();
      activePlayerLabel.setBounds(icon.getIconWidth()+10, 330,110, 10);
      bPane.add(activePlayerLabel,new Integer(2));

      creditsLabel = new JLabel();
      creditsLabel.setBounds(icon.getIconWidth()+10, 345,110, 10);
      bPane.add(creditsLabel,new Integer(2));

      dollarsLabel = new JLabel();
      dollarsLabel.setBounds(icon.getIconWidth()+10, 360,110, 10);
      bPane.add(dollarsLabel,new Integer(2));
   }

  	public void displayStatus(int d, int s, int p, int c, int dol){
		daysLeftLabel.setText("Days Left: "+d);
		scenesLeftLabel.setText("Scenes Left: "+s);
		activePlayerLabel.setText("Player "+p+"\'s Turn");
		creditsLabel.setText("Credits: "+c);
		dollarsLabel.setText("Dollars: "+dol);
  	}

   public void createPlayers(int n, String [] colors){
      playerlabels = new JLabel[n];
      for (int i = 0; i < n; i++){
         playerlabels[i] = new JLabel();
         ImageIcon pIcon = new ImageIcon("images/dice/"+colors[i]+"1.png");
         playerlabels[i].setIcon(pIcon);
         playerlabels[i].setBounds((991 + (i%4)*pIcon.getIconWidth()),(248 + (i/4)*pIcon.getIconHeight()),pIcon.getIconWidth(),pIcon.getIconHeight());  
         playerlabels[i].setVisible(true);
         bPane.add(playerlabels[i],new Integer(3));
      }
   }

   // public void movePlayer(int n, int locX, int locY, int x, int y){
   //    if (n == 1){
	// 		return "r";
	// 	}
	// 	if (n == 2){
	// 		return "b";
	// 	}
	// 	if (n == 3){
	// 		return "g";
	// 	}
	// 	if (n == 4){
	// 		return "y";
	// 	}
	// 	if (n == 5){
	// 		return "o";
	// 	}
	// 	if (n == 6){
	// 		return "v";
	// 	}
	// 	if (n == 7){
	// 		return "c";
	// 	}
	// 	if (n == 8){
	// 		return "p";
	// 	}
	// 	return "";
   // }

   public void startTurn(ArrayList<Character> options){
      bAct.setVisible(options.contains('a'));
      bRehearse.setVisible(options.contains('r'));
      bMove.setVisible(options.contains('m'));
      bTake.setVisible(options.contains('t'));
      bUpgrade.setVisible(options.contains('u'));
   }

   public void showAdjLoc(boolean b){
      adjLoc.setVisible(b);
   }

   public void adjLocPopulate(String names[]){
      isUserInput = false;
      adjLoc.removeAllItems();
      adjLoc.addItem("--Select--");
      for (int i = 0; i < names.length; i++){
			if (names[i] != null){
				adjLoc.addItem(names[i]);
			}
		}
      isUserInput = true;
   }

   // public void actionInvalid(String s){
   //    //code that tells user the action they tried to take is invalid
   //    invalidLabel.setText("Sorry, you can't take the "+s+" action right now!\nSelect another option.");
   //    invalidLabel.setVisible(true);
   // }

   public void setController(BoardController controller){
        this.controller = controller;
   }
  
  // This class implements Mouse Events
  
   class boardMouseListener implements MouseListener{
      // Code for the different button clicks
      public void mouseClicked(MouseEvent e) {
         if (e.getSource()== bAct){
            System.out.println("Acting is Selected\n");
            controller.handleAct();
         }
         else if (e.getSource()== bRehearse){
            cardlabel.setVisible(true);
            System.out.println("Rehearse is Selected\n");
            controller.handleRehearse();
         }
         else if (e.getSource()== bMove){
            System.out.println("Move is Selected\n");
            controller.handleMove();
         }         
      }

      public void mousePressed(MouseEvent e) {
      }
      public void mouseReleased(MouseEvent e) {
      }
      public void mouseEntered(MouseEvent e) {
      }
      public void mouseExited(MouseEvent e) {
      }
   }
}
