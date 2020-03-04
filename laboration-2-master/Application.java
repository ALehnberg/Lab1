import java.util.ArrayList;
import java.util.List;

public class Application {

    //private static Observer observer;

    public static void main(String[] args) {
        // Instance of this class

        //Create model with a reference to the factory
        ArrayList<Car> facCar = Factory.create3Cars();


        CarModel cm = new CarModel(facCar);

        // Start a new view with a reference of model
        CarView cv = new CarView("CarSim 1.0", cm);


        // Start the timer (Ska ligga i model)???
        cm.timer.start();
    }

}
