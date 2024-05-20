import java.util.ArrayList;

@SuppressWarnings ("unused")
public class Scene {

	private Role[] roles;
	private String name;
	private int budget;
	private Location assignedTo;
	private boolean faceUp;

	//this method is called with a random unused i from 0-39
	public Scene(int i, Location l){
		name = Get_Info.cardName[i];
		budget = Get_Info.budget[i];
		assignedTo = l;
		roles = new Role[3];
		for (int j = 0; j < roles.length; j++){
			roles[j] = new On_Card(i, j);
		}
		faceUp = false;
	}
	
	public Role[] getRoles(){
		return roles;
	}

	public int getBudget(){
		return budget;
	}

	public void flip(){
		if (!faceUp){
			faceUp = true;
		}
	}

	public void printSceneInfo(){
		if (faceUp){
			System.out.println("\tRoles Available: "+assignedTo.getNumRolesAvail());
			System.out.println("\tShots Remaining: "+assignedTo.getShots());
		} else {
			int count = 0;
			Role[] locRoles = assignedTo.getRolesAvail();
			for (int i = 0; i < locRoles.length; i++){
				if (locRoles[i] != null && locRoles[i].getName() != null){
					if (!locRoles[i].isTaken() && !locRoles[i].isOnCard()){
						count++;
					}
				}
			}
			System.out.println("\tRoles Available: "+count+" + ??? on card");
			System.out.println("\tShots Remaining: ");
		}
	}
}
