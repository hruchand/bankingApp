import java.util.Scanner;

class BankAccount
{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;
    BankAccount(String cname, String cid)
    {
        customerName = cname;
        customerId = cid;

    }
    void deposit(int amount)
    {
        if(amount !=0)
        {
            balance += amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount)
    {
        if(amount != 0)
        {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    void getPrevTransaction()
    {
        if(previousTransaction > 0)
        {
            System.out.println("Deposited" + previousTransaction);
        }
        else if (previousTransaction < 0)
        {
            System.out.println("Withdrawn" + Math.abs(previousTransaction));
        }
        else
        {
            System.out.println("No Transaction has happened");
        }
    }

    void showMenu()
    {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your customer ID is " + customerId);
        System.out.println("Available options \n");
        System.out.println("A. Check Balance \n B. Deposit \n C. Withdraw \n D. Previous Transaction \n E. Exit\n");

        do
        {
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'A':
                    System.out.println("Current Balance: " + balance);
                    break;

                case 'B':
                    int depositAmount = scanner.nextInt();
                    deposit(depositAmount);
                    System.out.println("\n");
                    break;
                case 'C':
                    int withdrawAmount = scanner.nextInt();
                    withdraw(withdrawAmount);
                    System.out.println("\n");
                    break;
                case 'D':
                    getPrevTransaction();
                    System.out.println("\n");
                    break;
                case 'E':
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Unknown Option");
                    break;
            }

        } while (option != 'E');
        System.out.println("Thanks for using this App.");
    }
}