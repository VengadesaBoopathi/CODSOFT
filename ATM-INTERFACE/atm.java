import java.util.*;

class atm {
    static Scanner input = new Scanner(System.in);
    static Bank account = new Bank();
    
    public static void main(String[] args) {
        int choice = 1;
        int account_number=0;
        while (choice != 5) {
            
            System.out.println("\n\n-----------------------ATM-----------------------");
            System.out.println("-------------PRESS 1 TO ACCOUNT CREATION---------");
            System.out.println("-------------PRESS 2 TO WITHDRAWAL---------------");
            System.out.println("-------------PRESS 3 TO DEPOSIT------------------");
            System.out.println("-------------PRESS 4 TO BALANCE CHECK------------");
            System.out.println("-------------PRESS 5 TO EXIT---------------------\n\n");
            System.out.print("ENTER YOUR CHOICE         ");
            choice = input.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("SUCCESSFULLY ACCOUNT CREATED WITH ZERO BALANCE");
                    account_number++;
                    System.out.println("YOUR ACCOUNT NUMBER     "+account_number);
                    account.accountMap.put(account_number, 0);
                    break;
                }
                case 2: {
                    withdrawal();
                    break;
                }
                case 3: {
                    deposit();
                    break;
                }
                case 4: {
                    checkBalance();
                    break;
                }
                case 5: {
                    return;
                }
                default:
                    System.out.println("Invalid choice");
            }

        }

    }

    public static void withdrawal() {
        System.out.println("Enter your Account Number");
        int AccountNo = input.nextInt();
        if (!account.accountMap.containsKey(AccountNo)) {
            System.out.println("Invalid Account Number");
        } else {
            System.out.println("Amount to Withdrawal");
            int withdrawalMoney = input.nextInt();
            if (account.accountMap.get(AccountNo) >= withdrawalMoney) {
                account.accountMap.put(AccountNo, account.accountMap.get(AccountNo) - withdrawalMoney);
                System.out.println("SuccessFully Money Withdrawn from your Account");
            } else {
                System.out.println("Balance Unavailable");
            }
        }
    }

    public static void deposit() {
        System.out.println("Enter your Account Number");
        int AccountNo = input.nextInt();
        if (!account.accountMap.containsKey(AccountNo)) {
            System.out.println("Invalid Account Number");
        } else {
            System.out.println("Amount to Deposit");
            int depositMoney = input.nextInt();
            account.accountMap.put(AccountNo, account.accountMap.get(AccountNo) + depositMoney);
            System.out.println("SuccessFully Money Deposited into your Account");
        }
    }

    public static void checkBalance() {
        System.out.println("Enter your Account Number");
        int AccountNo = input.nextInt();
        if (!account.accountMap.containsKey(AccountNo)) {
            System.out.println("Invalid Account Number");
        } else {
            System.out.println("Your account number" + AccountNo);
            System.out.println("Your account Balance" + account.accountMap.get(AccountNo));
        }
    }
}

class Bank {
    static HashMap<Integer, Integer> accountMap = new HashMap<>();
}