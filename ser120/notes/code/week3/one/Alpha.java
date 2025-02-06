package one;

public class Alpha {
  public int a = 1;
  protected int b = 2;
  int c = 3;
  private int d = 4;

  public static void main(String[] args) {
    Alpha example = new Alpha();
    // can access everything from inside of MyClass
    System.out.println(example.a);
    System.out.println(example.b);
    System.out.println(example.c);
    System.out.println(example.d);
  }
}
