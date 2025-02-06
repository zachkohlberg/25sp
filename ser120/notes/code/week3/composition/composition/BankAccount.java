public class BankAccount {
  private int balance;

  public void deposit(int amount) {
    balance += amount;
  }

  public int withdraw(int amount) {
    if (balance >= amount) {
      balance -= amount;
      return amount;
    } else {
      return 0;
    }
  }
}
