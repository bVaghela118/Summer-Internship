import java.util.Observable;
import java.util.Observer;

class Bank {

    Account a1, a2; // references of Account
    customer c1, c2; // references of Customer

    Bank() {
        c1 = new customer("Bhavin", "C001", a1 = new Account(15000, "A001"));
        c2 = new customer("Parth", "C002", a2 = new Account(12000, "A002"));
        a1.addObserver(c1); // customer object is added as observer to account
        a2.addObserver(c2);// customer object is added as observer to account
    }

    public static void main(String args[]) {
        Bank b = new Bank();
        b.displayDemo();
    }

    public void displayDemo() {
        a1.credit(10000);
        a1.debit(5000);
        a2.credit(5000);
        a2.debit(20000);
    }
}

class customer implements Observer {
    String custname;
    String custId;
    Account act;

    // constructor
    customer(String name, String id, Account acc) {
        this.custname = name;
        this.custId = id;
        this.act = acc;
    }

    public void update(Observable obs, Object obj) {
        System.out.println("\t" + custname + " Account balance :" + ((Account) obs).getBalance());// cast observable to
                                                                                                  // account
        // to called the getBalance
        // Method
    }
}

class Account extends Observable {

    float balance;
    String accNo;

    Account() {
        balance = 0;
        accNo = "";
    }

    Account(float bal, String aNo) {
        balance = bal;
        accNo = aNo;
    }

    float getBalance() {
        return balance;
    }

    void setBalance(float b) {
        balance = b;
    }

    String getAccNo() {
        return accNo;
    }

    void setAccountNo(String n) {
        accNo = n;
    }

    public void credit(float amnt) {
        balance += amnt;
        setChanged(); // mark as observer object has been changed
        notifyObservers(this);// Notify Observer of change
    }

    public void debit(float amnt) {
        if (balance > amnt) {
            balance -= amnt;
            setChanged(); // Mark as Object is changed
            notifyObservers(this); // Notify observer to change
        } else {
            System.out.println("\tBalance is insufficient!!!");
            System.out.print("\tyou try to debit amount is: " + amnt + " and your");
            setChanged();
            notifyObservers(this);// Notify observer to change
        }
    }
}
