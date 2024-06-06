import java.util.ArrayList;

public class BoardController {
	
	private GameManager game;
	private BoardView view;
	
	public BoardController(GameManager game, BoardView view) {
		this.game = game;
		this.view = view;
	}
	
	public void handleEndTurn() {
		game.endTurn();
	}
	public void handleUpgrade() {
		
	}
	public void handleTake() {
		if (game.getPlayer().getRole() == null){
			Role roles[] = game.getPlayer().getLocation().getRolesAvail(game.getPlayer().getRank());
			String roleNames[] = new String[roles.length];
			for (int i = 0; i < roles.length; i++){
				if (roles[i] != null){
					roleNames[i] = roles[i].getName();
				}
			}
			view.roleOptsPopulate(roleNames);
			view.showRoleOpts(true);
		}
	}

	public void handleTakePicked(String choice) {
		view.showRoleOpts(false);
		//player.take
		game.getPlayer().takeRole(choice);
		//view.update(params)
		ArrayList<Character> opt = new ArrayList<Character>();
		opt.add('e');
		view.startTurn(opt);
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
		}
	}

	public void handleMovePicked(String choice) {
		view.showAdjLoc(false);
		int movedR = game.getPlayer().move(choice);
		int x = 0;
		for (int i = 0; i < game.getNumPlayers(); i++){
			int r = game.getPlayer(i + 1).getLocation().getRoomInd();
			if (r == movedR && game.getPlayer(i + 1).getRole() == null){
				if (game.getPlayer(i + 1).getLocation().getScene() != null && !game.getPlayer(i + 1).getLocation().getScene().getFaceUp()){
					game.getPlayer(i + 1).getLocation().getScene().flip();
					view.revealCard(r, game.getPlayer(i + 1).getLocation().getScene().getCardNum());
				}
				view.movePlayer(i, r, -1, x);
				x++;
			}
		}
		//maybe code for ask if want role here
		ArrayList<Character> opt = new ArrayList<Character>();
		if (game.getPlayer().getLocation().hasRolesAvail() && game.getPlayer().canTakeRole()){
			opt.add('t');
		}
		opt.add('e');
		view.startTurn(opt);
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

	public void showCardBacks(){
		view.showCardBacks();
	}
}
