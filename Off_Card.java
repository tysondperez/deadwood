public class Off_Card extends Role {

	public Off_Card (int i, int j){
		super(i, j, false);
	}
    
    public void getRewards(boolean success){
    	
    	if (success) {
    		//add one dollar and one credit
    	}
    	else {
    		//add one dollar
    	}
        
    }

	public boolean isOnCard(){
		return false;
	}
}
