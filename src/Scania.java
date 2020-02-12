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
        } // Throw error / print
    }

    public void lowerTruckBed() {
        if ((angle > 0) && (getCurrentSpeed()==0)) {
            angle -= 1;

    }

    public double getAngle() {
        return this.angle;
    }

    public void move() {
        if(angle == 0) {
            super.move();
        } // Else kan man throwa "RAMP UPP"-error
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 ;
    }   // inet speciellt som påverkar speedfactor.
}
