package orlian.shapes;

import javax.swing.*;
import java.awt.*;


public class ShapeComponent extends JComponent {

    public ShapeComponent() {
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                while (true) {
                    repaint();
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }

    private String shape;
    int width = getWidth();
    int height = getHeight();
    int centerX = width / 2;
    int centerY = height / 2;
    private int x = 0;
    private int rotation = 0;

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        width = getWidth();
        height = getHeight();
        centerX = width / 2;
        centerY = height / 2;
        g.translate(centerX+x, centerY+0);
        Graphics2D g2d = (Graphics2D) g;
        g2d.rotate(Math.toRadians(rotation));
        x++;
        rotation++;

        performChoice(g);

    }

    public void trafficLight(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(-70, -100, 100, 200);
        g.setColor(Color.GREEN);
        g.fillOval(-50, 40, 50, 50); //bottom
        g.setColor(Color.YELLOW);
        g.fillOval(-50, -25, 50, 50); //middle
        g.setColor(Color.RED);
        g.fillOval(-50, -90, 50, 50); //top
        g.setColor(Color.GREEN);
        }

    public void robot(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(-30, -30, 60, 80); // body;
        g.fillRect(-7, -45, 15, 15); //neck
        g.fillRect(-25, -95, 50, 50); //head
        g.fillRect(4, 50, 20, 25); //right foot
        g.fillRect(-24, 50, 20, 25); //left foot
        g.fillRect(30, -10, 20, 15); //right hand
        g.fillRect(-50, -10, 20, 15); //left hand
        g.setColor(Color.GRAY);
        g.fillRect(8, -80, 8, 8); //right eye
        g.fillRect(-18, -80, 8, 8); //left eye
        g.fillRect(-20, -65, 40, 10); //mouth

    }




    public void windmill(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(-25, -5, 8, 300);
        g.setColor(Color.GRAY);
        int x[] = {-50, -25, 0};
        int y[] = {-80, -20, -80};
        g.fillPolygon(x, y, 3); //top
        int x3[] = {-80, -20, -80};
        int y3[] = {-45, -20, 5};
        g.fillPolygon(x3, y3, 3); //left
        int x4[] = {0, -25, -50};
        int y4[] = {35, -25, 35};
        g.fillPolygon(x4, y4, 3); //bottom
        int x5[] = {30, -30, 30};
        int y5[] = {15, -20, -45};
        g.fillPolygon(x5, y5, 3); //right
    }


    public void umbrella(Graphics g){
        g.setColor(Color.MAGENTA);
        g.fillArc(-60, -60, 150, 100, 0, 180);
        g.drawLine(10, -40, 10, 70);
        g.drawArc(-29, 42, 40, 40, 180, 180);
    }

    
    public void setShapeTrafficLight(){
        shape = "Traffic Light";
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

    public void setShapeHouse(){
        shape = "Umbrella";
        repaint();
    }

    public void performChoice(Graphics g){
        if (shape == null){
            return;
        }
        else if (shape.equals("Traffic Light")){
            trafficLight(g);
        }else if (shape.equals("Robot")){
            robot(g);
        }else if (shape.equals("Windmill")){
            windmill(g);
        }else if (shape.equals("Umbrella")){
            umbrella(g);
        }

    }
}
