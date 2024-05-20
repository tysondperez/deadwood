@SuppressWarnings ("unused")
public class Role {

    private int level;
    private boolean taken;
    private String name;
    
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
