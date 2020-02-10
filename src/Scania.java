import java.awt.*;
import java.util.Stack;


public class Scania extends Car implements Movable {

    private double angle;
    //Stack<Car> nCars;

    public Scania() {
        super(2, 200, Color.green, "Lastbil");
    }

    public void raiseTruckBed() {
        if ((angle < 70)&& (getCurrentSpeed()==0)) {
            angle += 1;
        }
    }

    public void lowerTruckBed() {
        if ((angle > 0) && (getCurrentSpeed()==0)) {
            angle -= 1;
        }

    }

    public double getAngle() {
        return this.angle = angle;
    }

    public void move() {
        if(angle == 0) {
            super.move();
        }
    }

    @Override
    public double speedFactor() {
        return 0;
    }
}
