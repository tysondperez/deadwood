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
   JLabel roomlabel;
   JLabel takeslabel;
   JLabel partslabel;
   JLabel ranklabel;
   
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
      ImageIcon icon =  new ImageIcon("src/images/board.jpg");
      boardlabel.setIcon(icon); 
      boardlabel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
   
      // Add the board to the lowest layer
      bPane.add(boardlabel, new Integer(0));
   
      // Set the size of the GUI
      setSize(icon.getIconWidth()+200,icon.getIconHeight());
      //------------------------------------------------------------Create locations on board-----------------  
      //Set Train Station with assets
      roomlabel = new JLabel("Train Station");
      roomlabel.setBounds(21, 69, 205, 115);
      bPane.add(roomlabel, new Integer(1)); //lower layer?
      
      takeslabel = new JLabel("3");
      takeslabel.setBounds(36, 11, 47, 47);
      bPane.add(takeslabel, new Integer(1));
      takeslabel = new JLabel("2");
      takeslabel.setBounds(89, 11, 47, 47);
      bPane.add(takeslabel, new Integer(1));
      takeslabel = new JLabel("1");
      takeslabel.setBounds(141, 11, 47, 47);
      bPane.add(takeslabel, new Integer(1));
      
      partslabel = new JLabel("Crusty Prospector");
      partslabel.setBounds(114, 227, 46, 46);
      bPane.add(partslabel, new Integer(1));
      partslabel = new JLabel("Dragged by Train");
      partslabel.setBounds(51, 268, 46, 46);
      bPane.add(partslabel, new Integer(1));
      partslabel = new JLabel("Preacher with Bag");
      partslabel.setBounds(114, 320, 46, 46);
      bPane.add(partslabel, new Integer(1));
      partslabel = new JLabel("Cyrus the Gunfighter");
      partslabel.setBounds(49, 356, 46, 46);
      bPane.add(partslabel, new Integer(1));
      
      //Set Secret Hideout with assets
      roomlabel = new JLabel("Secret Hideout");
      roomlabel.setBounds(27, 732, 205, 115);
      bPane.add(roomlabel, new Integer(1));
      
      takeslabel = new JLabel("3");
      takeslabel.setBounds(244, 764, 47, 47);
      bPane.add(takeslabel, new Integer(1));
      takeslabel = new JLabel("2");
      takeslabel.setBounds(299, 764, 47, 47);
      bPane.add(takeslabel, new Integer(1));
      takeslabel = new JLabel("1");
      takeslabel.setBounds(354, 764, 47, 47);
      bPane.add(takeslabel, new Integer(1));
      
      partslabel = new JLabel("Clumsy Pit Fighter");
      partslabel.setBounds(435, 719, 46, 46);
      bPane.add(partslabel, new Integer(1));
      partslabel = new JLabel("Thug with Knife");
      partslabel.setBounds(521, 719, 46, 46);
      bPane.add(partslabel, new Integer(1));
      partslabel = new JLabel("Dangerous Tom");
      partslabel.setBounds(435, 808, 46, 46);
      bPane.add(partslabel, new Integer(1));
      partslabel = new JLabel("Penny, who is lost");
      partslabel.setBounds(521, 808, 46, 46);
      bPane.add(partslabel, new Integer(1));
      
      //Create Church with assets
      roomlabel = new JLabel("Church");
      roomlabel.setBounds(623, 734, 205, 115);
      bPane.add(roomlabel, new Integer(1));
      
      takeslabel = new JLabel("2");
      takeslabel.setBounds(623, 675, 47, 47);
      bPane.add(takeslabel, new Integer(1));
      takeslabel = new JLabel("1");
      takeslabel.setBounds(682, 675, 47, 47);
      bPane.add(takeslabel, new Integer(1));
      
      partslabel = new JLabel("Dead Man");
      partslabel.setBounds(857, 730, 46, 46);
      bPane.add(partslabel, new Integer(1));
      partslabel = new JLabel("Crying Woman");
      partslabel.setBounds(858, 809, 46, 46);
      bPane.add(partslabel, new Integer(1));
      
      //Create Hotel with assets
      roomlabel = new JLabel("Hotel");
      roomlabel.setBounds(969, 740, 205, 115);
      bPane.add(roomlabel, new Integer(1));
      
      takeslabel = new JLabel("3");
      takeslabel.setBounds(1005, 683, 47, 47);
      bPane.add(takeslabel, new Integer(1));
      takeslabel = new JLabel("2");
      takeslabel.setBounds(1058, 683, 47, 47);
      bPane.add(takeslabel, new Integer(1));
      takeslabel = new JLabel("1");
      takeslabel.setBounds(1111, 683, 47, 47);
      bPane.add(takeslabel, new Integer(1));
      
      partslabel = new JLabel("Sleeping Drunkard");
      partslabel.setBounds(1111, 469, 46, 46);
      bPane.add(partslabel, new Integer(1));
      partslabel = new JLabel("Faro Player");
      partslabel.setBounds(1044, 509, 46, 46);
      bPane.add(partslabel, new Integer(1));
      partslabel = new JLabel("Falls from Balcony");
      partslabel.setBounds(1111, 557, 46, 46);
      bPane.add(partslabel, new Integer(1));
      partslabel = new JLabel("Australian Bartender");
      partslabel.setBounds(1046, 596, 46, 46);
      bPane.add(partslabel, new Integer(1));
      
      //Create Main Street with assets
      roomlabel = new JLabel("Main Street");
      roomlabel.setBounds(969, 28, 205, 115);
      bPane.add(roomlabel, new Integer(1));
      
      takeslabel = new JLabel("3");
      takeslabel.setBounds(912, 23, 47, 47);
      bPane.add(takeslabel, new Integer(1));
      takeslabel = new JLabel("2");
      takeslabel.setBounds(858, 23, 47, 47);
      bPane.add(takeslabel, new Integer(1));
      takeslabel = new JLabel("1");
      takeslabel.setBounds(804, 23, 47, 47);
      bPane.add(takeslabel, new Integer(1));
      
      partslabel = new JLabel("Railroad Worker");
      partslabel.setBounds(637, 22, 46, 46);
      bPane.add(partslabel, new Integer(1));
      partslabel = new JLabel("Falls off Roof");
      partslabel.setBounds(720, 22, 46, 46);
      bPane.add(partslabel, new Integer(1));
      partslabel = new JLabel("Woman in Black Dress");
      partslabel.setBounds(637, 105, 46, 46);
      bPane.add(partslabel, new Integer(1));
      partslabel = new JLabel("Mayor McGinty");
      partslabel.setBounds(720, 105, 46, 46);
      bPane.add(partslabel, new Integer(1));
      
      //Create Jail with assets
      roomlabel = new JLabel("Jail");
      roomlabel.setBounds(281, 27, 205, 115);
      bPane.add(roomlabel, new Integer(1));
      
      takeslabel = new JLabel("1");
      takeslabel.setBounds(442, 156, 47, 47);
      bPane.add(takeslabel, new Integer(1));
      
      partslabel = new JLabel("Prisoner In Cell");
      partslabel.setBounds(519, 25, 46, 46);
      bPane.add(partslabel, new Integer(1));
      partslabel = new JLabel("Feller in Irons");
      partslabel.setBounds(519, 105, 46, 46);
      bPane.add(partslabel, new Integer(1));
      
      //Create General Store with assets
      roomlabel = new JLabel("General Store");
      roomlabel.setBounds(370, 282, 205, 115);
      bPane.add(roomlabel, new Integer(1));
      
      takeslabel = new JLabel("2");
      takeslabel.setBounds(313, 277, 47, 47);
      bPane.add(takeslabel, new Integer(1));
      takeslabel = new JLabel("1");
      takeslabel.setBounds(313, 330, 47, 47);
      bPane.add(takeslabel, new Integer(1));
      
      partslabel = new JLabel("Man in Overalls");
      partslabel.setBounds(236, 276, 46, 46);
      bPane.add(partslabel, new Integer(1));
      partslabel = new JLabel("Mister Keach");
      partslabel.setBounds(236, 358, 46, 46);
      bPane.add(partslabel, new Integer(1));
      
      //Create Ranch with assets
      roomlabel = new JLabel("Ranch");
      roomlabel.setBounds(252, 478, 205, 115);
      bPane.add(roomlabel, new Integer(1));
      
      takeslabel = new JLabel("2");
      takeslabel.setBounds(472, 473, 47, 47);
      bPane.add(takeslabel, new Integer(1));
      takeslabel = new JLabel("1");
      takeslabel.setBounds(525, 473, 47, 47);
      bPane.add(takeslabel, new Integer(1));
      
      partslabel = new JLabel("Shot in Leg");
      partslabel.setBounds(412, 608, 46, 46);
      bPane.add(partslabel, new Integer(1));
      partslabel = new JLabel("Saucy Fred");
      partslabel.setBounds(488, 608, 46, 46);
      bPane.add(partslabel, new Integer(1));
      partslabel = new JLabel("Man Under Horse");
      partslabel.setBounds(488, 525, 46, 46);
      bPane.add(partslabel, new Integer(1));
      
      //Create Bank with assets
      roomlabel = new JLabel("Bank");
      roomlabel.setBounds(623, 475, 205, 115);
      bPane.add(roomlabel, new Integer(1));
      
      takeslabel = new JLabel("1");
      takeslabel.setBounds(840, 549, 47, 47);
      bPane.add(takeslabel, new Integer(1));
      
      partslabel = new JLabel("Suspicious Gentleman");
      partslabel.setBounds(911, 554, 46, 46);
      bPane.add(partslabel, new Integer(1));
      partslabel = new JLabel("Flustered Teller");
      partslabel.setBounds(911, 470, 46, 46);
      bPane.add(partslabel, new Integer(1));
      
      //Create Saloon with assets
      roomlabel = new JLabel("Jail");
      roomlabel.setBounds(281, 27, 205, 115);
      bPane.add(roomlabel, new Integer(1));
      
      takeslabel = new JLabel("1");
      takeslabel.setBounds(442, 156, 47, 47);
      bPane.add(takeslabel, new Integer(1));
      
      partslabel = new JLabel("Prisoner In Cell");
      partslabel.setBounds(519, 25, 46, 46);
      bPane.add(partslabel, new Integer(1));
      partslabel = new JLabel("Feller in Irons");
      partslabel.setBounds(519, 105, 46, 46);
      bPane.add(partslabel, new Integer(1));
      
      //Create General Store with assets
      roomlabel = new JLabel("Saloon");
      roomlabel.setBounds(632, 280, 205, 115);
      bPane.add(roomlabel, new Integer(1));
      
      takeslabel = new JLabel("2");
      takeslabel.setBounds(626, 216, 47, 47);
      bPane.add(takeslabel, new Integer(1));
      takeslabel = new JLabel("1");
      takeslabel.setBounds(679, 216, 47, 47);
      bPane.add(takeslabel, new Integer(1));
      
      partslabel = new JLabel("Reluctant Farmer");
      partslabel.setBounds(877, 352, 46, 46);
      bPane.add(partslabel, new Integer(1));
      partslabel = new JLabel("Woman in Red Dress");
      partslabel.setBounds(877, 276, 46, 46);
      bPane.add(partslabel, new Integer(1));
      
      //create trailer and office and ranks
      roomlabel = new JLabel("Trailer");
      roomlabel.setBounds(991, 248, 201, 194);
      bPane.add(roomlabel, new Integer(1));
      roomlabel = new JLabel("Office");
      roomlabel.setBounds(9, 459, 209, 208);
      bPane.add(roomlabel, new Integer(1));
      
      ranklabel = new JLabel("2");
      ranklabel.setBounds(98, 542, 19, 19);
      bPane.add(ranklabel, new Integer(1));
      ranklabel = new JLabel("3");
      ranklabel.setBounds(98, 564, 19, 19);
      bPane.add(ranklabel, new Integer(1));
      ranklabel = new JLabel("4");
      ranklabel.setBounds(98, 587, 19, 19);
      bPane.add(ranklabel, new Integer(1));
      ranklabel = new JLabel("5");
      ranklabel.setBounds(98, 609, 19, 19);
      bPane.add(ranklabel, new Integer(1));
      ranklabel = new JLabel("6");
      ranklabel.setBounds(98, 631, 19, 19);
      bPane.add(ranklabel, new Integer(1));
      
      ranklabel = new JLabel("2");
      ranklabel.setBounds(147, 542, 19, 19);
      bPane.add(ranklabel, new Integer(1));
      ranklabel = new JLabel("3");
      ranklabel.setBounds(147, 564, 19, 19);
      bPane.add(ranklabel, new Integer(1));
      ranklabel = new JLabel("4");
      ranklabel.setBounds(147, 587, 19, 19);
      bPane.add(ranklabel, new Integer(1));
      ranklabel = new JLabel("5");
      ranklabel.setBounds(147, 609, 19, 19);
      bPane.add(ranklabel, new Integer(1));
      ranklabel = new JLabel("6");
      ranklabel.setBounds(147, 631, 19, 19);
      bPane.add(ranklabel, new Integer(1));
    		  
      
      //--------------------------------------- End room creation --------------------------
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
