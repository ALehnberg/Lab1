

public class Application {

    public static void main(String[] args) {
        // Instance of this class

        CarController cc = new CarController();

        cc.cars=Factory.create3Cars();

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer (Ska ligga i model)
        cc.timer.start();
    }

}
