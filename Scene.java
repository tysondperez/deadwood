import java.util.ArrayList;

@SuppressWarnings ("unused")
public class Scene {

	//private int budget;
	private Role[] roles;
	private String name;
	//edits start here:
	Deck getScenes = new Deck();
	private int i;
	private int j;
	private int[] budget = new int[9];
	private String[] availRoles = new String[27];
	private int[] level = new int[27];
	
	public void getBudget(int index) { //pass rand to index, if we passed rand, that means we confirmed that there is a scene
		budget[i] = Get_Info.budget[index];
		i++;
	}
	
	public void getRoles(int index){ //rand is the index
		if (index == 0){
			int store = index + 2;
			while (index <= store) {
				availRoles[j] = Get_Info.part[index];
				level[j] = Get_Info.roleLevel[index];
				index++;
							
			}
							
		}
		else {		
				index = index * 3;
				int store = index + 2;
				while (index <= store) {
					availRoles[j] = Get_Info.part[index];
					level[j] = Get_Info.roleLevel[index];
							index++;
				}
		}
	}
		
	
	public void resetDay(){
		i = 0;
	}

	
	public void wrapScene(){
		//for every person on scene
		//determine if on using Role class
		//then credit based on that
		
	}

}
