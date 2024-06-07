@SuppressWarnings ("unused")
public class Bank {
    
    private Player bankOwner;
    private int creditBal;
    private int dollarBal;

    public Bank(Player p, int sC){
        bankOwner = p;
        creditBal = sC;
        dollarBal = 0;
    }

    public void updateCred(int change){
        creditBal += change;
    }

    public void updateDol(int change){
        dollarBal += change;
    }

    public int getCredits(){
        return creditBal;
    }

    public int getDollars(){
        return dollarBal;
    }

    public void printBals(){
        System.out.println("Current Balances:");
        System.out.println("\tDollars: "+dollarBal);
        System.out.println("\tCredits: "+creditBal);
    }
}
