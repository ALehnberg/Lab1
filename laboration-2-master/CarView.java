import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import sun.misc.Signal;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/


public class CarView extends JFrame implements Observer{
    private static final int X = 800;
    private static final int Y = 800;

    // The controller member
    CarModel model;
    Controller controller;
    DrawPanel drawPanel;


    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();
    JLabel gasLabel = new JLabel("Amount of gas");



    // Constructor
    public CarView(String framename, CarModel cm){ //CarModel cc
        //this.carC = cc;
        this.model=cm;
        this.drawPanel= new DrawPanel(X, Y-240, model);
        this.controller=new Controller(model);  //lista ist?
        initComponents(framename);
        controller.control();
        cm.addObserver(this);


    }


    @Override
    public void notifyFUCK() {
        drawPanel.moveit();
        drawPanel.repaint();

    }


    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {


        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(drawPanel);

       SpinnerModel spinnerModel =
               new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        5);//step
        controller.gasSpinner = new JSpinner(spinnerModel);


        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(controller.gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(controller.gasButton, 0);
        controlPanel.add(controller.turboOnButton, 1);
        controlPanel.add(controller.liftBedButton, 2);
        controlPanel.add(controller.brakeButton, 3);
        controlPanel.add(controller.turboOffButton, 4);
        controlPanel.add(controller.lowerBedButton, 5);
        controlPanel.add(controller.addVolvo,6);
        controlPanel.add(controller.addSaab,7);
        controlPanel.add(controller.addScania,8);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        controller.startButton.setBackground(Color.blue);
        controller.startButton.setForeground(Color.green);
        controller.startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(controller.startButton);


        controller.stopButton.setBackground(Color.red);
        controller.stopButton.setForeground(Color.black);
        controller.stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(controller.stopButton);



        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}