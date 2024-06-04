import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Deadwood{
    public static void main(String args[]){
        //create new view
        BoardView view = new BoardView();
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(1400, 1010);
        view.setVisible(true);


        int numP = Integer.parseInt(JOptionPane.showInputDialog(view, "How many players?"));
        while (numP < 2 || numP > 8){
            if (numP < 2){
                numP = Integer.parseInt(JOptionPane.showInputDialog(view,
                "Sorry, you need at least 2 players!\nEnter the number of players: "));
            }
            else {
                numP = Integer.parseInt(JOptionPane.showInputDialog(view,
                "Sorry, this game only goes up to 8 players!\nEnter the number of players: "));
            }
        }
        GameManager game = new GameManager(numP);
        BoardController controller = new BoardController(game, view);
        game.setController(controller);
        view.setController(controller);
        view.createPlayers(numP, GameManager.colors);
        controller.updateView();
        controller.startTurn();
    }  
}