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
		for (int j = 0; j < 4; j++){
			roles[j] = new Off_Card(i, j);
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
			String nName = Get_Info.neighbor[x + i];
			int j = 0;
			while (!locations[j].getName().equals(nName)){
				j++;
			}
			adjLocations[i] = locations[j];
		}
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

	public String getName(){
		return name;
	}

	public Role[] getRolesAvail(){
		Role ret[] = new Role[roles.length];
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
}
