import java.util.Scanner;

public class CircleProgram {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("Enter the coordinates and radius of Circle A.");
    double aX = input.nextDouble();
    double aY = input.nextDouble();
    double aRadius = input.nextDouble();

    System.out.println("Enter the coordinates and radius of Circle B.");
    double bX = input.nextDouble();
    double bY = input.nextDouble();
    double bRadius = input.nextDouble();

    System.out.println("Circle A: " + circleToString(aX, aY, aRadius));
    System.out.println("Circle B: " + circleToString(bX, bY, bRadius));

    if (intersects(aX, aY, aRadius, bX, bY, bRadius)) {
      System.out.println("The circles intersect.");
    } else {
      System.out.println("The circles do not intersect.");
    }

    input.close();
  }

  public static boolean intersects(
      double x1, double y1, double r1, double x2, double y2, double r2) {
    double dx = x1 - x2;
    double dy = y1 - y2;
    double distance = Math.sqrt(dx * dx + dy * dy);
    return distance < r1 + r2;
  }

  public static String circleToString(double x, double y, double radius) {
    double area = Math.PI * radius * radius;
    double circumference = 2 * Math.PI * radius;
    return String.format(
        "Center (%.2f, %.2f), Radius %.2f, Area %.2f, Circumference %.2f",
        x, y, radius, area, circumference);
  }
}
