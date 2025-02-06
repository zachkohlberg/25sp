public class Worker extends PersonWithBankAccount {
  public void depositPaycheck(int amount) {
    deposit(amount);
    System.out.println("Deposited paycheck.");
  }
}
