@SuppressWarnings ("unused")
public class Role {

    private int level;
    private boolean taken;
    private String name;
    private int partInd;
    private int cardPos;
    
    public Role (int i, int j, boolean on){
        if (on){
            partInd = -2;
            cardPos = j;
            name = Get_Info.part[i*3 + j];
            level = Get_Info.roleLevel[i*3 + j];
        } else {
            cardPos = -1;
            partInd = i*4 + j;
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

    public int getPartInd(){
        return partInd;
    }

    public int getCardPos(){
        return cardPos;
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
