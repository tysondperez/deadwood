import java.util.Scanner;

public class Deadwood{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of players: ");
        int numP = input.nextInt();
        while (numP < 2 || numP > 8){
            if (numP < 2){
                System.out.print("Sorry, you need at least 2 players!\nEnter the number of players: ");
            }
            else {
                System.out.print("Sorry, this game only goes up to 8 players!\nEnter the number of players: ");
            }
            numP = input.nextInt();
        }
    }
}

