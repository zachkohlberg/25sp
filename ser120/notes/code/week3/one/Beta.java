package one;

public class Beta {
  public static void main(String[] args) {
    Alpha example = new Alpha();
    // can access public, protected, and no modifier from another class in the same package
    System.out.println(example.a);
    System.out.println(example.b);
    System.out.println(example.c);
    // cannot access private from another class in the same package
    // System.out.println(example.d);
  }
}
