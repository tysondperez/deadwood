@SuppressWarnings ("unused")
public class Role {

    private int level;
    private boolean taken;
    private String name;
    
    public Role (int i, int j, boolean on){
        if (on){
            name = Get_Info.part[i + j];
            level = Get_Info.roleLevel[i + j];
        } else {
            name = Get_Info.partsAndLine[0][i + j];
            level = Get_Info.partLevel[i + j];
        }
        taken = false;
    }

    public void viewScene()
    {
    	//at location, view the scene, get available roles and rank requirement from xml file
    	//find empty roles
    	
    }

    public String getName(){
        return name;
    }

    public boolean isTaken(){
        return taken;
    }

    public boolean isOnCard(){
        return false;
    }

    public void take(){
        taken = true;
    }

    public void printInfo(){
        System.out.println(name);
        System.out.println("\tLevel: "+level);
    }

}
