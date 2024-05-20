public class On_Card extends Role {
    
	public On_Card (int i, int j){
		super(i, j, true);
	}

    public void getRewards(boolean success){
    	if(success) {
    		//add two credits
    	}
    	
    }
	
	@Override
	public boolean isOnCard(){
		return true;
	}
}
