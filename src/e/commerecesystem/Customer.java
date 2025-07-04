 package e.commerecesystem;
public class Customer {
    private double balance;

    public Customer(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    public void deductBalance(double amount){
        if(amount<=0){
             throw new IllegalArgumentException("Amount must be greater than zero.");
        }
        else if(amount>balance){
             throw new IllegalStateException("Insufficient balance. Available: " + balance + ", Required: " + amount);
        }
        balance -= amount;
        
    }
}
