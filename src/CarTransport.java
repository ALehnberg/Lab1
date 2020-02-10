import java.awt.*;
import java.util.Stack;

public class CarTransport extends Car implements Movable {

   private Stack<Car> CarStack;
   private boolean rampUpp;        //uppe eller nere
    private final int pickRange = 10;


    public CarTransport() {
        super(4, 150, Color.blue, "TransCar");
        CarStack = new Stack<Car>();
        rampUpp = false;
    }

    public void AddCar(Car c) {
        if((!rampUpp)) {  //om rampen är nere
            CarStack.add(c);
        }

    }
public Car removeCar() {
    if((!rampUpp)) {  //om rampen är nere
       return CarStack.pop();

    }
    return null; //CarStack empty
}







}
