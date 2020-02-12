import java.awt.*;
import java.util.Stack;



public class CarTransport extends Car {
    private final int pickRange = 15;
    private Stack<Car> carStack;
    private boolean rampUp;
    private int cap = 10;

    public CarTransport() {
        super(2, 400, Color.blue, "Transformer");
        rampUp = false;
        carStack = new Stack<Car>();
    }

    public void raiseRamp() {
        if (getCurrentSpeed() == 0)
            rampUp = true;
    }

    public void lowerRamp() {
        if (getCurrentSpeed() == 0) {
            rampUp = false;
        }
    }

    /**
     * @param car hjälpmetod för att kolla om en bil går att lasta
     * @return
     */
    public boolean isLoadable(Car car) {
        return (Math.abs(car.getX() - this.getX()) < pickRange
                && (Math.abs(car.getY() - this.getY())) < pickRange && !rampUp && carStack.size() < cap);
    }


    /**
     * @param car lasta på en bil
     */
    public void addCar(Car car) {
        if (isLoadable(car)) {
            carStack.add(car);
        }
    }

    /**
     * lasta av en bil
     */
    public void removeCar() {
        if (rampUp = false) {
            carStack.pop();
        }
    }

    //flytta bilar så att de hamnar nära biltransporten
    public void moveCars(Car car) {
        car.setX(car.getX());
        car.setY(car.getY());
    }

    public void moveRemovedCars() {
        for (Car c : carStack) {
            c.setX(this.getX());
            c.setY(this.getY());
        }
    }

    public void move() {
        if (rampUp = true) {
            super.move();
            moveRemovedCars();
        }
    }

    @Override
    public double speedFactor() {
        return 0;
    }


}
