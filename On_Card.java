public class On_Card extends Role {
    
	public On_Card (int i, int j){
		super(i, j, true);
	}

    public void getRewards(boolean success, Player p){
    	if(success) {
    		//add two credits
			p.getBank().updateCred(2);
			System.out.println("You earned 2 credits!");
			p.getBank().printBals();
    	}
    }
	
	@Override
	public boolean isOnCard(){
		return true;
	}
}
