import java.util.Scanner;

@SuppressWarnings ("unused")
public class Player {

	private int playerNum;
	private int rank;
    private Role curRole;
    private Location curLocation;
    private Bank playerBank;
	private int timesRehearsed;
	private String color;

	public Player(int pNum, int sC, int sR){
		//set instance vars
		playerNum = pNum;
		color = GameManager.colors[pNum - 1];
		rank = sR;
		//set role to null
		curRole = null;
		//set default loc to Trailer
		curLocation = GameManager.locations[10];
		curLocation.addPlayer(this);
		//create Bank w default vals
		playerBank = new Bank(this, sC);
		timesRehearsed = 0;
	}

	public int move(String choice){
		int numOptions = curLocation.printAdj();
		System.out.print("Which space would you like to move to? ");
		Location adj[] = curLocation.getAdj();
		for (int i = 0; i < numOptions; i++){
			if (adj[i].getName().equals(choice)){
				curLocation.removePlayer(this);
				curLocation = adj[i];
				curLocation.addPlayer(this);
			}
		}
		System.out.println("Moved to "+curLocation.getName()+"!");
		return curLocation.getRoomInd();
	}

	public void takeRole(String choice){
		Role rolesAvail[] = curLocation.getRolesAvail(rank);
		int i = 0;
		while (i < rolesAvail.length && rolesAvail[i] != null){
			if (rolesAvail[i] != null && rolesAvail[i].getName() != null){
				if (rolesAvail[i].getName().equals(choice)){
					curRole = rolesAvail[i];
					curRole.take();
					i = rolesAvail.length - 1;
				}
			}
			i++;
		}
		System.out.println("\nRole Taken! Your role: "+curRole.getName());
	}

	public void upgrade(String pType, int targetRank){
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
		System.out.print("Would you like to pay with dollars (d) or credits (c)? ");
		if (pType.equals("Credits")){
			playerBank.updateCred(-(5 * (targetRank - 1)));
			rank = targetRank;
		}
		else if (pType.equals("Dollars")){
			playerBank.updateDol(-((targetRank * targetRank) + targetRank - 2));
			rank = targetRank;
		}
		System.out.println("Rank Upgraded! Your new rank is: "+rank);
	}
	
	public void rehearse(){
		timesRehearsed++;
	}

	public void reset(){
		timesRehearsed = 0;
		curRole = null;
	}

	public int getRehearsed(){
		return timesRehearsed;
	}

	public int act(){
		int diceRoll = GameManager.rollDice();
		int budget = curLocation.getScene().getBudget();
		System.out.println("Rolling dice...\n");
		System.out.println("You rolled a "+diceRoll+"!");
		boolean success = (diceRoll + timesRehearsed) >= budget;
		if (success){
			System.out.println("Your roll, "+diceRoll+
				" + your rehearsal chips ("+timesRehearsed+
				") was higher than/equal to the budget ("+budget+")!");
			curLocation.removeShot();
			diceRoll += 10;
		} else {
			System.out.println("Sorry! Your roll, "+diceRoll+
					" + your rehearsal chips ("+timesRehearsed+
					") was lower than the budget ("+budget+").");
		}
		curRole.getRewards(success, this);
		return diceRoll;
	}

	public boolean canRehearse(){
		System.out.println((curRole != null));
		System.out.println((timesRehearsed + 1) >= curLocation.getScene().getBudget());
		return (curRole != null) && ((timesRehearsed + 1) < curLocation.getScene().getBudget());
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
		if (targetRank > 6){
			return false;
		}
        int targetDollarPrice = (targetRank * targetRank) + targetRank - 2;
        int targetCreditPrice = 5 * (targetRank - 1);
        return (playerBank.getDollars() >= targetDollarPrice || playerBank.getCredits() >= targetCreditPrice);
    }

	public boolean canUpgrade(int targetRank, char choice){
		if (targetRank > 6){
			return false;
		}
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

	public int getpNum(){
		return playerNum;
	}

	public Location getLocation(){
		return curLocation;
	}

	public void setLocation(Location l){
		curLocation = l;
	}

	public Bank getBank(){
		return playerBank;
	}

	public boolean canTakeRole() {
		Role[] avail = curLocation.getRolesAvail(rank);
		for (int i = 0; i < avail.length; i++){
			if (avail[i] != null && avail[i].getName() != null){
				if (avail[i].getLevel() <= rank){
					return true;
				}
			}
		}
		return false;
	}
}
