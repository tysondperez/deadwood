@SuppressWarnings ("unused")
public class Role {

    private int level;
    private boolean taken;
    private String name;
    
    public Role (int i, int j, boolean on){
        if (on){
            name = Get_Info.part[i*3 + j];
            level = Get_Info.roleLevel[i*3 + j];
        } else {
            name = Get_Info.partsAndLine[0][i*4 + j];
            level = Get_Info.partLevel[i*4 + j];
        }
        taken = false;
    }

    public void getRewards(boolean success, Player player) {
        System.out.println("shouldn't have been called");
    }

    public void viewScene()
    {
    	//at location, view the scene, get available roles and rank requirement from xml file
    	//find empty roles
    	
    }

    public String getName(){
        return name;
    }

    public int getLevel(){
        return level;
    }

    public boolean isTaken(){
        return taken;
    }

    public boolean isOnCard(){
        System.out.println("shouldn't have been called");
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
