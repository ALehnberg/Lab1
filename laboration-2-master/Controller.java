import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    CarModel cm;


    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;

public Controller(CarModel cm){
    this.cm = cm;
}

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");
    JButton addVolvo = new JButton("Add Volvo");
    JButton addSaab = new JButton("Add Saab");
    JButton addScania = new JButton("Add Scania");

    public void control() {

        /*SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        5);//step
      gasSpinner = new JSpinner(spinnerModel); */
//////////////////////////////////////7
        addVolvo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.addVolvo();
            }
        });


        addSaab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.addSaab();
            }
        });



        addScania.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.addScania();
            }
        });
 ///////////////////////////////////////////////////////////////
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
                System.out.println(gasAmount);
            }
        });

        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.gas(gasAmount);
            }
        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cm.brake(gasAmount);
            }
        });

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((HasTurbo) cm.cars.get(1)).setTurboOn();
            }
        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((HasTurbo) cm.cars.get(1)).setTurboOff();
            }
        });


        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : cm.cars) {
                    car.stopEngine();
                }
            }
        });


        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((Scania) cm.cars.get(2)).raiseTruckBed();
                System.out.println(((HasBed) cm.cars.get(2)).getAngle());
            }
        });


        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((HasBed) cm.cars.get(2)).lowerTruckBed();
                System.out.println(((HasBed) cm.cars.get(2)).getAngle());
            }
        });

    }
}
