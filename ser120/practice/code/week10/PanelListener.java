import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class PanelListener extends MouseAdapter {
    private JPanel panel;
    private ColorHolder holder;

    public PanelListener(JPanel panel, ColorHolder holder) {
        this.panel = panel;
        this.holder = holder;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        panel.setBackground(holder.getValue());
    }
}
