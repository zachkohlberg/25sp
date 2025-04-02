import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private Color color;
    private ColorHolder holder;

    public ButtonListener(Color color, ColorHolder holder) {
        this.color = color;
        this.holder = holder;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        holder.setValue(color);
    }
}
