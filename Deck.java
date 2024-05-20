@SuppressWarnings ("unused")
public class Deck{
//new edit: change name to static, add object Scene	
	Get_Info card = new Get_Info();
	Scene findBudget = new Scene();
	public static String[] name = new String[9]; //keeps track of the card name
	public int[] randInd = new int[9];  //keeps track of the index numbers
	private final int max = 39;
	private final int min = 0;
	
	
	public void dealCards(){
		//40 total cards, get 10 indexes at random
        
        int range = max - min + 1;
        int i = 0;
        while (i <= 9){
        	int rand = (int)(Math.random() * range) + min; //rand keeps track of indexes we're working with
        	name[i] = card.getCardName(rand);               //get 10 cards to play with
        	if (name[i] == null) {
        		while (name[i] != null)
        		{
        			rand = (int)(Math.random() * range) + min;
                	name[i] = card.getCardName(rand);
        		}
        	}
        	randInd[i] = rand;
        	findBudget.getBudget(rand); //new edit
        	card.removeCard(rand);
        	i++;
            
        }
       
        		
	}
	

	public void resetCards() {
		int i = 0;
		while (i <= 9){
			name[i] = null;
			randInd[i] = 0;
			i++;
	
		}
		findBudget.resetDay();
		
	}
}
