import sun.misc.Signal;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    CarModel model;
    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    // To keep track of a singel cars position

    //List<Point> points = createPoints(model.cars);   // Kommer få nullpointer

    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();    //bilar ist?*/


    // TODO: Make this genereal for all cars
    void moveit(){
        int i=0;
        for (Car cars : model.cars){
            if(i==0) {
                volvoPoint.x = (int) Math.round(cars.getX());
                volvoPoint.y = (int) Math.round(cars.getY());
                i++;
            } else if (i==1) {
                saabPoint.x = (int) Math.round(cars.getX());
                saabPoint.y = (int) Math.round(cars.getY());
                i++;
            } else {
                scaniaPoint.x = (int) Math.round(cars.getX());
                scaniaPoint.y = (int) Math.round(cars.getY());
            }
        }
        /*
        if(car.getName().equals("Volvo240")){
            volvoPoint.x = (int) Math.round(car.getX());
            volvoPoint.y = (int) Math.round(car.getY());
        } else if(car.getName().equals("Saab95")){
            saabPoint.x = (int) Math.round(cars.getX());
            saabPoint.y = (int) Math.round(cars.getY());
        } else {
            scaniaPoint.x = (int) Math.round(cars.getX());
            scaniaPoint.y = (int) Math.round(cars.getY());
        }
         */
    }


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarModel cm) {
        this.model=cm;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
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
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);
    }

    List<Point> createPoints(ArrayList<Car> cars){
        List<Point> points = new ArrayList<>();
        for (Car car : cars){
            points.add(new Point());
        }
        return points;
    }


}
