import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller extends JFrame{

    private  CarModel model;
    private CarView view;

    public Controller(CarModel model, CarView view) {
        this.model = model;
        this.view = view;
        this.controll();
    }

    public void controll() {


        view.removeCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeLastCar();
                view.drawPanel.removePoint();
            }
        });

        view.addCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRandomCar();
                view.drawPanel.addPoint(model.cars.get(model.cars.size()-1));
            }
        });

        view.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gas(view.gasAmount);
            }
        });

        view.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.brake(view.gasAmount);
            }
        });


        view.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.stopCars();
            }
        });

        view.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               model.turboOn();
            }
        });

        view.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.turboOff();
            }
        });

        /*view.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : model.cars) {
                    car.stopEngine();
                }
            }
        });*/

        view.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               model.lift();
                //  System.out.println(((HasBed) cm.cars.get(2)).getAngle());
            }
        });


        view.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.lower();
                // System.out.println(((HasBed) model.cars.get(2)).getAngle());
            }
        });

    }

}
