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

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    // To keep track of a singel cars position
/*
    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();
*/

    CarModel carM;

    List<Point> plist = new ArrayList<>();


    public void createPoints() {
        for (Car c : carM.cars)
            plist.add(new Point());
    }

    public void addPoint() {
        if (plist.size() < 10) {
            plist.add(new Point());
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
            plist.get(i).x = (int) Math.round(carM.cars.get(i).getX());
            plist.get(i).y = (int) Math.round(carM.cars.get(i).getY());

           /* if (carM.cars.get(i).getName().equals("Volvo240")) {
                plist.get(i).x = (int) Math.round(carM.cars.get(i).getX());
                plist.get(i).y = (int) Math.round(carM.cars.get(i).getY());
            } else if (c.getName().equals("Saab95")) {
                saabPoint.x = (int) Math.round(c.getX());
                saabPoint.y = (int) Math.round(c.getY());
            } else {
                scaniaPoint.x = (int) Math.round(c.getX());
                scaniaPoint.y = (int) Math.round(c.getY());
            }*/
        }
    }

//TaEmotsignal []
//    moveit();
//    repaint()



    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarModel cm) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.carM = cm;
        createPoints();
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
       /* g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);*/
        drawImg(g);
    }

    private void drawImg(Graphics g) {
        for (int i = 0; i<plist.size(); i++) {
            if (carM.cars.get(i).getName().equals("Volvo240")) {
                g.drawImage(volvoImage, plist.get(i).x, plist.get(i).y, null);
                //System.out.println("HEJHEJ");
            } else if (carM.cars.get(i).getName().equals("Saab95")) {
                g.drawImage(saabImage, plist.get(i).x, plist.get(i).y, null);
            } else {
                g.drawImage(scaniaImage, plist.get(i).x, plist.get(i).y, null);
            }
        }
    }

    @Override
    public void actOnUpdate() {
        moveit();
        repaint();
    }
}
