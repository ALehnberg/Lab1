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
                System.out.println(model.cars.size());
                System.out.println(view.drawPanel.plist.size());
            }
        });

        view.addCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRandomCar();
                view.drawPanel.addPoint();
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

        /*view.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((HasTurbo) model.cars.get(1)).setTurboOn();
            }
        });

        view.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((HasTurbo) model.cars.get(1)).setTurboOff();
            }
        });*/

        view.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : model.cars) {
                    car.stopEngine();
                }
            }
        });


       /* view.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((Scania) model.cars.get(2)).raiseTruckBed();
                System.out.println(((HasBed) model.cars.get(2)).getAngle());
            }
        });


        view.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((HasBed) model.cars.get(2)).lowerTruckBed();
                System.out.println(((HasBed) model.cars.get(2)).getAngle());
            }
        });*/
        view.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : model.cars) {
                    if(car instanceof HasTurbo) {
                        ((HasTurbo) car).setTurboOn();
                        System.out.println("turbo on");
                    }
                }
            }
        });

        view.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : model.cars) {
                    if(car instanceof HasTurbo) {
                        ((HasTurbo) car).setTurboOff();
                    }
                }
            }
        });


        view.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : model.cars) {
                    car.stopEngine();
                }
            }
        });


        view.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : model.cars) {
                    if(car instanceof HasBed) {
                        ((HasBed) car).raiseTruckBed();
                    }
                }
              //  System.out.println(((HasBed) cm.cars.get(2)).getAngle());
            }
        });


        view.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : model.cars) {
                    if(car instanceof HasBed) {
                        ((HasBed) car).lowerTruckBed();
                    }
                }
               // System.out.println(((HasBed) model.cars.get(2)).getAngle());
            }
        });





    }

}
