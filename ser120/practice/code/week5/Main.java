import java.awt.Color;

public class Main extends wheels.users.Frame {
  public Main() {
    MovingRectangle rectangle = new MovingRectangle(Color.CYAN, 200, 100, 30, 30);

    Button forward = new Button(rectangle, 5, Color.GREEN);
    forward.setLocation(150, 50);
    Button backward = new Button(rectangle, -5, Color.RED);
    backward.setLocation(50, 50);
  }

  public static void main(String[] args) {
    new Main();
  }
}
