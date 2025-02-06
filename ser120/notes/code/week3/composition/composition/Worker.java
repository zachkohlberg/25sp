public class Worker {
  private BankAccount account;

  public void depositPaycheck(int amount) {
    account.deposit(amount);
    System.out.println("Deposited paycheck.");
  }
}
