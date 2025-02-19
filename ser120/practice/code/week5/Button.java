import java.awt.Color;
import java.awt.event.MouseEvent;

public class Button extends wheels.users.Ellipse {
  private Mover target;
  private int distance;

  public Button(Mover target, int distance, Color color) {
    super(color);

    this.setFrameColor(Color.BLACK);
    this.target = target;
    this.distance = distance;
  }

  @Override
  public void mousePressed(MouseEvent e) {
    target.move(distance);
  }
}
