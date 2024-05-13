@SuppressWarnings ("unused")
public class GameManager {

    private Player[] players;
    public int numPlayers;
    private int currentTurn;
    public static Location[] locations;
    private int scenesLeft;
    private int daysLeft;

    public void initializeGame(int numP){
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
            startCred = 2;
        } else if (numPlayers > 6){
            startRank = 2;
        }

        //need code to initialize locations array
        //needs to read xml? somehow pull data about all locations
        //and then store in locations[] using Location constructor

        //temp code for location:
        locations = new Location[1];
        locations[0] = new Location("Trailer");

        //now code to create the players and store them in array
        players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++){
            players[i] = new Player(i, startCred, startRank);
        }
        

    }

    public void endDay(){

    }

    public int rollDice(){
        return 0;
    }
}
