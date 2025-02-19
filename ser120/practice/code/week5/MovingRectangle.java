import java.awt.Color;

public class MovingRectangle extends wheels.users.Rectangle implements Mover {
  public MovingRectangle(Color color, int x, int y, int width, int height) {
    super(color);

    this.setLocation(x, y);
    this.setSize(width, height);
  }

  @Override
  public void move(int distance) {
    this.setLocation(this.getXLocation() + distance, this.getYLocation() + distance);
  }
}
