import java.util.ArrayList;
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
        GameManager game = new GameManager(numP);

        //core gameplay loop
        while(game.getDaysLeft() > 0){
            game.printStatus();
            ArrayList<Character> options = game.printOptions();
            System.out.print("Please input your choice: ");
            char choice = input.next().charAt(0);
            // --------------------------------------------------------------THIS IS IN HERE FOR TESTING TAKE OUT WHEN DONE----------------------
            if (choice == 'q'){
                break;
            }
            while (!options.contains(choice)){
                System.out.println("Invalid Input! Please try again: ");
                choice = input.next().charAt(0);
            }
            Player curPlayer = game.getPlayer();
            if (choice == 'e'){
                System.out.println("Chose to end turn");
            } else if (choice == 'a'){
                System.out.println("Chose to act");
                curPlayer.act();
            } else if (choice == 'r'){
                System.out.println("Chose to rehearse");
                curPlayer.rehearse();
            } else if (choice == 'm'){
                System.out.println("Chose to move");
                curPlayer.move(input);
                if ((curPlayer.getLocation().getName().equals("Casting Office"))){
                    if (!curPlayer.canUpgrade()){
                        System.out.println("You're on the Casting Office, but you can't upgrade right now!");
                    } else {
                        System.out.print("Would you also like to upgrade? (y/n): ");
                        choice = input.next().charAt(0);
                        while ((choice != 'y') && (choice != 'n')){
                            System.out.println("Invalid Input! Please try again: ");
                            choice = input.next().charAt(0);
                        }
                        if (choice == 'y'){
                            curPlayer.upgrade(input);
                        }
                    }
                }
                else if (!curPlayer.getLocation().getName().equals("Trailers")){
                    if (!curPlayer.getLocation().hasRolesAvail() || !curPlayer.canTakeRole()){
                        System.out.println("This location has no available roles for you!");
                    } else {
                        System.out.print("Would you also like to take a role? (y/n): ");
                        choice = input.next().charAt(0);
                        while ((choice != 'y') && (choice != 'n')){
                            System.out.println("Invalid Input! Please try again: ");
                            choice = input.next().charAt(0);
                        }
                        if (choice == 'y'){
                            curPlayer.takeRole(input);
                        }
                    }
                }
            } else if (choice == 't'){
                System.out.println("Chose to take role");
                curPlayer.takeRole(input);
            } else if (choice == 'u'){
                System.out.println("Chose to upgrade");
                curPlayer.upgrade(input);
                System.out.print("Would you also like to move? (y/n): ");
                choice = input.next().charAt(0);
                while ((choice != 'y') && (choice != 'n')){
                    System.out.println("Invalid Input! Please try again: ");
                    choice = input.nextLine().charAt(0);
                }
                if (choice == 'y'){
                    curPlayer.move(input);
                    System.out.println(curPlayer.getLocation().hasRolesAvail());
                    if (!curPlayer.getLocation().hasRolesAvail() || !curPlayer.canTakeRole()){
                        System.out.println("This location has no available roles for you!");
                    } else {
                        System.out.print("Would you also like to take a role? (y/n): ");
                        choice = input.next().charAt(0);
                        while ((choice != 'y') && (choice != 'n')){
                            System.out.println("Invalid Input! Please try again: ");
                            choice = input.next().charAt(0);
                        }
                        if (choice == 'y'){
                            curPlayer.takeRole(input);
                        }
                    }
                }
            }
            game.endTurn();
        }
        input.close();
    }
}

