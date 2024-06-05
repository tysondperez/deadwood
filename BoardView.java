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
   JLabel roomlabel[];
   JLabel takeslabel[];
   JLabel partslabel[];
   JLabel ranklabelC[]; //credits
   JLabel ranklabelD[]; //dollars
   
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
      roomlabel = new JLabel[12];
      takeslabel = new JLabel[30]; //3 takes max per scene
      partslabel = new JLabel[40]; //4 parts max per scene, null if nothing
      
      //Set Train Station with assets
      roomlabel[0] = new JLabel("Train Station");
      roomlabel[0].setBounds(21, 69, 205, 115);
      bPane.add(roomlabel[0], new Integer(1)); //lower layer?
      
      takeslabel[0] = new JLabel("3");
      takeslabel[0].setBounds(36, 11, 47, 47);
      bPane.add(takeslabel[0], new Integer(1));
      takeslabel[1] = new JLabel("2");
      takeslabel[1].setBounds(89, 11, 47, 47);
      bPane.add(takeslabel[1], new Integer(1));
      takeslabel[2] = new JLabel("1");
      takeslabel[2].setBounds(141, 11, 47, 47);
      bPane.add(takeslabel[2], new Integer(1));
      
      partslabel[0] = new JLabel("Crusty Prospector");
      partslabel[0].setBounds(114, 227, 46, 46);
      bPane.add(partslabel[0], new Integer(1));
      partslabel[1] = new JLabel("Dragged by Train");
      partslabel[1].setBounds(51, 268, 46, 46);
      bPane.add(partslabel[1], new Integer(1));
      partslabel[2] = new JLabel("Preacher with Bag");
      partslabel[2].setBounds(114, 320, 46, 46);
      bPane.add(partslabel[2], new Integer(1));
      partslabel[3] = new JLabel("Cyrus the Gunfighter");
      partslabel[3].setBounds(49, 356, 46, 46);
      bPane.add(partslabel[3], new Integer(1));
      
      //Set Secret Hideout with assets
      roomlabel[1] = new JLabel("Secret Hideout");
      roomlabel[1].setBounds(27, 732, 205, 115);
      bPane.add(roomlabel[1], new Integer(1));
      
      takeslabel[3] = new JLabel("3");
      takeslabel[3].setBounds(244, 764, 47, 47);
      bPane.add(takeslabel[3], new Integer(1));
      takeslabel[4] = new JLabel("2");
      takeslabel[4].setBounds(299, 764, 47, 47);
      bPane.add(takeslabel[4], new Integer(1));
      takeslabel[5] = new JLabel("1");
      takeslabel[5].setBounds(354, 764, 47, 47);
      bPane.add(takeslabel[5], new Integer(1));
      
      partslabel[4] = new JLabel("Clumsy Pit Fighter");
      partslabel[4].setBounds(435, 719, 46, 46);
      bPane.add(partslabel[4], new Integer(1));
      partslabel[5] = new JLabel("Thug with Knife");
      partslabel[5].setBounds(521, 719, 46, 46);
      bPane.add(partslabel[5], new Integer(1));
      partslabel[6] = new JLabel("Dangerous Tom");
      partslabel[6].setBounds(435, 808, 46, 46);
      bPane.add(partslabel[6], new Integer(1));
      partslabel[7] = new JLabel("Penny, who is lost");
      partslabel[7].setBounds(521, 808, 46, 46);
      bPane.add(partslabel[7], new Integer(1));
      
      //Create Church with assets
      roomlabel[2] = new JLabel("Church");
      roomlabel[2].setBounds(623, 734, 205, 115);
      bPane.add(roomlabel[2], new Integer(1));
      
      takeslabel[6] = null;
      takeslabel[7] = new JLabel("2");
      takeslabel[7].setBounds(623, 675, 47, 47);
      bPane.add(takeslabel[7], new Integer(1));
      takeslabel[8] = new JLabel("1");
      takeslabel[8].setBounds(682, 675, 47, 47);
      bPane.add(takeslabel[8], new Integer(1));
      
      partslabel[8] = null;
      partslabel[9] = null;
      partslabel[10] = new JLabel("Dead Man");
      partslabel[10].setBounds(857, 730, 46, 46);
      bPane.add(partslabel[10], new Integer(1));
      partslabel[11] = new JLabel("Crying Woman");
      partslabel[11].setBounds(858, 809, 46, 46);
      bPane.add(partslabel[11], new Integer(1));
      
      //Create Hotel with assets
      roomlabel[3] = new JLabel("Hotel");
      roomlabel[3].setBounds(969, 740, 205, 115);
      bPane.add(roomlabel[3], new Integer(1));
      
      takeslabel[9] = new JLabel("3");
      takeslabel[9].setBounds(1005, 683, 47, 47);
      bPane.add(takeslabel[9], new Integer(1));
      takeslabel[10] = new JLabel("2");
      takeslabel[10].setBounds(1058, 683, 47, 47);
      bPane.add(takeslabel[10], new Integer(1));
      takeslabel[11] = new JLabel("1");
      takeslabel[11].setBounds(1111, 683, 47, 47);
      bPane.add(takeslabel[11], new Integer(1));
      
      partslabel[12] = new JLabel("Sleeping Drunkard");
      partslabel[12].setBounds(1111, 469, 46, 46);
      bPane.add(partslabel[12], new Integer(1));
      partslabel[13] = new JLabel("Faro Player");
      partslabel[13].setBounds(1044, 509, 46, 46);
      bPane.add(partslabel[13], new Integer(1));
      partslabel[14] = new JLabel("Falls from Balcony");
      partslabel[14].setBounds(1111, 557, 46, 46);
      bPane.add(partslabel[14], new Integer(1));
      partslabel[15] = new JLabel("Australian Bartender");
      partslabel[15].setBounds(1046, 596, 46, 46);
      bPane.add(partslabel[15], new Integer(1));
      
      //Create Main Street with assets
      roomlabel[4] = new JLabel("Main Street");
      roomlabel[4].setBounds(969, 28, 205, 115);
      bPane.add(roomlabel[4], new Integer(1));
      
      takeslabel[12] = new JLabel("3");
      takeslabel[12].setBounds(912, 23, 47, 47);
      bPane.add(takeslabel[12], new Integer(1));
      takeslabel[13] = new JLabel("2");
      takeslabel[13].setBounds(858, 23, 47, 47);
      bPane.add(takeslabel[13], new Integer(1));
      takeslabel[14] = new JLabel("1");
      takeslabel[14].setBounds(804, 23, 47, 47);
      bPane.add(takeslabel[14], new Integer(1));
      
      partslabel[16] = new JLabel("Railroad Worker");
      partslabel[16].setBounds(637, 22, 46, 46);
      bPane.add(partslabel[16], new Integer(1));
      partslabel[17] = new JLabel("Falls off Roof");
      partslabel[17].setBounds(720, 22, 46, 46);
      bPane.add(partslabel[17], new Integer(1));
      partslabel[18] = new JLabel("Woman in Black Dress");
      partslabel[18].setBounds(637, 105, 46, 46);
      bPane.add(partslabel[18], new Integer(1));
      partslabel[19] = new JLabel("Mayor McGinty");
      partslabel[19].setBounds(720, 105, 46, 46);
      bPane.add(partslabel[19], new Integer(1));
      
      //Create Jail with assets
      roomlabel[5] = new JLabel("Jail");
      roomlabel[5].setBounds(281, 27, 205, 115);
      bPane.add(roomlabel[5], new Integer(1));
      
      takeslabel[15] = null;
      takeslabel[16] = null;
      takeslabel[17] = new JLabel("1");
      takeslabel[17].setBounds(442, 156, 47, 47);
      bPane.add(takeslabel[17], new Integer(1));
      
      partslabel[20] = null;
      partslabel[21] = null;
      partslabel[22] = new JLabel("Prisoner In Cell");
      partslabel[22].setBounds(519, 25, 46, 46);
      bPane.add(partslabel[22], new Integer(1));
      partslabel[23] = new JLabel("Feller in Irons");
      partslabel[23].setBounds(519, 105, 46, 46);
      bPane.add(partslabel[23], new Integer(1));
      
      //Create General Store with assets
      roomlabel[6] = new JLabel("General Store");
      roomlabel[6].setBounds(370, 282, 205, 115);
      bPane.add(roomlabel[6], new Integer(1));
      
      takeslabel[18] = null;
      takeslabel[19] = new JLabel("2");
      takeslabel[19].setBounds(313, 277, 47, 47);
      bPane.add(takeslabel[19], new Integer(1));
      takeslabel[20] = new JLabel("1");
      takeslabel[20].setBounds(313, 330, 47, 47);
      bPane.add(takeslabel[20], new Integer(1));
      
      partslabel[24] = null;
      partslabel[25] = null;
      partslabel[26] = new JLabel("Man in Overalls");
      partslabel[26].setBounds(236, 276, 46, 46);
      bPane.add(partslabel[26], new Integer(1));
      partslabel[27] = new JLabel("Mister Keach");
      partslabel[27].setBounds(236, 358, 46, 46);
      bPane.add(partslabel[27], new Integer(1));
      
      //Create Ranch with assets
      roomlabel[7] = new JLabel("Ranch");
      roomlabel[7].setBounds(252, 478, 205, 115);
      bPane.add(roomlabel[7], new Integer(1));
      
      takeslabel[21] = null;
      takeslabel[22] = new JLabel("2");
      takeslabel[22].setBounds(472, 473, 47, 47);
      bPane.add(takeslabel[22], new Integer(1));
      takeslabel[23] = new JLabel("1");
      takeslabel[23].setBounds(525, 473, 47, 47);
      bPane.add(takeslabel[23], new Integer(1));
      
      partslabel[28] = null;
      partslabel[29] = new JLabel("Shot in Leg");
      partslabel[29].setBounds(412, 608, 46, 46);
      bPane.add(partslabel[29], new Integer(1));
      partslabel[30] = new JLabel("Saucy Fred");
      partslabel[30].setBounds(488, 608, 46, 46);
      bPane.add(partslabel[30], new Integer(1));
      partslabel[31] = new JLabel("Man Under Horse");
      partslabel[31].setBounds(488, 525, 46, 46);
      bPane.add(partslabel[31], new Integer(1));
      
      //Create Bank with assets
      roomlabel[8] = new JLabel("Bank");
      roomlabel[8].setBounds(623, 475, 205, 115);
      bPane.add(roomlabel[8], new Integer(1));
      
      takeslabel[24] = null;
      takeslabel[25] = null;
      takeslabel[26] = new JLabel("1");
      takeslabel[26].setBounds(840, 549, 47, 47);
      bPane.add(takeslabel[26], new Integer(1));
      
      partslabel[32] = null;
      partslabel[33] = null;
      partslabel[34] = new JLabel("Suspicious Gentleman");
      partslabel[34].setBounds(911, 554, 46, 46);
      bPane.add(partslabel[34], new Integer(1));
      partslabel[35] = new JLabel("Flustered Teller");
      partslabel[35].setBounds(911, 470, 46, 46);
      bPane.add(partslabel[35], new Integer(1));
      
      //Create Saloon with assets
      roomlabel[9] = new JLabel("Saloon");
      roomlabel[9].setBounds(632, 280, 205, 115);
      bPane.add(roomlabel[9], new Integer(1));
      
      takeslabel[27] = null;
      takeslabel[28] = new JLabel("2");
      takeslabel[28].setBounds(626, 216, 47, 47);
      bPane.add(takeslabel[28], new Integer(1));
      takeslabel[29] = new JLabel("1");
      takeslabel[29].setBounds(679, 216, 47, 47);
      bPane.add(takeslabel[29], new Integer(1));
      
      partslabel[36] = null;
      partslabel[37] = null;
      partslabel[38] = new JLabel("Reluctant Farmer");
      partslabel[38].setBounds(877, 352, 46, 46);
      bPane.add(partslabel[38], new Integer(1));
      partslabel[39] = new JLabel("Woman in Red Dress");
      partslabel[39].setBounds(877, 276, 46, 46);
      bPane.add(partslabel[39], new Integer(1));
      
      //create trailer and office and ranks
      roomlabel[10] = new JLabel("Trailer");
      roomlabel[10].setBounds(991, 248, 201, 194);
      bPane.add(roomlabel[10], new Integer(1));
      roomlabel[11] = new JLabel("Office");
      roomlabel[11].setBounds(9, 459, 209, 208);
      bPane.add(roomlabel[11], new Integer(1));
      
      ranklabelC = new JLabel[5];
      ranklabelD = new JLabel[5];
      
      ranklabelD[0] = new JLabel("2");
      ranklabelD[0].setBounds(98, 542, 19, 19);
      bPane.add(ranklabelD[0], new Integer(1));
      ranklabelD[1] = new JLabel("3");
      ranklabelD[1].setBounds(98, 564, 19, 19);
      bPane.add(ranklabelD[1], new Integer(1));
      ranklabelD[2] = new JLabel("4");
      ranklabelD[2].setBounds(98, 587, 19, 19);
      bPane.add(ranklabelD[2], new Integer(1));
      ranklabelD[3] = new JLabel("5");
      ranklabelD[3].setBounds(98, 609, 19, 19);
      bPane.add(ranklabelD[3], new Integer(1));
      ranklabelD[4] = new JLabel("6");
      ranklabelD[4].setBounds(98, 631, 19, 19);
      bPane.add(ranklabelD[4], new Integer(1));
      
      ranklabelC[0] = new JLabel("2");
      ranklabelC[0].setBounds(147, 542, 19, 19);
      bPane.add(ranklabelC[0], new Integer(1));
      ranklabelC[1] = new JLabel("3");
      ranklabelC[1].setBounds(147, 564, 19, 19);
      bPane.add(ranklabelC[1], new Integer(1));
      ranklabelC[2] = new JLabel("4");
      ranklabelC[2].setBounds(147, 587, 19, 19);
      bPane.add(ranklabelC[2], new Integer(1));
      ranklabelC[3] = new JLabel("5");
      ranklabelC[3].setBounds(147, 609, 19, 19);
      bPane.add(ranklabelC[3], new Integer(1));
      ranklabelC[4] = new JLabel("6");
      ranklabelC[4].setBounds(147, 631, 19, 19);
      bPane.add(ranklabelC[4], new Integer(1));
    		  
      
      //--------------------------------------- End room creation --------------------------
      // Add a scene card to this room
      cardlabel = new JLabel();
      ImageIcon cIcon =  new ImageIcon("src/images/cards/01.png");
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
         ImageIcon pIcon = new ImageIcon("src/images/dice/"+colors[i]+"1.png");
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
