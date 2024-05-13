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

    }

    public void updateDol(int change){

    }

    public int getCredits(){
        return creditBal;
    }

    public int getDollars(){
        return dollarBal;
    }
}
