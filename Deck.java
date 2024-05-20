import java.util.ArrayList;

@SuppressWarnings ("unused")
public class Deck{
//new edit: change name to static, add object Scene	
	private static final int max = 39;
	private static final int min = 0;
	private static ArrayList <Integer> used = new ArrayList<Integer>();
	
	
	public static void dealCards(){
		//40 total cards, get 10 indexes at random
        int range = max - min + 1;
		for (int i = 0; i < 10; i++){
			int rand = (int)(Math.random() * range) + min;
			while (used.contains(rand)){
				rand = (int)(Math.random() * range) + min;
			}
			used.add(rand);
			GameManager.locations[i].dealScene(new Scene(rand, GameManager.locations[i]));
		}
	}
	
	public void shuffleCards() {
		used = new ArrayList<Integer>();
	}
}
