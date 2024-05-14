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

        //need code to initialize locations array
        //needs to read xml? somehow pull data about all locations
        //and then store in locations[] using Location constructor

        //temp code for location:
        locations = new Location[1];
        locations[0] = new Location("Trailer");
        //also temp code for numScenes? idk how many
        scenesLeft = 20;

        //now code to create the players and store them in array
        players = new Player[numPlayers];
        for (int i = 1; i <= numPlayers; i++){
            players[i - 1] = new Player(i, startCred, startRank);
        }
        System.out.println("Game Started!\n");
    }

    public void endDay(){
    	if (scenesLeft == 1){
    		//move players back to trailer, 
    		daysLeft = daysLeft - 1;
    		if (daysLeft == 0){
    			//add up each players total
    			//compare the totals
    			//declare winner
    			//end game
    		}
    		locations = new Location[1];
    		locations[0] = new Location("Trailer");
    		scenesLeft = 20;
    		
    	}
    }

    public static int rollDice(){ //change to static, maybe temp?
        int max = 6;
        int min = 1;
        int range = max - min + 1;
        int rand = (int)(Math.random() * range) + min;
        return rand;
    }

    public void printStatus(){
        System.out.println("Days Remaining: "+daysLeft+" (Game ends when there are 0 remaining)");
        System.out.println("Scenes Remaining: "+scenesLeft);
        System.out.println("\nActive Player: Player "+currentTurn);
        System.out.println("Rank: "+players[currentTurn - 1].getRank());
        System.out.println("Available Credits: "+players[currentTurn - 1].getBank().getCredits());
        System.out.println("Available Dollars: "+players[currentTurn - 1].getBank().getDollars());
        System.out.println("\nLocations:");
        for (int i = 0; i < numPlayers; i++){
            System.out.println("Player "+(i+1)+": "+players[i].getLocation().getName());
        }
    }
}
