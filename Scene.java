import java.util.ArrayList;

@SuppressWarnings ("unused")
public class Scene {

	private Role[] roles;
	private String name;
	private int budget;
	private Location assignedTo;

	//this method is called with a random unused i from 0-39
	public Scene(int i, Location l){
		name = Get_Info.cardName[i];
		budget = Get_Info.budget[i];
		assignedTo = l;
		roles = new Role[3];
		for (int j = 0; j < roles.length; j++){
			roles[j] = new On_Card(i, j);
		}
	}
	
	public Role[] getRoles(){
		return roles;
	}

	public void wrapScene(){
		//for every person on scene
		//determine if on using Role class
		//then credit based on that
		
	}

}
