package orlian.shapes;

import javax.swing.*;
import java.awt.*;

public class ShapeComponent extends JComponent {

    private String shape;
    int width = getWidth();
    int height = getHeight();
    int centerX = width / 2;
    int centerY = height / 2;

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        System.out.println("Hi there!");
        width = getWidth();
        height = getHeight();
        centerX = width / 2;
        centerY = height / 2;
        //g.translate(centerX, centerY);
        System.out.println("X:" + centerX + "Y:" + centerY);

        performChoice(g);

    }

    public void iceCreamCone(Graphics g){
        g.setColor(Color.GREEN);
        g.fillOval(centerX-50, centerY, 50, 50); //bottom
        g.setColor(Color.CYAN);
        g.fillOval(centerX-50, centerY-40, 50, 50); //middle
        g.setColor(Color.PINK);
        g.fillOval(centerX-50, centerY-80, 50, 50); //top
        g.setColor(Color.DARK_GRAY);
        g.drawLine(centerX-50, centerY+40, centerX, centerY+40); //top of cone
        int x[] = {centerX-50, centerX-25, centerX};
        int y[] = {centerY+40, centerY+100, centerY+40};
        g.fillPolygon(x, y, 3);
        }

    public void robot(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(centerX-30, centerY-30, 60, 80); // body;
        g.fillRect(centerX-7, centerY-45, 15, 15); //neck
        g.fillRect(centerX-25, centerY-95, 50, 50); //head
        g.fillRect(centerX+4, centerY+50, 20, 25); //right foot
        g.fillRect(centerX-24, centerY+50, 20, 25); //left foot
        g.fillRect(centerX+30, centerY-10, 20, 15); //right hand
        g.fillRect(centerX-50, centerY-10, 20, 15); //left hand
        g.setColor(Color.GRAY);
        g.fillRect(centerX+8, centerY-80, 8, 8); //right eye
        g.fillRect(centerX-18, centerY-80, 8, 8); //left eye
        g.fillRect(centerX-20, centerY-65, 40, 10); //mouth

         }

    public void windmill(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(centerX-25, centerY-5, 8, 300);
        g.setColor(Color.GRAY);
        int x[] = {centerX-50, centerX-25, centerX};
        int y[] = {centerY-80, centerY-20, centerY-80};
        g.fillPolygon(x, y, 3); //top
        int x3[] = {centerX-80, centerX-20, centerX-80};
        int y3[] = {centerY-45, centerY-20, centerY+5};
        g.fillPolygon(x3, y3, 3); //left
        int x4[] = {centerX, centerX-25, centerX-50};
        int y4[] = {centerY+35, centerY-25, centerY+35};
        g.fillPolygon(x4, y4, 3); //bottom
        int x5[] = {centerX+30, centerX-30, centerX+30};
        int y5[] = {centerY+15, centerY-20, centerY-45};
        g.fillPolygon(x5, y5, 3); //right
    }

    public void umbrella(Graphics g){
        g.setColor(Color.MAGENTA);
        g.fillArc(centerX-60, centerY-60, 150, 100, 0, 180);
        g.drawLine(centerX+10, centerY-40, centerX+10, centerY+70);
        g.drawArc(centerX-29, centerY+42, 40, 40, 180, 180);
    }

    public void setShapeIceCreamCone(){
        shape = "Ice Cream Cone";
        repaint();
    }

    public void setShapeRobot(){
        shape = "Robot";
        repaint();
        }

    public void setShapeWindmill(){
        shape = "Windmill";
        repaint();
    }

    public void setShapeStar(){
        shape = "Umbrella";
        repaint();
    }

    public void performChoice(Graphics g){
        if (shape == null){
            return;
        }
        else if (shape.equals("Ice Cream Cone")){
            iceCreamCone(g);
        }else if (shape.equals("Robot")){
            robot(g);
        }else if (shape.equals("Windmill")){
            windmill(g);
        }else if (shape.equals("Umbrella")){
            umbrella(g);
        }

    }
}
