import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Holder Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        ColorHolder holder = new ColorHolder(Color.RED);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(2, 2));

        center.add(makeColorPanel(holder));
        center.add(makeColorPanel(holder));
        center.add(makeColorPanel(holder));
        center.add(makeColorPanel(holder));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));

        Font font = new Font("Arial", Font.PLAIN, 24);

        buttonPanel.add(makeColorButton("Red", font, Color.RED, holder));
        buttonPanel.add(makeColorButton("Green", font, Color.GREEN, holder));
        buttonPanel.add(makeColorButton("Blue", font, Color.BLUE, holder));
        buttonPanel.add(makeColorButton("Yellow", font, Color.YELLOW, holder));

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(center, BorderLayout.CENTER);

        frame.setSize(800, 800);
    }

    static JButton makeColorButton(String text, Font font, Color color, ColorHolder holder) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.addActionListener(new ButtonListener(color, holder));
        return button;
    }

    static JPanel makeColorPanel(ColorHolder holder) {
        JPanel panel = new JPanel();
        panel.addMouseListener(new PanelListener(panel, holder));
        return panel;
    }
}
