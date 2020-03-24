package orlian.shapes;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ShapesFrame extends JFrame {

    private ShapeComponent shapeComponent;
    JFrame borderLayoutFrame = new JFrame();
    Box panel1 = Box.createVerticalBox();
    ButtonGroup buttons = new ButtonGroup();
    JButton button;
    JPanel panel2 = new JPanel();
    Container content = borderLayoutFrame.getContentPane();

    Border blackline = BorderFactory.createLineBorder(Color.black);


    public ShapesFrame(){

        setSize(400, 270);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("SHAPES");

        Dimension size = new Dimension(100, 30);
        panel1.add(createFiller(20, 20));
        buttons.add(button = createButton("Ice Cream", size));
        button.addActionListener(actionEvent -> shapeComponent.setShapeIceCreamCone());
        panel1.add(button);
        panel1.add(createFiller(20, 20));
        buttons.add(button = createButton("Robot", size));
        button.addActionListener(actionEvent -> shapeComponent.setShapeRobot());
        button.setPreferredSize(new Dimension(100, 40));
        panel1.add(button);
        panel1.add(createFiller(20, 20));
        buttons.add(button = createButton("Windmill", size));
        button.addActionListener(actionEvent -> shapeComponent.setShapeWindmill());
        panel1.add(button);
        panel1.add(createFiller(20, 20));
        buttons.add(button = createButton("Umbrella", size));
        button.addActionListener(actionEvent -> shapeComponent.setShapeStar());
        panel1.add(button);
        panel1.add(createFiller(20, 20));


        panel2.setLayout(new BorderLayout());
        panel2.add(shapeComponent = new ShapeComponent());

        content.setLayout(new BorderLayout());

        panel1.setBorder(blackline);
        panel2.setBorder(blackline);

        content.add(panel1, BorderLayout.WEST);
        content.add(panel2, BorderLayout.CENTER);
        borderLayoutFrame.pack();



        add(content);
    }

    private JButton createButton(String text, Dimension size) {
        JButton button = new JButton(text);
        button.setPreferredSize(size);
        button.setMinimumSize(size);
        button.setMaximumSize(size);
        return button;
    }

    private Box.Filler createFiller(int width, int height) {
        Dimension minSize = new Dimension(width, height);
        Dimension prefSize = new Dimension(width, height);
        Dimension maxSize = new Dimension(Short.MAX_VALUE, height);
        return (new Box.Filler(minSize, prefSize, maxSize));
        }

    public static void main(String[] args){
        new ShapesFrame().setVisible(true);
    }

}
