import java.awt.*;


/**
 * Abstrakt klass Car, extendas till Volvo och Saab
 */
public abstract class Car implements Movable {

    /**
     * Allt en bil är
     */
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double x;
    private double y;
    private double currentDir = 0;

    /**
     * Konstruktor för Car
     *
     * @param nrDoors
     * @param enginePower
     * @param color
     * @param modelName
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.nrDoors = nrDoors;
    }


    /**
     * Metod move som ändrar x- och y-position beroende på currentdir
     */
    @Override
    public void move() {
        x += currentSpeed * StrictMath.cos(currentDir);
        y += currentSpeed * StrictMath.sin(currentDir);
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    /**
     * Metod turnLeft som ändrar current dir med -90*
     */
    @Override
    public void turnLeft() {
        currentDir -= Math.PI / 2;
    }

    /**
     * Metod turnLeft som ändrar current dir med +90*
     */
    @Override
    public void turnRight() {
        currentDir += Math.PI / 2;
    }


    /**
     * Metod som returnerar antal dörrar
     *
     * @return
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Metod som returnerar enginePower
     *
     * @return
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * Metod som returnerar currentspeed
     *
     * @return
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Metod som returnerar color
     *
     * @return
     */
    public Color getColor() {
        return color;
    }

    /**
     * Metod som ändrar färg på bilen
     *
     * @param clr
     */
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * Metod som sätter currentspeed till 0.1
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Metod som sätter currentspeed till 0
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Metod som returnerar currentDir
     *
     * @return
     */
    public double getCurrentDir() {
        return currentDir%(2*Math.PI);
    }

    /**
     * Metod som sätter currentdir
     *
     * @param currentDir
     */
    public void setCurrentDir(double currentDir) {
        this.currentDir = currentDir;
    }

    /**
     * Metod som returnerar speedFactor. Overrideas i volvo och saab
     *
     * @return
     */
    public abstract double speedFactor();

    /**
     * Metod som ökar currentSpeed
     *
     * @param amount
     */
    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    /**
     * Metod som minskar currentSpeed
     *
     * @param amount
     */
    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }


    /**
     * getters för x och y pos
     *
     * @return
     */
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * Metod som som kallar incrementSpeed(amount) om amount ligger i [0 1]
     *
     * @param amount
     */
    // TODO fix this method according to lab pm
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        } else if(amount>1){
            incrementSpeed(1);
        }
    }
//
    /**
     * Metod som som kallar decrementSpeed(amount) om amount ligger i [0 1]
     *
     * @param amount
     */
    // TODO fix this method according to lab pm
    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        } else if (amount > 1) {
            decrementSpeed(1);
        }
    }


    public String getName(){
        return modelName;
    }



}
