import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
    // Collection of drawables that can dynamically grow as we add to it
    private ArrayList<Drawable> drawables;

    public DrawingPanel() {
        setPreferredSize(new Dimension(400, 600));
        drawables = new ArrayList<>();
    }

    public void addDrawable(Drawable d) {
        drawables.add(d);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Call the draw method of each drawable in our list
        for (Drawable d : drawables) {
            d.draw(g);
        }
    }
}
