package two;

public class AlphaSub extends one.Alpha {
  public static void main(String[] args) {
    one.Alpha example = new one.Alpha();
    // can access public and protected from a subclass class in another package
    System.out.println(example.a);
    System.out.println(example.b);
    // cannot access no modifier and private from a subclass class in another package
    // System.out.println(example.c);
    // System.out.println(example.d);
  }
}
