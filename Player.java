import java.util.Scanner;

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
		//set role to null
		curRole = null;
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
		System.out.println("Current Rank: "+rank);
        System.out.println("Available Credits: "+playerBank.getCredits());
        System.out.println("Available Dollars: "+playerBank.getDollars());
		System.out.println("   Rank    |  Dollars  |  Credits  ");
		System.out.println("     2     |     4     |     5     ");
		System.out.println("     3     |     10    |     10    ");
		System.out.println("     4     |     18    |     15    ");
		System.out.println("     5     |     28    |     20    ");
		System.out.println("     6     |     40    |     25    ");
		System.out.print("Which rank would you like to upgrade to? ");
		Scanner input = new Scanner(System.in);
		int targetRank = input.nextInt();
		while (!canUpgrade(targetRank)){
			System.out.println("Insufficient Funds! Please select another rank: ");
            targetRank = input.nextInt();
		}
		System.out.print("Would you like to pay with dollars (d) or credits (c)? ");
		char choice = input.next().charAt(0);
		while ((choice != 'd') && (choice != 'c')){
			System.out.println("Invalid Input! Please try again: ");
			choice = input.nextLine().charAt(0);
		}
		while (!canUpgrade(targetRank, choice)){
			System.out.println("Insufficient Funds! Please select the other option: ");
            choice = input.nextLine().charAt(0);
			while ((choice != 'd') && (choice != 'c')){
				System.out.println("Invalid Input! Please try again: ");
				choice = input.nextLine().charAt(0);
			}
		}
		if (choice == 'c'){
			playerBank.updateCred(-(5 * (targetRank - 1)));
			rank = targetRank;
			System.out.println("Rank Upgraded! Your new rank is: "+rank);
		}
		else if (choice == 'd'){
			playerBank.updateDol(-((targetRank * targetRank) + targetRank - 2));
			rank = targetRank;
			System.out.println("Rank Upgraded! Your new rank is: "+rank);
		}
	}
	
	public void rehearse(){

	}

	public void act(){

	}

	public boolean canUpgrade(){
        if (rank == 6){
            return false;
        }
        int minRank = rank + 1;
        int minDollarPrice = (minRank * minRank) + minRank - 2;
        int minCreditPrice = 5 * (minRank - 1);
        return (playerBank.getDollars() >= minDollarPrice || playerBank.getCredits() >= minCreditPrice);
    }

	public boolean canUpgrade(int targetRank){
        int targetDollarPrice = (targetRank * targetRank) + targetRank - 2;
        int targetCreditPrice = 5 * (targetRank - 1);
        return (playerBank.getDollars() >= targetDollarPrice || playerBank.getCredits() >= targetCreditPrice);
    }

	public boolean canUpgrade(int targetRank, char choice){
		if (choice == 'c'){
			int targetCreditPrice = 5 * (targetRank - 1);
			return (playerBank.getCredits() >= targetCreditPrice);
		}
        int targetDollarPrice = (targetRank * targetRank) + targetRank - 2;
        return (playerBank.getDollars() >= targetDollarPrice);
    }

	public int getRank(){
		return rank;
	}

	public Role getRole(){
		return curRole;
	}

	public Location getLocation(){
		return curLocation;
	}

	public Bank getBank(){
		return playerBank;
	}

}
