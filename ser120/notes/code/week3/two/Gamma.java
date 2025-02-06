package two;

public class Gamma {
  public static void main(String[] args) {
    one.Alpha example = new one.Alpha();
    // can only access public from an unrelated class in another package
    System.out.println(example.a);
    // cannot access protected, no modifier, or private from an unrelated class in another package
    // System.out.println(example.b);
    // System.out.println(example.c);
    // System.out.println(example.d);
  }
}
