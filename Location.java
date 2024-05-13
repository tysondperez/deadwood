import java.util.ArrayList;

@SuppressWarnings ("unused")
public class Location {

	private String name;
	private Role[] roles;
	private Location[] adjLocations;
	private ArrayList<Player> playersHere;
	boolean isCastingOffice;
	Scene scene;

	public Location(String n){
		name = n;
		playersHere = new ArrayList<>();
	}

	public void awardBonuses(){
		
	}

	public void addPlayer (Player p){
		playersHere.add(p);
	}

	public String getName(){
		return name;
	}

}
