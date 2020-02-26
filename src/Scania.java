import java.awt.*;
import java.util.Stack;
////////
//
public class Scania extends Car implements Movable {

    private double angle;
    //Stack<Car> nCars;

    public Scania() {
        super(2, 70, Color.green, "Lastbil");
        angle = 0;

    }

    public void raiseTruckBed() {
        if ((angle > 0)&& (getCurrentSpeed()==0)) {
            angle -= 1;
        } // Throw error / print
    }

    public void lowerTruckBed() {
        if ((angle < 70) && (getCurrentSpeed()==0)) {
            angle += 1;
        } // Throw error
    }

    public double getAngle() {
        return this.angle;
    }



    @Override
    public void move() {
        if(angle == 0) {
            super.move();
        } // Else kan man throwa "RAMP UPP"-error
        else{
            setCurrentSpeed(0);
        }
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 ;
    }   // inet speciellt som påverkar speedfactor.
}
