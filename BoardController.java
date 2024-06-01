import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardController implements ActionListener {
	
	private BoardModel model;
	private BoardView view;
	
	public BoardController(BoardModel model, BoardView view) {
		this.model = model;
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
