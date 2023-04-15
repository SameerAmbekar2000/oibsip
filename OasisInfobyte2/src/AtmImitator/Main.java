package AtmImitator;

import java.util.Scanner;
public class Main {

    public static void main(String[] args ) {
        Atm_Operation_Interface op=new AtmOperations();
        int atmpassword=123;
        int acNumber = 12345;
        long accountNumber=12345;
        Scanner in=new Scanner(System.in);
        System.out.println("\n ****************** WELCOME TO SBI ATM SERVICES !!! ****************** ");
        
            while(true){
                System.out.println("\n1.View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.Transfer Amount\n5.Exit\n");
                System.out.print("Enter Choice : ");
                int ch=in.nextInt();
                
                if(ch==1){
                	System.out.print("Enter ATM Pin: ");
                    int pin=in.nextInt();
                	if(atmpassword == pin){
                		 System.out.println("Account Authorized!\n");
                		 op.viewBalance();
                	    }
                	else{
                        System.out.println("Incorrect ATM pin");
                        System.exit(0);
                    }
                }
                
                else if(ch == 2){
                	System.out.print("Enter ATM Pin: ");
                    int pin=in.nextInt();
                	if(atmpassword == pin){
                	    System.out.println("Account Authorized!\n");
                		System.out.println("Enter amount to withdraw ");
                		 	double withdrawAmount=in.nextDouble();
                		 	op.withdrawAmount(withdrawAmount);
                	 }
                	else{
                        System.out.println("Incorrect Atm Number or pin");
                        System.exit(0);
                    }
                }
                
                else if(ch == 3){
                	System.out.print("Enter ATM Pin: ");
                    int pin=in.nextInt();
                	if(atmpassword==pin){
                		System.out.println("Account Authorized! \n");
                        System.out.println("Enter Amount to Deposit :");
                        double depositAmount=in.nextDouble();
                        op.depositAmount(depositAmount);
                	}
                	else{
                         System.out.println("Incorrect Atm pin");
                         System.exit(0);
                    }
                }
                
                else if(ch == 4){
                	System.out.print("Enter your ATM Pin: ");
                    int pin=in.nextInt();
                	if(atmpassword == pin){
                	    System.out.println("Your Account Authorized!\n");
                	    System.out.print("Enter Account Number of receiver : ");
                        int accountNumber1=in.nextInt();
                    	if(acNumber == accountNumber1){
                    	    System.out.println("Receiver's Account Authorized!\n");
                		System.out.println("Enter amount to be Tranferred ");
                		 	double transferAmount=in.nextDouble();
                		 	op.transferAmount(transferAmount);
                		 	
                	 }
                	}
                 else if(ch == 5){
                    System.out.println(" Collect your ATM Card\n Thank you for using SBI Atm Services!!");
                    System.out.println(" Have a Good Day Ahead !! ");
                    System.exit(0);
                }
                	
                else
                    {
                        System.out.println("Please enter valid choice");
                    }
                }
            }
    }
}

