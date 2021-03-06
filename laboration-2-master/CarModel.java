import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarModel{
    // member fields:


    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    public Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    //TODO: frame SKA BORT vv

    // A list of cars, modify if needed
    ArrayList<Car> cars; // = new ArrayList<>();

    public CarModel(ArrayList<Car> cars) {
        this.cars = cars;
        fitY();
    }


    public void addRandomCar() {
        Factory.addCar(cars);
        fitY();
    }

    public void removeLastCar() {   //tar bort sista bilen
        Factory.removeCar(cars);
    }


    private void fitY() {
        int len = cars.size();
        for (int i = 0; i<len; i++) {
            cars.get(i).setY(i * 600/len);
        }
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */

    //Får en input från CONTROLLER som här hanteras ocg ger reaktion. (Logik).
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            for (Car car : cars) {
                checkOutOfBounds(car);
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());

                notifyListeners();
            }
        }
    }
    ////////
    private void notifyListeners(){
        for (AnimateListener l : listeners)
            l.actOnUpdate();
    }

    private java.util.List<AnimateListener> listeners = new ArrayList<>();
    public void addListener(AnimateListener l){
        listeners.add(l);
    }



    //LOGIK. Varje tick kollar iv så biln inte kör utanför
    private void checkOutOfBounds(Car car){     //usage dependency
        if (car.getX() > 680 || car.getX() < -1 || car.getY() > 801 || car.getY() < -1){
            car.setCurrentDir(car.getCurrentDir() + Math.PI);
            System.out.println("BIL SVÄNGDE-----------------------------------------------------------------");
        }
    }               // Om utanför banan, byt riktning

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(brake);
        }
    }

    void stopCars() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    void turboOn() {
        for (Car car : cars) {
            if (car instanceof HasTurbo) {
                ((HasTurbo) car).setTurboOn();
                // System.out.println("turbo on");
            }
        }
    }

        void turboOff() {
            for (Car car : cars) {
                if (car instanceof HasTurbo) {
                    ((HasTurbo) car).setTurboOff();
                }
            }
        }
       void lift() {
           for (Car car : cars) {
               if (car instanceof HasBed) {
                   ((HasBed) car).raiseTruckBed();
               }
           }
       }
        void lower() {
               for (Car car : cars) {
                   if(car instanceof HasBed) {
                       ((HasBed) car).lowerTruckBed();
                   }
               }
           }

    }








//