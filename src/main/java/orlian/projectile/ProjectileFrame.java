package orlian.projectile;

import orlian.scrabble.Scrabble;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ProjectileFrame extends JFrame {

    private JTextArea projectileCoordinates;
    private JTextField velocity;
    private JTextField angle;
    private JButton calculateButton;
    private JLabel velocityLabel;
    private JLabel angleLabel;
    private JTextArea answerLabel;


    private JPanel leftPanel;
    private JPanel rightPanel;

    public ProjectileFrame() {
        setSize(300, 400);
        setTitle("Projectile");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        projectileCoordinates = new JTextArea();
        velocity = new JTextField();
        angle = new JTextField();
        calculateButton = new JButton("Calculate");
        velocityLabel = new JLabel("Velocity");
        angleLabel = new JLabel("Angle (degrees)");
        answerLabel = new JTextArea();

        leftPanel = new JPanel();
        rightPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(4, 2));
        leftPanel.add(velocityLabel);
        leftPanel.add(velocity);
        leftPanel.add(angleLabel);
        leftPanel.add(angle);
        leftPanel.add(calculateButton);
        rightPanel.add(answerLabel);

        add(projectileCoordinates, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);

        calculateButton.addActionListener(actionEvent -> calculateProjectile());
    }

    public void calculateProjectile() {
        ArrayList<Projectile> ProjectileList = new ArrayList<Projectile>();
        double angleD = Double.parseDouble(angle.getText());
        double velocityD = Double.parseDouble(velocity.getText());
        Projectile projectile = new Projectile(angleD, velocityD);
        for (int i = 0; i < 30; i++) {
            int num1 = 1;
            ProjectileList.add(projectile);
            ProjectileList.get(i).increaseTime(num1);
            answerLabel.append(ProjectileList.get(i).toString() + "\n");
        }
    }





    public static void main(String[] args) {
        new ProjectileFrame().setVisible(true);
    }
}
