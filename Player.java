@SuppressWarnings ("unused")
public class Player {

	private int playerNum;
	private int rank;
    private Role curRole;
    private Location curLocation;
    private Bank playerBank;

	public Player(int pNum, int sC, int sR){
		//set instance vars
		playerNum = pNum;
		rank = sR;
		//set default loc to Trailer
		curLocation = GameManager.locations[0];
		curLocation.addPlayer(this);
		//create Bank w default vals
		playerBank = new Bank(this, sC);
	}

	public void move(){

	}
	public void takeRole(){

	}

	public void upgrade(){

	}
	
	public void rehearse(){

	}

	public void act(){

	}

	public int getRank(){
		return rank;
	}

	public Location getLocation(){
		return curLocation;
	}

	public Bank getBank(){
		return playerBank;
	}

}
