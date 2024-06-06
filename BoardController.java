import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardController {
	
	private GameManager game;
	private BoardView view;
	
	public BoardController(GameManager game, BoardView view) {
		this.game = game;
		this.view = view;
	}
	
	public void handleEndTurn() {
		
	}

	public void handleAct() {
		if (game.getPlayer().getRole() != null){
			game.getPlayer().act();
		}
	}

	public void handleMove() {
		if (game.getPlayer().getRole() == null){
			view.adjLocPopulate(game.getPlayer().getLocation().getAdjNames());
			view.showAdjLoc(true);
			System.out.println("triggered handleMove");
		}
	}

	public void handleMovePicked(String choice) {
		view.showAdjLoc(false);
		int movedR = game.getPlayer().move(choice);
		int x = 0;
		for (int i = 0; i < game.getNumPlayers(); i++){
			int r = game.getPlayer(i + 1).getLocation().getRoomInd();
			if (r == movedR && game.getPlayer(i + 1).getRole() == null){
				System.out.println("moving a dude! player: "+(i + 1));
				view.movePlayer(i, r, -1, x);
				x++;
			} else {
				System.out.println("skipped over");
				System.out.println("r: "+r+", movedR: "+movedR);
			}
		}
		//maybe code for ask if want role here
		game.endTurn();
	}

	public void handleRehearse() {
		if (game.getPlayer().canRehearse()){
			game.getPlayer().rehearse();
		}
	}

	public void startTurn(){
		updateView();
		view.startTurn(game.printOptions());
	}

	public void updateView(){
		int creds = game.getPlayer().getBank().getCredits();
        int dols = game.getPlayer().getBank().getDollars();
        view.displayStatus(game.getDaysLeft(), game.getScenesLeft(), game.getCurrentTurn(), creds, dols);
	}
}
