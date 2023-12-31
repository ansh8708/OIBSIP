/*
Name - Ansh Agrawal
Topic - Atm Interface
Operations used are as follows---
1.Transactions History
2.Withdraw
3.Deposit
4.Transfer
5.Quit
 */
//Atm interface
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class ATM {
    private double balance;
    private double deposit_Amount;
    private double withdraw_Amount;


    public ATM(){

    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDepositAmount() {
        return deposit_Amount;
    }

    public void setDepositAmount(double deposit_Amount) {
        this.deposit_Amount = deposit_Amount;
    }

    public double getWithdrawAmount() {
        return withdraw_Amount;
    }

    public void setWithdrawAmount(double withdraw_Amount) {
        this.withdraw_Amount = withdraw_Amount;
    }
}

interface AtmOperationInterface {
    public void viewBalance();
    public void withdraw_Amount(double withdraw_Amount);
    public void deposit_Amount(double deposit_Amount );
    public  void viewMiniStatement();
}


class AtmOperationImpl implements AtmOperationInterface{
    ATM atm=new ATM();
    Map<Double,String> ministmt= new HashMap<Double, String>();
    @Override
    public void viewBalance() {
        System.out.println("Remaining Balance is : "+atm.getBalance());

    }

    @Override
    public void withdraw_Amount(double withdraw_Amount) {
        if(withdraw_Amount%100==0) {
            if (withdraw_Amount <= atm.getBalance()) {
                ministmt.put(withdraw_Amount, " Amount Withdrawn");
                System.out.println("Collect the Cash " + withdraw_Amount);
                atm.setBalance(atm.getBalance() - withdraw_Amount);
                viewBalance();
            } else {
                System.out.println("Bank Balance is not Sufficient: ");
            }
        }
        else {
            System.out.println("Enter the amount in multiple of 100: ");
        }

    }

    @Override
    public void deposit_Amount(double deposit_Amount) {
        ministmt.put(deposit_Amount," Amount Deposited !!");
        System.out.println(deposit_Amount+" Deposited Successfully !!");
        atm.setBalance(atm.getBalance()+deposit_Amount);
        viewBalance();

    }

    @Override
    public void viewMiniStatement() {
        for(Map.Entry<Double,String> m:ministmt.entrySet()){
            System.out.println(m.getKey()+""+m.getValue());
        }

    }
}
public class AtmInterface {
    public static void main(String[] args) {
        AtmOperationInterface op=new AtmOperationImpl();
        int atmNum=98765;
        int atmPin=123;
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to ATM Machine Of Bank of India");
        System.out.print("Enter Your Atm Number : ");
        int atmNumber=sc.nextInt();
        System.out.print("Enter the Pin: ");
        int pin=sc.nextInt();
        if((atmNum==atmNumber)&&(atmPin==pin)){
            while(true){
                System.out.println("1.View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.View Ministatement\n5.Exit");
                System.out.println("Enter Your Choice : ");
                int ch=sc.nextInt();
                if(ch==1){
                    op.viewBalance();

                }
                else if(ch==2){
                    System.out.println("Enter Withdrawal Amount: ");
                    double withdrawAmount=sc.nextDouble();
                    op.withdraw_Amount(withdrawAmount);

                }
                else if(ch==3){
                    System.out.println("Enter Amount to be Deposited :");
                    double depositAmount=sc.nextDouble();
                    op.deposit_Amount(depositAmount);
                }
                else if(ch==4){
                    op.viewMiniStatement();

                }
                else if(ch==5){
                    System.out.println("Collect your ATM Card\n Thank you for using ATM Machine!!");
                    System.exit(0);
                }
                else
                {
                    System.out.println("Please enter the correct choice: ");
                }
            }
        }
        else{
            System.out.println("The Atm Number or pin You have Entered is Incorrect");
            System.exit(0);
        }
    }
}
