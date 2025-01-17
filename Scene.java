import java.util.ArrayList;

@SuppressWarnings ("unused")
public class Scene {

	private Role[] roles;
	private String name;
	private int budget;
	private Location assignedTo;
	private boolean faceUp;
	private int cardNum;

	//this method is called with a random unused i from 0-39
	public Scene(int i, Location l){
		cardNum = i;
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

	public boolean getFaceUp(){
		return faceUp;
	}

	public int getCardNum(){
		return cardNum;
	}

	public int getOnRoles(){
		int count = 0;
		for (int j = 0; j < roles.length; j++){
			if (roles [j] != null && roles[j].getName() != null)
			count++;
		}
		return count;
	}
}
