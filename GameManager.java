import java.util.ArrayList;

@SuppressWarnings ("unused")
public class GameManager {

    private Player[] players;
    public int numPlayers;
    private int currentTurn;
    public static Location[] locations;
    private int scenesLeft;
    private int daysLeft;

    public GameManager(int numP){
        //set up basic rules, based on numPlayers
        numPlayers = numP;
        if (numPlayers < 4){
            daysLeft = 3;
        }
        else {
            daysLeft = 4;
        }
        int startCred = 0;
        int startRank = 1;
        if (numPlayers == 5){
            startCred = 2;
        } else if (numPlayers == 6){
            startCred = 4;
        } else if (numPlayers > 6){
            startRank = 2;
        }
        currentTurn = 1;

        locations = new Location[12];
        for (int i = 0; i < locations.length; i++){
            locations[i] = new Location(i);
        }
        for (int i = 0; i < locations.length; i++){
            locations[i].setNeighbors(i, locations);
        }
        //also temp code for numScenes? idk how many
        scenesLeft = 20;

        //now code to create the players and store them in array
        players = new Player[numPlayers];
        for (int i = 1; i <= numPlayers; i++){
            players[i - 1] = new Player(i, startCred, startRank);
        }
        System.out.println("Game Started!\n");
    }

    public void endTurn(){
        System.out.println("Ending Turn...\n\n\n");
        if (currentTurn == numPlayers){
            currentTurn = 1;
        } else {
            currentTurn ++;
        }
        if (scenesLeft <= 1){
            endDay();
        }
    }

    public void endDay(){
        //move players back to trailer, 
        daysLeft = daysLeft - 1;
        if (daysLeft == 0){
            //add up each players total
            //compare the totals
            //declare winner
            //end game
        }
        //i dont think we need these lines
          //locations = new Location[1];
          //locations[0] = new Location("Trailer");
        //locations shouldn't change, only the scenes
        //locations are the spots on the board, scenes are the cards
        scenesLeft = 20;
    }

    public static int rollDice(){ //change to static, maybe temp?
        int max = 6;
        int min = 1;
        int range = max - min + 1;
        int rand = (int)(Math.random() * range) + min;
        return rand;
    }

    public int getDaysLeft(){
        return daysLeft;
    }

    public int getCurrentTurn(){
        return currentTurn;
    }

    //do the same thing, but if pNum is unspecified, returns active player
    public Player getPlayer(){
        return players[currentTurn - 1];
    }
    public Player getPlayer(int pNum){
        return players[pNum - 1];
    }

    public void printStatus(){
        System.out.println("Days Remaining: "+daysLeft+" (Game ends when there are 0 remaining)");
        System.out.println("Scenes Remaining: "+scenesLeft);
        System.out.println("\nActive Player: Player "+currentTurn);
        System.out.println("Rank: "+players[currentTurn - 1].getRank());
        System.out.println("Available Credits: "+players[currentTurn - 1].getBank().getCredits());
        System.out.println("Available Dollars: "+players[currentTurn - 1].getBank().getDollars());
        Role curRole = players[currentTurn - 1].getRole();
        if (curRole == null){
            System.out.println("Role: None");
        }else {
            System.out.println("Role: "+curRole.getName());
        }
        System.out.println("\nLocations:");
        for (int i = 0; i < numPlayers; i++){
            System.out.println("Player "+(i+1)+": "+players[i].getLocation().getName());
        }
    }

    public ArrayList<Character> printOptions(){
        System.out.println("\nYour turn, Player "+currentTurn+"!");
        System.out.println("Your options are:");
        Player curPlayer = players[currentTurn - 1];
        ArrayList<Character> options = new ArrayList<Character>();
        if (curPlayer.getLocation().getName().equals("Casting Office") && curPlayer.canUpgrade()){
            System.out.println("Upgrade (u)");
            options.add('u');
        }
        if (curPlayer.getRole() == null){
            System.out.println("Move (m)");
            options.add('m');
            System.out.println("Take a Role (t)");
            options.add('t');
        } else {
            System.out.println("Act (a)");
            options.add('a');
            System.out.println("Rehearse (r)");
            options.add('r');
        }
        System.out.println("End Turn (e)");
        options.add('e');
        return options;
    }
}
