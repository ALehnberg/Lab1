import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class carPoint {

    private BufferedImage image;
    private Point point;                //Har point och bild

    public carPoint (Car car)  {
        point = new Point();
        point.x = (int) Math.round(car.getX());
        point.y = (int) Math.round(car.getY());

        try {
           // System.out.println("pics/" + car.getName() + ".jpg");
            //image =  ImageIO.read(new File("pics/" + car.getName() + ".jpg"));
            image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + car.getName() + ".jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }





    }

    // Print an error message in case file is not found with a try/catch block

    // You can remove the "pics" part if running outside of IntelliJ and
    // everything is in the same main folder.
    // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

    void extractCarImage(Car car) {
        try {

            image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + car.getName() + ".jpg"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getXPoint() {
        return point.x;
    }

    public int getYPoint() {
        return point.y;
    }

    public void setXPoint(int x) {
        point.x = x;
    }

    public void setYPoint(int y) {
        point.y = y;
    }
}