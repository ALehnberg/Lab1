import java.awt.*;
import java.util.Stack;


public class CarTransport extends Car {
    private final int pickRange = 15;
    Stack<Car> nCars;
    private boolean rampUp;

    public CarTransport() {
        super(2, 400, Color.blue, "Transformer");
        rampUp = false;


    }

    public void raiseRamp() {
        rampUp = true;
    }

    public void lowerRamp() {
        if (getCurrentSpeed() == 0) {
            rampUp = false;
        }
    }

    public void boolean (Car car) {
        return (Math.abs(car.getX()-this.getX() < pickRange)
                && car.getY()-this.getY() < pickRange && !rampUp)
    }











}
