import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class test {


    //Car volvo = new Volvo240();
    //Car saab = new Saab95();
    //Car scania = new Scania();


//GAY

    @Test
    public void testRamp() {
        CarTransport C = new CarTransport();
        System.out.println(!C.getRampUpp());
        C.setRampUpp();
        System.out.println(C.getRampUpp());
    }


    @Test
    public void testAddCar() {
        CarTransport C = new CarTransport();        // Kollar att vi kan lägga till bilar om ramp nere
        Volvo240 v = new Volvo240();

        C.addCar(v);
        Stack e = C.getCarStack();
        System.out.println(e.contains(v));

        C.removeCar();

        C.setRampUpp();

        C.addCar(v);

        System.out.println(!e.contains(v));
    }

    @Test
    public void testMove() {
        CarTransport C = new CarTransport();
        Volvo240 v = new Volvo240();


        double x1 = C.getX();
        double x2 = v.getX();

        C.addCar(v);
        C.setRampUpp();
        C.gas(1);
        C.move();

        System.out.println(x1 != C.getX());   // har carTrans flyttat?
        System.out.println(x2 != v.getX());   // har volvo flyttat?
        System.out.println(C.getX() == v.getX());   // har de samma cords efter flytt?
    }


    @Test
    public void verkstadTest() {
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        Volvo240 volvo2 = new Volvo240();
    }


    @Test
    public void garageTest() {
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        Volvo240 volvo2 = new Volvo240();

        List<Class<? extends Car>> allowed = new ArrayList<>();
        //allowed.add(car);

        allowed.add(Volvo240.class);
        //allowed.add(Saab95.class);

        // Vi kan ändra typ-parametern till Car för att få ett mer dynamiskt garage!
        Verkstad<Volvo240> G = new Verkstad<Volvo240>(5, allowed);
        System.out.println(G.getCapacity());
        System.out.println(volvo.getClass());
        System.out.println(G.getCars());
        G.push(volvo);
        G.push(volvo2);
        System.out.println("Antal bilar i stacken  " + G.getCars());                      // Kan ta in accepterade typer
        //G.push(saab);
        System.out.println("Antal bilar i stacken  " + G.getCars());                      // Tar inte in fel typer


        Volvo240 v = G.pop();
        System.out.println(v);
        System.out.println(v == volvo);


    }


    @Test
    public void scaniaTest() {
        Scania scania = new Scania();
        System.out.println(scania.getAngle());
        System.out.println("x= " + scania.getX() + "  y= " + scania.getY());
        scania.gas(1);
        scania.move();
        System.out.println("x= " + scania.getX() + "  y= " + scania.getY());
        scania.raiseTruckBed();
        scania.raiseTruckBed();
        scania.raiseTruckBed();
        scania.raiseTruckBed();
        System.out.println(scania.getAngle());

        scania.move();
        System.out.println("x= " + scania.getX() + "  y= " + scania.getY());
        scania.gas(1);
        scania.gas(1);
        scania.gas(1);
        scania.move();
        System.out.println("x= " + scania.getX() + "  y= " + scania.getY());

        scania.lowerTruckBed();
        scania.lowerTruckBed();
        scania.lowerTruckBed();
        scania.lowerTruckBed();
        scania.move();
        System.out.println("x= " + scania.getX() + "  y= " + scania.getY());
    }


    /**
     * Testar svänga vänster
     */
    @Test
    public void testTurnLeft() {
        // Car c1 = new Car(2, 100, Color.red,"Saab95");
        Saab95 v1 = new Saab95();
        v1.startEngine();
        v1.incrementSpeed(10);

        for (int i = 0; i < 4; i++) {    //sväng 4 ggr

            v1.turnLeft();
            v1.move();

        }

        System.out.println((Math.abs(v1.getX()) < 0.0001) && (Math.abs(v1.getY()) < 0.0001));
    }

    /**
     * Testar att svänga ett "varv"
     */
    @Test
    public void testTurnRight() {
        Volvo240 v1 = new Volvo240();
        v1.startEngine();
        v1.gas(0.5);

        for (int i = 0; i < 4; i++) {    //sväng 4 ggr
            v1.turnLeft();
            v1.move();
        }
        // Efter 4 varv bör vi vara tillbaka till (0,0)
        System.out.println((Math.abs(v1.getX()) < 0.0001) && (Math.abs(v1.getY()) < 0.0001));
    }

/*
    @Test
    public void testGasNBrake() {
        Saab95 s1 = new Saab95();
        Saab95 s2 = new Saab95();
        saab.gas(1.1);              //Blir samma som amount = 1
        saab.move();
        System.out.println(saab.getX());
        saab.brake(0.9);
        saab.move();
        System.out.println(saab.getX());
        saab.brake(-1);             //samma som amount = 0
        saab.move();
        System.out.println(saab.getX());
        s1.gas(10);
        s2.gas(1);
        System.out.println(s1.getCurrentSpeed()==s2.getCurrentSpeed());
    }

 */


    @Test
    public void testSaabMaxMinSpeed() {
        //Car c1 = new Car(2, 125, Color.red,"Saab95");
        Saab95 s1 = new Saab95();
        s1.startEngine();
        s1.incrementSpeed(1000);
        System.out.println(s1.getCurrentSpeed() == s1.getEnginePower());

        s1.decrementSpeed(1000);
        System.out.println(s1.getCurrentSpeed() == 0);
    }

    /**
     * Testar om max och min hastigheter respekteras
     */
    @Test
    public void testVolvoMaxMinSpeed() {
        Volvo240 s1 = new Volvo240();
        s1.startEngine();
        s1.incrementSpeed(1000);
        System.out.println(s1.getCurrentSpeed() == s1.getEnginePower());

        s1.decrementSpeed(1000);
        System.out.println(s1.getCurrentSpeed() == 0);
    }


  /*  @Test
    public void gettersNSetters() {


        System.out.println(saab.getEnginePower());
        System.out.println(saab.getCurrentSpeed());
        System.out.println(saab.getColor().toString());
        System.out.println();
        System.out.println();

    }*/


    @Test
    public void testTurbo() {
        Saab95 s1 = new Saab95();
        Saab95 s2 = new Saab95();

        s1.setTurboOn();

        s1.gas(1);
        s2.gas(1);

        System.out.println(s1.getCurrentSpeed() > s2.getCurrentSpeed());

        s1.setTurboOff();
        s1.stopEngine();
        s2.stopEngine();

        s1.gas(1);
        s2.gas(1);

        System.out.println(s1.getCurrentSpeed() == s2.getCurrentSpeed());
    }

/*  //fungerar inte om Car är abstract
    @Test
    public void abs() {
        Car p = new Car(1,2, Color.black,"prutt");
    }
    */

}
