public class Student {
  private BankAccount account;

  public void buyTextbook(int cost) {
    int cash = account.withdraw(cost);
    if (cash == cost) {
      System.out.println("Bought the books.");
    } else {
      System.out.println("Couldn't buy the books.");
    }
  }
}
