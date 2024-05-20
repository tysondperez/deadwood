public class Off_Card extends Role {

	public Off_Card (int i, int j){
		super(i, j, false);
	}
    
    public void getRewards(boolean success, Player p){
    	
    	if (success) {
    		//add one dollar and one credit
			p.getBank().updateDol(1);
			p.getBank().updateCred(1);
			System.out.println("You earned 1 dollar and 1 credit!");
    	}
    	else {
    		//add one dollar
			p.getBank().updateDol(1);
			System.out.println("You earned 1 dollar!");
    	}
		p.getBank().printBals();
        
    }

	@Override
	public boolean isOnCard(){
		return false;
	}
}
