public class Student extends PersonWithBankAccount {
  public void buyTextbook(int cost) {
    int cash = withdraw(cost);
    if (cash == cost) {
      System.out.println("Bought the books.");
    } else {
      System.out.println("Couldn't buy the books.");
    }
  }
}
