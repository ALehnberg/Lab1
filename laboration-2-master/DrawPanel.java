import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements AnimateListener{

    CarModel carM;

    List<carPoint> plist = new ArrayList<>();

    public void createPoints() {
        for (Car c : carM.cars)
            plist.add(new carPoint(c));
    }

    public void addPoint(Car c) {
        if (plist.size() < 10) {
            plist.add(new carPoint(c));
        }
    }

    public void removePoint() { //tar bort sista
        if (plist.size() > 0) {
            plist.remove(plist.size()-1);
        }
    }


    // TODO: Make this genereal for all cars
    void moveit() {//, Point carPoint){
//Loopa över bilarna, måla ut där du har dem i model från view.
        for (int i = 0; i< carM.cars.size();i++) {
            plist.get(i).setXPoint( (int) Math.round(carM.cars.get(i).getX())   );
            plist.get(i).setYPoint( (int) Math.round(carM.cars.get(i).getY())   );

        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarModel cm) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.carM = cm;
        createPoints();


    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        repaint();
        for (carPoint c : plist){
            g.drawImage(c.getImage(),c.getXPoint(),c.getYPoint(),null);
        }
    }


    @Override
    public void actOnUpdate() {
        moveit();
        repaint();
    }
}
