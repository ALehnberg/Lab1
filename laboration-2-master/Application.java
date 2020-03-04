import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        // Instance of this class
        ArrayList<Car> list = Factory.create3Cars();
        CarModel cc = new CarModel(list);
        CarView cv = new CarView("CarSim 1.0", cc);
        cc.addListener(cv);


        Controller c = new Controller(cc,cv);



        // Start a new view and send a reference of self


        // Start the timer (Ska ligga i model)
        cc.timer.start();
    }

}
