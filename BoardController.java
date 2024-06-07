import java.util.ArrayList;

public class BoardController {
	
	private GameManager game;
	private BoardView view;

	public int rankPicked;
	private boolean movedYet;
	
	public BoardController(GameManager game, BoardView view) {
		this.game = game;
		this.view = view;
	}
	
	public void handleEndTurn() {
		view.hideCombos();
		view.hideRoll();
		view.hideSuccess();
		game.endTurn();
		movedYet = false;
	}

	public void handleUpgrade() {
		view.hideAllNotEnd();
		boolean opts[] = new boolean[6];
		if (game.getPlayer().canUpgrade()){
			for (int i = game.getPlayer().getRank(); i < 6; i++){
				opts[i] = game.getPlayer().canUpgrade(i);
				System.out.println(opts[i]);
			}
			view.upOptsPopulate(opts);
			view.showUpOpts(true);
		}
	}

	public void handleUpPicked(String choice) {
		view.showUpOpts(false);
		int rank = Character.getNumericValue(choice.charAt(5));
		rankPicked = rank;
		boolean opts[] = new boolean[2];
		opts[0] = game.getPlayer().canUpgrade(rank, 'c');
		opts[1] = game.getPlayer().canUpgrade(rank, 'd');
		view.paymentsPopulate(opts);
		view.showPayments(true);
	}

	public void handlePaymentsPicked(String choice) {
		game.getPlayer().upgrade(choice, rankPicked);
		view.upgradePlayer(game.getPlayer().getRank(), game.getPlayer().getpNum() - 1, GameManager.colors);
		ArrayList<Character> opt = new ArrayList<Character>();
		opt.add('e');
		if (!movedYet){
			opt.add('m');
		}
		view.hideCombos();
		view.startTurn(opt);
	}

	public void handleTake() {
		if (game.getPlayer().getRole() == null){
			view.hideAllNotEnd();
			System.out.println("rank: ");
			Role roles[] = game.getPlayer().getLocation().getRolesAvail(game.getPlayer().getRank());
			String roleNames[] = new String[roles.length];
			for (int i = 0; i < roles.length; i++){
				if (roles[i] != null){
					System.out.println("role avail: "+roles[i].getName());
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
		int p = game.getPlayer().getpNum() - 1;
		int r = game.getPlayer().getLocation().getRoomInd();
		int pI = game.getPlayer().getRole().getPartInd();
		int j = game.getPlayer().getRole().getCardPos();
		if (game.getPlayer().getLocation().getScene() == null){
			
			view.movePlayer(p, r, pI, 0, j);
		}
		else {
			int onRoles = game.getPlayer().getLocation().getScene().getOnRoles();
			view.movePlayer(p, r, pI, onRoles, j);
		}
		ArrayList<Character> opt = new ArrayList<Character>();
		opt.add('e');
		view.startTurn(opt);
	}

	public void handleAct() {
		if (game.getPlayer().getRole() != null){
			view.hideAllNotEnd();
			int roll = game.getPlayer().act();
			if (roll > 10){
				roll -= 10;
				view.removeShot(game.getPlayer().getLocation().getRoomInd(), game.getPlayer().getLocation().getShots());
				view.showSuccess(true);
			} else {
				view.showSuccess(false);
			}
			view.showRoll(roll);
			updateView();
		}
	}

	public void handleMove() {
		if (game.getPlayer().getRole() == null){
			view.hideAllNotEnd();
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
				view.movePlayer(i, r, -1, x, -1);
				x++;
			}
		}
		movedYet = true;
		ArrayList<Character> opt = new ArrayList<Character>();
		if (game.getPlayer().getLocation().hasRolesAvail() && game.getPlayer().canTakeRole()){
			opt.add('t');
		}
		if (game.getPlayer().canUpgrade() && game.getPlayer().getLocation().getName().equals("Casting Office")){
			opt.add('u');
		}
		opt.add('e');
		view.startTurn(opt);
	}

	public void handleRehearse() {
		if (game.getPlayer().canRehearse()){
			game.getPlayer().rehearse();
			view.hideAllNotEnd();
			view.updateChips(game.getPlayer().getRehearsed());
		}
	}

	public void startTurn(){
		updateView();
		view.startTurn(game.printOptions());
	}

	public void returnPlayers(int n){
		view.returnPlayers(n);
	}

	public void endGame(int p){
		view.hideAll();
		view.showWin(p);
	}


	public void updateView(){
		int creds = game.getPlayer().getBank().getCredits();
        int dols = game.getPlayer().getBank().getDollars();
		int tR = game.getPlayer().getRehearsed();
        view.displayStatus(game.getDaysLeft(), game.getScenesLeft(), game.getCurrentTurn(), creds, dols, tR);
	}

	public void showCardBacks(){
		view.showCardBacks();
	}
}
