import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardController {
	
	private GameManager game;
	private BoardView view;
	
	public BoardController(GameManager game, BoardView view) {
		this.game = game;
		this.view = view;
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
		game.getPlayer().move(choice);
		game.endTurn();
	}

	public void handleRehearse() {
		if (game.getPlayer().canRehearse()){
			game.getPlayer().rehearse();
		}
	}

	public void startTurn(){
		view.startTurn(game.printOptions());
	}

	public void updateView(){
		int creds = game.getPlayer().getBank().getCredits();
        int dols = game.getPlayer().getBank().getDollars();
        view.displayStatus(game.getDaysLeft(), game.getScenesLeft(), game.getCurrentTurn(), creds, dols);
	}
}
