import java.awt.*;
import java.util.Stack;

public class CarTransport extends Car implements Movable {

    private Stack<Car> CarStack;
    private boolean rampUpp;        //uppe eller nere
    private final int pickRange = 10;
    private final int cap = 10;



    public CarTransport() {
        super(4, 150, Color.blue, "TransCar");
        CarStack = new Stack<Car>();
        rampUpp = false;
    }

    public void raiseRamp() {
        if (getCurrentSpeed() == 0)
            rampUp = true;

    public Stack<Car> getCarStack() {
        return CarStack;

    }

    public boolean getRampUpp() {
        return rampUpp;
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

    public void setRampUpp(){
        rampUpp=!rampUpp;
    }

    public void addCar(Car c) {
        if ((c.getClass()!=CarTransport.class && isLoadable(c))) {  //om rampen är nere, vi står still och bilen ej är carTransport
            CarStack.add(c);

        }
    }


    public Car removeCar() {
        if ((!rampUpp)) {  //om rampen är nere
            return CarStack.pop();
        }
        return null; //CarStack empty
    }


    //flytta bilar så att de hamnar nära biltransporten
    public void moveCars(Car car){
                car.setX(car.getX());
                car.setY(car.getY());


                @Override
                public void move () {
                    if (rampUpp) {
                        setX(getX() + getCurrentSpeed() * StrictMath.cos(getCurrentDir()));
                        setY(getY() + getCurrentSpeed() * StrictMath.sin(getCurrentDir()));
                        for (int i = 0; i < CarStack.size(); i++) {
                            CarStack.get(i).setX(this.getX());
                            CarStack.get(i).setY(this.getY());
                        }
                    }

                }

                public void moveRemovedCars () {
                    for (Car c : carStack) {
                        c.setX(this.getX());
                        c.setY(this.getY());
                    }
                }


                public void move () {
                    if (rampUp = true) {
                        super.move();
                        moveRemovedCars();
                    }
                }

                public boolean isLoadable (Car car){
                    return (Math.abs(car.getX() - this.getX()) < pickRange && Math.abs(car.getY() - this.getY()) < pickRange && !rampUpp && CarStack.size() < cap);

                } // Kollar att vi är inom pickup-range, ej fullt


                @Override
                public double speedFactor () {
                    return getEnginePower() * 0.01;
                }
            }
