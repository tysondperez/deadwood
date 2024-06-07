/*
   Credit to Moushumi Sharmin for the skeleton of this code
   It has been heavily modified but the core principle remains the same
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

@SuppressWarnings("removal")

public class BoardView extends JFrame {

   // JLabels
   JLabel boardlabel;
   JLabel cardlabel;
   JLabel playerlabels[];
   ImageIcon pIcons[];
   JLabel mLabel;
   JLabel daysLeftLabel;
   JLabel scenesLeftLabel;
   JLabel activePlayerLabel;
   JLabel playerColorLabel;
   JLabel creditsLabel;
   JLabel dollarsLabel;
   JLabel rehearsedLabel;
   JLabel successLabel;
   JLabel rollLabel;
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
   JComboBox<String> roleOpts;
   JComboBox<String> upOpts;
   JComboBox<String> payments;
   boolean isUserInput;

   // JLayered Pane
   JLayeredPane bPane;
   
   public BoardController controller;

   String imagePath;

   // Constructor
   public BoardView() {
      // Set the title of the JFrame
      super("Deadwood");
      // Set the exit option for the JFrame
      setDefaultCloseOperation(EXIT_ON_CLOSE);
   
      File srcDir = new File("src");
      if (srcDir.exists() && srcDir.isDirectory()){
         imagePath = "src/images/";
      } else {
         imagePath = "images/";
      }

      // Create the JLayeredPane to hold the display, cards, dice and buttons
      bPane = getLayeredPane();
   
      // Create the deadwood board
      boardlabel = new JLabel();
      ImageIcon icon =  new ImageIcon(imagePath+"board.jpg");
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
      roomlabel[0] = new JLabel();
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
      
      partslabel[8] = new JLabel("Dead Man");
      partslabel[8].setBounds(857, 730, 46, 46);
      bPane.add(partslabel[8], new Integer(1));
      partslabel[9] = new JLabel("Crying Woman");
      partslabel[9].setBounds(858, 809, 46, 46);
      bPane.add(partslabel[9], new Integer(1));
      partslabel[10] = null;
      partslabel[11] = null;
      
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
      roomlabel[4] = new JLabel();
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
      
      
      partslabel[20] = new JLabel("Prisoner In Cell");
      partslabel[20].setBounds(519, 25, 46, 46);
      bPane.add(partslabel[20], new Integer(1));
      partslabel[21] = new JLabel("Feller in Irons");
      partslabel[21].setBounds(519, 105, 46, 46);
      bPane.add(partslabel[21], new Integer(1));
      partslabel[22] = null;
      partslabel[23] = null;
      
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
      
      partslabel[24] = new JLabel("Man in Overalls");
      partslabel[24].setBounds(236, 276, 46, 46);
      bPane.add(partslabel[24], new Integer(1));
      partslabel[25] = new JLabel("Mister Keach");
      partslabel[25].setBounds(236, 358, 46, 46);
      bPane.add(partslabel[25], new Integer(1));
      partslabel[26] = null;
      partslabel[27] = null;
      
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
      
      partslabel[28] = new JLabel("Shot in Leg");
      partslabel[28].setBounds(412, 608, 46, 46);
      bPane.add(partslabel[28], new Integer(1));
      partslabel[29] = new JLabel("Saucy Fred");
      partslabel[29].setBounds(488, 608, 46, 46);
      bPane.add(partslabel[29], new Integer(1));
      partslabel[30] = new JLabel("Man Under Horse");
      partslabel[30].setBounds(488, 525, 46, 46);
      bPane.add(partslabel[30], new Integer(1));
      partslabel[31] = null;
      
      //Create Bank with assets
      roomlabel[8] = new JLabel("Bank");
      roomlabel[8].setBounds(623, 475, 205, 115);
      bPane.add(roomlabel[8], new Integer(1));
      
      takeslabel[24] = null;
      takeslabel[25] = null;
      takeslabel[26] = new JLabel("1");
      takeslabel[26].setBounds(840, 549, 47, 47);
      bPane.add(takeslabel[26], new Integer(1));
      
      partslabel[32] = new JLabel("Suspicious Gentleman");
      partslabel[32].setBounds(911, 554, 46, 46);
      bPane.add(partslabel[32], new Integer(1));
      partslabel[33] = new JLabel("Flustered Teller");
      partslabel[33].setBounds(911, 470, 46, 46);
      bPane.add(partslabel[33], new Integer(1));
      partslabel[34] = null;
      partslabel[35] = null;
      
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
      
      partslabel[36] = new JLabel("Reluctant Farmer");
      partslabel[36].setBounds(877, 352, 46, 46);
      bPane.add(partslabel[36], new Integer(1));
      partslabel[37] = new JLabel("Woman in Red Dress");
      partslabel[37].setBounds(877, 276, 46, 46);
      bPane.add(partslabel[37], new Integer(1));
      partslabel[38] = null;
      partslabel[39] = null;
      
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
    	
      for (int i = 0; i < roomlabel.length; i++){
         roomlabel[i].setVisible(false);
      }
      for (int i = 0; i < ranklabelC.length; i++){
         ranklabelC[i].setVisible(false);
         ranklabelD[i].setVisible(false);
      }
      for (int i = 0; i < takeslabel.length; i++){
         if (takeslabel[i] != null){
            takeslabel[i].setIcon(new ImageIcon(imagePath+"shot.png"));
            takeslabel[i].setVisible(true);
         }
      }
      for (int i = 0; i < partslabel.length; i++){
         if (partslabel[i] != null){
            partslabel[i].setVisible(false);
         }
      }

      //--------------------------------------- End room creation --------------------------
      
   
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
      white.setBounds(969, 28, 205, 115);
      white.setVisible(false);
      bPane.add(white, new Integer(2));


      // create status info labels
      daysLeftLabel = new JLabel();
      daysLeftLabel.setBounds(icon.getIconWidth()+10, 270,110, 10);
      bPane.add(daysLeftLabel,new Integer(2));

      successLabel = new JLabel();
      successLabel.setBounds(icon.getIconWidth()+3, 100,130, 70);;
      successLabel.setVisible(false);
      bPane.add(successLabel,new Integer(2));

      adjLoc = new JComboBox<String>();
      adjLoc.setBounds(icon.getIconWidth()+10, 30,110, 20);
      adjLoc.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED && isUserInput) {
               controller.handleMovePicked((String) adjLoc.getSelectedItem());
            }
         }
      });
      bPane.add(adjLoc, new Integer(2));
      adjLoc.setVisible(false);

      roleOpts = new JComboBox<String>();
      roleOpts.setBounds(icon.getIconWidth()+10, 30,110, 20);
      roleOpts.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED && isUserInput) {
               controller.handleTakePicked((String) roleOpts.getSelectedItem());
            }
         }
      });
      bPane.add(roleOpts, new Integer(2));
      roleOpts.setVisible(false);

      upOpts = new JComboBox<String>();
      upOpts.setBounds(icon.getIconWidth()+10, 30,110, 20);
      upOpts.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED && isUserInput) {
               controller.handleUpPicked((String) upOpts.getSelectedItem());
            }
         }
      });
      bPane.add(upOpts, new Integer(2));
      upOpts.setVisible(false);
      
      payments = new JComboBox<String>();
      payments.setBounds(icon.getIconWidth()+10, 80,110, 20);
      payments.addItemListener(new ItemListener() {
         @Override
         public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED && isUserInput) {
               controller.handlePaymentsPicked((String) payments.getSelectedItem());
            }
         }
      });
      bPane.add(payments, new Integer(2));
      payments.setVisible(false);

      rollLabel = new JLabel("You Rolled:");
      rollLabel.setBounds(icon.getIconWidth()+25, 30,110, 70);
      rollLabel.setVerticalTextPosition(JLabel.TOP);
      rollLabel.setHorizontalTextPosition(JLabel.CENTER);
      rollLabel.setVisible(false);
      bPane.add(rollLabel, new Integer(2));

      scenesLeftLabel = new JLabel();
      scenesLeftLabel.setBounds(icon.getIconWidth()+10, 285,110, 10);
      bPane.add(scenesLeftLabel,new Integer(2));

      activePlayerLabel = new JLabel();
      activePlayerLabel.setBounds(icon.getIconWidth()+10, 330,110, 10);
      bPane.add(activePlayerLabel,new Integer(2));

      playerColorLabel = new JLabel();
      playerColorLabel.setBounds(icon.getIconWidth()+45, 390,50, 50);
      bPane.add(playerColorLabel,new Integer(2));

      creditsLabel = new JLabel();
      creditsLabel.setBounds(icon.getIconWidth()+10, 345,110, 10);
      bPane.add(creditsLabel,new Integer(2));

      dollarsLabel = new JLabel();
      dollarsLabel.setBounds(icon.getIconWidth()+10, 360,110, 10);
      bPane.add(dollarsLabel,new Integer(2));

      rehearsedLabel = new JLabel();
      rehearsedLabel.setBounds(icon.getIconWidth()+10, 375,110, 15);
      bPane.add(rehearsedLabel,new Integer(2));
   }

  	public void displayStatus(int d, int s, int p, int c, int dol, int tR){
		daysLeftLabel.setText("Days Left: "+d);
		scenesLeftLabel.setText("Scenes Left: "+s);
		activePlayerLabel.setText("Player "+p+"\'s Turn");
		creditsLabel.setText("Credits: "+c);
		dollarsLabel.setText("Dollars: "+dol);
      rehearsedLabel.setText("R. Chips: "+ tR);
      playerColorLabel.setIcon(pIcons[p - 1]);
      //playerColorLabel.setText("Here");
      playerColorLabel.setVisible(true);
  	}

   public void updateChips(int tR){
      rehearsedLabel.setText("R. Chips: "+ tR);
   }

   public void createPlayers(int n, String [] colors, int sR){
      playerlabels = new JLabel[n];
      pIcons = new ImageIcon[n];
      for (int i = 0; i < n; i++){
         playerlabels[i] = new JLabel();
         ImageIcon pIcon = new ImageIcon(imagePath+"dice/"+colors[i]+sR+".png");
         pIcons[i] = pIcon;
         playerlabels[i].setIcon(pIcon);
         playerlabels[i].setBounds((991 + (i%4)*pIcon.getIconWidth()),(248 + (i/4)*pIcon.getIconHeight()),pIcon.getIconWidth(),pIcon.getIconHeight());  
         playerlabels[i].setVisible(true);
         bPane.add(playerlabels[i],new Integer(3));
      }
   }

   public void upgradePlayer(int rank, int p, String[] colors){
      pIcons[p] = new ImageIcon(imagePath+"dice/"+colors[p]+rank+".png");
      playerlabels[p].setIcon(pIcons[p]);
      playerColorLabel.setIcon(pIcons[p]);
   }

   public void movePlayer(int n, int roomInd, int partInd, int playersThere, int cardPos){
      //top left: trailers 10, casting 11
      //bot left: saloon 9, bank 8, church 2, hideout 1, jail 5, hotel 3, ranch 7, train 0
      //bot right: main 4, general store 6
      if (partInd == -1){
         JLabel temp = roomlabel[roomInd];
         int curx = (int) temp.getLocation().getX();
         int cury = (int) temp.getLocation().getY();
         int newx = 0;
         int newy = 0;
         if (roomInd >= 10){
            newx = (curx + (playersThere * playerlabels[n].getIcon().getIconWidth()));
            newy = cury;
         } else if (roomInd == 4 || roomInd == 6){
            newx = curx + temp.getWidth() - 
               ((playersThere + 1) * playerlabels[n].getIcon().getIconWidth());
            newy = (cury + temp.getHeight());
         } else {
            newx = curx + (playersThere * playerlabels[n].getIcon().getIconWidth());
            newy = (cury + temp.getHeight());
         }
         playerlabels[n].setLocation(newx, newy);

      } else if (partInd == -2){
         JLabel temp = roomlabel[roomInd];
         int curx = (int) temp.getLocation().getX();
         int cury = (int) temp.getLocation().getY();
         int newx = 0;
         int newy = 0;
         int numOnCard = playersThere;
         if (numOnCard == 1){
            newx = (curx + (temp.getWidth() / 2)) 
               - (playerlabels[n].getIcon().getIconWidth() / 2) + 1;
            newy = cury + playerlabels[n].getIcon().getIconHeight() + 7;
         } else if (numOnCard == 2){
            if (cardPos == 0){
               newx = curx + playerlabels[n].getIcon().getIconWidth() + 13;
               newy = cury + playerlabels[n].getIcon().getIconHeight() + 7;
            } else {
               newx = curx + (2*playerlabels[n].getIcon().getIconWidth()) + 36;
               newy = cury + playerlabels[n].getIcon().getIconHeight() + 7;
            }
         } else {
            if (cardPos == 0){
               newx = curx + 20;
               newy = cury + playerlabels[n].getIcon().getIconHeight() + 7;
            } else if (cardPos == 1){
               newx = (curx + (temp.getWidth() / 2)) 
                  - (playerlabels[n].getIcon().getIconWidth() / 2) + 1;
               newy = cury + playerlabels[n].getIcon().getIconWidth() + 7;
            } else {
               newx = curx + (2*playerlabels[n].getIcon().getIconHeight()) + 65;
               newy = cury + playerlabels[n].getIcon().getIconWidth() + 7;
            }
         }
         playerlabels[n].setLocation(newx, newy);

      } else {
         JLabel temp = partslabel[partInd];
         if (partslabel[partInd] == null){
            System.out.println("partlabel["+partInd + "] is null, abort move");
         } else {
            int x = (int) temp.getLocation().getX();
            int y = (int) temp.getLocation().getY();
            playerlabels[n].setLocation(x + 3, y + 3);
         }
         
      }
   }

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

   public void showUpOpts(boolean b){
      upOpts.setVisible(b);
   }

   public void showPayments(boolean b){
      payments.setVisible(b);
   }

   public void showSuccess(boolean s){
      if (s){
         successLabel.setText("You succeeded!");
      } else {
         successLabel.setText("Sorry, you failed.");
      }
      successLabel.setVisible(true);
   }

   public void hideSuccess(){
      successLabel.setVisible(false);
   }

   public void hideAllNotEnd(){
      bAct.setVisible(false);
      bRehearse.setVisible(false);
      bMove.setVisible(false);
      bTake.setVisible(false);
      bUpgrade.setVisible(false);
   }

   public void hideCombos(){
      adjLoc.setVisible(false);
      roleOpts.setVisible(false);
      upOpts.setVisible(false);
      payments.setVisible(false);
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

   public void roleOptsPopulate(String names[]){
      isUserInput = false;
      roleOpts.removeAllItems();
      roleOpts.addItem("--Select--");
      for (int i = 0; i < names.length; i++){
			if (names[i] != null){
				roleOpts.addItem(names[i]);
			}
		}
      isUserInput = true;
   }

   public void upOptsPopulate(boolean ranks[]){
      isUserInput = false;
      upOpts.removeAllItems();
      upOpts.addItem("--Select--");
      for (int i = 0; i < ranks.length; i++){
			if (ranks[i]){
				upOpts.addItem("Rank "+(i+1));
			}
		}
      isUserInput = true;
   }

   public void paymentsPopulate(boolean types[]){
      isUserInput = false;
      payments.removeAllItems();
      payments.addItem("--Select--");
      if (types[0]){
         payments.addItem("Credits");
      }
      if (types[1]){
         payments.addItem("Dollars");
      }
      isUserInput = true;
   }

   public void showRoleOpts(boolean b){
      roleOpts.setVisible(b);
   }

   // public void actionInvalid(String s){
   //    //code that tells user the action they tried to take is invalid
   //    invalidLabel.setText("Sorry, you can't take the "+s+" action right now!\nSelect another option.");
   //    invalidLabel.setVisible(true);
   // }

   public void revealCard(int roomInd, int cardInd){
      String zero;
      zero = (cardInd < 10 ? "0" : "");
      roomlabel[roomInd].setIcon(new ImageIcon(imagePath+"/cards/"+zero+(cardInd + 1)+".png"));
      roomlabel[roomInd].setVisible(true);
   }

   public void showCardBacks(){
      for (int i = 0; i < roomlabel.length - 2; i++){
         roomlabel[i].setIcon(new ImageIcon(imagePath+"/cards/CardBack-small.jpg"));
         roomlabel[i].setVisible(true);
      }
   }

   public void showRoll(int r){
      rollLabel.setIcon(new ImageIcon(imagePath+"/dice/w"+r+".png"));
      rollLabel.setIconTextGap(10);
      rollLabel.setVisible(true);
   }

   public void hideRoll(){
      rollLabel.setVisible(false);
   }

   public void removeShot(int rI, int sL){
      if (sL == 2){
         sL = 0;
      } else if (sL == 1){
         sL = 1;
      } else {
         sL = 2;
         if (roomlabel[rI] != null){
            roomlabel[rI].setVisible(false);
         }
         
      }
      //last shot removed () in r0 is t[0*3 + 2]
      //second removed is + 1
      //first removed is + 0
      //rI 0; shot1 = take[rI*3]
      //sL 0 = 
      if (takeslabel[(rI*3) + sL] != null){
         takeslabel[(rI * 3) + sL].setVisible(false);
      }
      
   }

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
            System.out.println("Rehearse is Selected\n");
            controller.handleRehearse();
         }
         else if (e.getSource()== bMove){
            System.out.println("Move is Selected\n");
            controller.handleMove();
         }
         else if (e.getSource()== bTake){
            System.out.println("Take is Selected\n");
            controller.handleTake();
         }
         else if (e.getSource()== bUpgrade){
            System.out.println("Upgrade is Selected\n");
            controller.handleUpgrade();
         }
         else if (e.getSource()== bEnd){
            System.out.println("End is Selected\n");
            controller.handleEndTurn();
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
