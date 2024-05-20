import java.util.ArrayList;

@SuppressWarnings ("unused")
public class Location {

	private String name;
	private Role[] roles;
	private Location[] adjLocations; //get adjacent locations to current location from xml file
	private ArrayList<Player> playersHere;
	boolean isCastingOffice;
	private int shotCounters;
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
			shotCounters = -1;
		} else {
			shotCounters = Get_Info.markers[i];
		}
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

	public void awardBonuses(){
		//check if there are more than one players and at least one player on the card
		/*
		 * if(playersHere > 1 && player.On_Card >= 1){
		 * 
		 * 		for (int i = 1; i <= budget; i++){
		 *  		collect[c] = GameManager.rollDie();
		 *  		c++;
		 * 		}
		 * 	
		 * 		while (collect [i] != 0){
		 * 
		 * 			for (int i = 0; i < c, i++){
		 * 				//assign die to current player
		 * 				//if player = 0, restart the list
		 * 			}
		 * 		}
		 *
		*/
		
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
		return shotCounters;
	}

	public void dealScene(Scene s){
		scene = s;
		Role[] sRoles = scene.getRoles();
		for (int i = 0; i < sRoles.length; i++){
			roles[4 + i] = sRoles[i];
		}
	}

	public Role[] getRolesAvail(){
		Role[] ret = new Role[roles.length];
		int j = 0;
		for (int i = 0; i < roles.length; i++){
			if (roles[i] != null){
				if (!roles[i].isTaken()){
					ret[j] = roles[i];
					j++;
				}
			}
		}
		return ret;
	}

	public boolean hasRolesAvail(){
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
					System.out.println("\tRoles Available: "+adjLocations[i].getNumRolesAvail());
					System.out.println("\tShots Remaining: "+sR);
				}
				ret ++;
			}
		}
		return ret;
	}
}
