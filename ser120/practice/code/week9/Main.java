import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    private JFrame frame;
    private DrawingPanel leftPanel, rightPanel;
    private JPanel centerPanel, buttonPanel, contentPanel;
    private Circle circle;
    private Square square;

    public Main() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        leftPanel = new DrawingPanel();
        leftPanel.setBackground(Color.GRAY);
        circle = new Circle(leftPanel);
        leftPanel.addMouseListener(circle);
        leftPanel.addDrawable(circle);

        rightPanel = new DrawingPanel();
        rightPanel.setBackground(Color.LIGHT_GRAY);
        square = new Square(rightPanel);
        rightPanel.addMouseListener(square);
        rightPanel.addDrawable(square);

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 2));
        centerPanel.add(leftPanel);
        centerPanel.add(rightPanel);

        buttonPanel = new JPanel();
        buttonPanel.add(new JButton("These"));
        buttonPanel.add(new JButton("Buttons"));
        buttonPanel.add(new JButton("Do"));
        buttonPanel.add(new JButton("Nothing"));

        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(centerPanel, BorderLayout.CENTER);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(contentPanel);

        frame.setVisible(true);
        frame.pack();
    }

    public static void main(String[] args) {
        new Main();
    }
}
