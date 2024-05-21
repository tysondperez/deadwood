import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings ("unused")
public class Location {

	private String name;
	private Role[] roles;
	private Location[] adjLocations; //get adjacent locations to current location from xml file
	private ArrayList<Player> playersHere;
	boolean isCastingOffice;
	private int maxShotCounters;
	private int curShotCounters;
	Scene scene;

	public Location(int i){
		name = Get_Info.location[i];

		adjLocations = new Location[4];

		if (i >= 10){
			roles = null;
		}
		else {
			roles = new Role[7];
			for (int j = 0; j < 4; j++){
				roles[j] = new Off_Card(i, j);
			}
		}

		if (name.equals("Casting Office") || name.equals("Trailers")){
			maxShotCounters = -1;
		} else {
			maxShotCounters = Get_Info.markers[i];
		}
		curShotCounters = maxShotCounters;

		if (name.equals("Casting Office")){
			isCastingOffice = true;
		} else {
			isCastingOffice = false;
		}

		playersHere = new ArrayList<>();

		scene = null;
	}

	public void setNeighbors(int x, Location[] locations){
		for (int i = 0; i < 4; i++){
			String nName = Get_Info.neighbor[4*x + i];
			int j = 0;
			while (nName != null && !locations[j].getName().equals(nName)){
				j++;
				if (j == 12){
					System.out.println(nName);
				}
			}
			if (nName != null){
				adjLocations[i] = locations[j];
			} else {
				adjLocations[i] = null;
			}
		}
		// System.out.println("To recap, neighbors of "+locations[x].getName()+"are: ");
		// for (int i = 0; i < 4; i++){
		// 	System.out.println(locations[x].adjLocations[i].getName());
		// }
	}

	public boolean checkWrap(){
		if (scene == null){
			return false;
		}
		if (curShotCounters == 0){
			awardBonuses();
			for (int i = 0; i < playersHere.size(); i++){
				playersHere.get(i).stripRole();
			}
			scene = null;
			return true;
		}
		return false;
	}

	public void awardBonuses(){
		System.out.println("Scene Wrapped! Awarding Bonuses...");
		boolean trigger = false;
		int numOn = 0;
		for (int i = 0; i < playersHere.size(); i++){
			if (playersHere.get(i).getRole() != null && playersHere.get(i).getRole().getName() != null){
				if (playersHere.get(i).getRole().isOnCard()){
					numOn ++;
					trigger = true;
				}
			}
		}
		Player playersOnCard[] = new Player[numOn];
		int q = 0;
		for (int i = 0; i < numOn; i++){
			while (q < playersHere.size() &&((playersHere.get(q).getRole() == null || playersHere.get(q).getRole().getName() == null) || !playersHere.get(q).getRole().isOnCard())){
				q++;
			}
			if (q >= playersHere.size()){
				System.out.println("On Card Role not found.");
			} else {
				playersOnCard[i] = playersHere.get(q);
				q++;
			}
		}
		if (trigger){
			int dice[] = new int[scene.getBudget()];
			for (int i = 0; i < scene.getBudget(); i++){
				dice[i] = GameManager.rollDice();
			}
			Arrays.sort(dice);
			System.out.println("The dice are: "+Arrays.toString(dice));
			if (numOn == 2){
				if (playersOnCard[0].getRole().getLevel() > playersOnCard[1].getRole().getLevel()){
					Player temp = playersOnCard[0];
					playersOnCard[0] = playersOnCard[1];
					playersOnCard[1] = temp;
				}
			} else {
				for (int i = 0; i < playersOnCard.length; i++){
					int min = i;
					for (int j = i + 1; j < playersOnCard.length; j++){
						if (playersOnCard[j].getRole().getLevel() < playersOnCard[i].getRole().getLevel()){
							min = j;
						}
					}
					if (i != min){
						Player temp = playersOnCard[i];
						playersOnCard[i] = playersOnCard[min];
						playersOnCard[min] = temp;
					}
				}
			}
			int nextDie = numOn - 1;
			for (int i = dice.length - 1; i >= 0; i--){
				System.out.println("The die with result "+dice[i]
					+" will go to Player "+playersOnCard[nextDie].getpNum()
					+", whose role had a level of "
					+playersOnCard[nextDie].getRole().getLevel());
				playersOnCard[nextDie].getBank().updateDol(dice[i]);
				nextDie--;
				if (nextDie < 0){
					nextDie = numOn - 1;
				}
			}

			//off card rewards
			for (int i = 0; i < playersHere.size(); i++){
				if (playersHere.get(i).getRole() != null && playersHere.get(i).getRole().getName() != null){
					if (!playersHere.get(i).getRole().isOnCard()){
						System.out.println("Player "+playersHere.get(i).getpNum()+" had an off card role of level "+playersHere.get(i).getRole().getLevel()+"!");
						playersHere.get(i).getBank().updateDol(playersHere.get(i).getRole().getLevel());
					}
				}
			}

			//print updated bals
			for (int i = 0; i < playersHere.size(); i++){
				if (playersHere.get(i).getRole() != null && playersHere.get(i).getRole().getName() != null){
					System.out.print("Player "+playersHere.get(i).getpNum()+" ");
					playersHere.get(i).getBank().printBals();
				}
			}
		} else {
			System.out.println("No players on card, so no bonuses!");
		}
	}

	public void addPlayer (Player p){
		playersHere.add(p);
	}

	public void removePlayer (Player p){
		playersHere.remove(p);
	}

	public String getName(){
		return name;
	}

	public Location[] getAdj(){
		return adjLocations;
	}

	public int getShots(){
		return curShotCounters;
	}

	public void setMaxShots(){
		curShotCounters = maxShotCounters;
	}

	public void removeShot(){
		curShotCounters --;
	}

	public void dealScene(Scene s){
		scene = s;
		Role[] sRoles = scene.getRoles();
		for (int i = 0; i < sRoles.length; i++){
			roles[4 + i] = sRoles[i];
		}
	}

	public Scene getScene(){
		return scene;
	}

	public Role[] getRolesAvail(){
		Role[] ret = new Role[roles.length];
		int j = 0;
		for (int i = 0; i < roles.length; i++){
			if (roles[i] != null && roles[i].getName() != null){
				if (!roles[i].isTaken()){
					ret[j] = roles[i];
					j++;
				}
			}
		}
		return ret;
	}

	public boolean hasRolesAvail(){
		if (scene == null){
			return false;
		}
		boolean ret = false;
		for (int i = 0; i < roles.length; i++){
			if (roles[i] != null && roles[i].getName() != null){
				if (!roles[i].isTaken()){
					ret = true;
				}
			}
		}
		return ret;
	}

	public int getNumRolesAvail(){
		if (scene == null){
			return 0;
		}
		int ret = 0;
		for (int i = 0; i < roles.length; i++){
			if (roles[i] != null && roles[i].getName() != null){
				if (!roles[i].isTaken()){
					ret++;
				}
			}
		}
		return ret;
	}

	public int printAdj(){
		int ret = 0;
		System.out.println("The Locations adjacent to "+name+" are: ");
		for (int i = 0; i < adjLocations.length; i++){
			if (adjLocations[i] != null){
				System.out.println(adjLocations[i].getName());
				int sR = adjLocations[i].getShots();
				if (sR > 0){
					adjLocations[i].getScene().printSceneInfo();
				}
				ret ++;
			}
		}
		return ret;
	}
}
