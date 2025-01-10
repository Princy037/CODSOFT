import java.util.Scanner;

// Class representing the User's Bank Account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= 1000) { // Ensure balance does not fall below 1000 rupees
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Withdrawal would bring balance below minimum required (1000 rupees).");
        }
    }
}

// Class representing the ATM Machine
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            // Updated dynamic ATM Menu
            System.out.println("\n Welcome to the ATM");
            System.out.println("1. View Current Balance");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Make a Withdrawal");
            System.out.println("4. Exit ATM");
            System.out.print("Select an option (1-4): ");

            int choice = getValidChoice();

            switch (choice) {
                case 1:
                    viewBalance();
                    break;
                case 2:
                    depositFunds();
                    break;
                case 3:
                    makeWithdrawal();
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM service. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    // Helper method to get a valid choice input from the user
    private int getValidChoice() {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 4) {
                    return choice;
                } else {
                    System.out.println("Please choose a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private void viewBalance() {
        System.out.printf("Your current balance is: %.2f Rupees\n", account.getBalance());
    }

    private void depositFunds() {
        System.out.print("Enter the amount you want to deposit: ");
        double amount = getValidAmount();
        account.deposit(amount);
    }

    private void makeWithdrawal() {
        System.out.print("Enter the amount you wish to withdraw: ");
        double amount = getValidAmount();
        account.withdraw(amount);
    }

    // Helper method to get a valid amount (positive number)
    private double getValidAmount() {
        while (true) {
            try {
                double amount = Double.parseDouble(scanner.nextLine());
                if (amount > 0) {
                    return amount;
                } else {
                    System.out.println("Amount must be positive. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a valid number.");
            }
        }
    }
}

// Main class to run the ATM program
public class ATMInterface {
    public static void main(String[] args) {
        // Initialize a bank account with an initial balance of 1000 rupees
        BankAccount account = new BankAccount(1000.0); // Starting with a balance of 1000 rupees

        // Create the ATM and start the interface
        ATM atm = new ATM(account);
        atm.start();
    }
}
