package AtmImitator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AtmOperations implements Atm_Operation_Interface{
    ATM atm=new ATM();
    Map<Double,String> ministmt=new HashMap<>();
    
    //Method to View Balance
    @Override
    public void viewBalance() {
    	System.out.println("\nLoading Accout Balance.......");
        System.out.println("Your Current Balance is : "+atm.getBalance());
        	System.out.println();
    }

    //Method to Withdraw Amount
    @Override
    public void withdrawAmount(double withdrawAmount) {
    	Scanner sc=new Scanner(System.in);
        if(withdrawAmount%100==0) {
            if (withdrawAmount <= atm.getBalance()) {
            	System.out.println("Please confirm ? Y/N");
            	String confirm=sc.next();
            	if(confirm.equals("Y")) {
                ministmt.put(withdrawAmount, " Amount Withdrawn");
                System.out.println("Collect the Cash " + withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            	}
            } else {
                System.out.println("Your Account has insufficient Balance !!");
            }
        }
        else {
            System.out.println("Please enter the amount in multiple of 100");
        }

    }

    //Method to deposit Amount
    @Override
    public void depositAmount(double depositAmount) {
    	System.out.println("Confirm? Y/N");
    	Scanner sc=new Scanner(System.in);
    	String confirm=sc.next();
	    if(confirm.equals("Y")) {
        ministmt.put(depositAmount," Amount Deposited");
        System.out.println(depositAmount+" rupees deposited Successfully !!");
        atm.setBalance(atm.getBalance()+depositAmount);
        viewBalance();
        
	    }
    }
    @Override
    public void transferAmount(double transferAmount) {
    	Scanner sc=new Scanner(System.in);
        if(transferAmount%100==0) {
            if (transferAmount <= atm.getBalance()) {
            	System.out.println("Please confirm ? Y/N");
            	String confirm=sc.next();
            	if(confirm.equals("Y")) {
                System.out.println( " The Amount is Transferred Successfully ");
                
                atm.setBalance(atm.getBalance() - transferAmount);
                viewBalance();
            	}
            } else {
                System.out.println("Your Account has insufficient Balance !!");
            }
        }
  
}
}

