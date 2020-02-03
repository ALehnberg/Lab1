import org.junit.Test;

import java.awt.*;

public class test {

    Car volvo = new Volvo240();
    Car saab = new Saab95();



  /*  @Test
    public void volvoMove() {
        System.out.println(volvo.getX());
        System.out.println(volvo.getY());
        volvo.gas(0.5);                 //anropar incrementSpeed som sätter getCurrentSpeed() + speedFactor() * amount
        volvo.move();                        // med speedFactor getEnginePower() * 0.01 * trimFactor
        System.out.println(volvo.getX());        // vilket ger 0 + (100 * 0.01 * 1.25) * 0.5 = 0.625
        System.out.println(volvo.getY());        // ----> gas, incrementSpeed och gas ser ut att fungera

    }*/

    /*@Test
    public void saabMove() {
        System.out.println("saab " + saab.getX());
        System.out.println(saab.getY());
        //System.out.println(saab.);
        saab.gas(0.5);                 //anropar incrementSpeed som sätter getCurrentSpeed() + speedFactor() * amount
        saab.move();                        // med speedFactor getEnginePower() * 0.01 * Turbo
        System.out.println(saab.getX());        // vilket ger 0 + (125 * 0.01 * 1.00) * 0.5 = 0.625
        System.out.println(saab.getY());        // ----> gas, incrementSpeed och gas ser ut att fungera

    }*/

    /**
     * Testar svänga vänster
     */
    @Test
    public void testTurnLeft() {
        // Car c1 = new Car(2, 100, Color.red,"Saab95");
        Saab95 v1 = new Saab95();
        v1.startEngine();
        v1.incrementSpeed(10);

        for(int i = 0;i<4; i++){    //sväng 4 ggr

            v1.turnLeft();
            v1.move();

        }

        System.out.println((Math.abs(v1.getX())<0.0001)&& (Math.abs(v1.getY())<0.0001 ));
    }

    /**
     * Testar att svänga ett "varv"
     */
    @Test
    public void testTurnRight() {
        Volvo240 v1 = new Volvo240();
        v1.startEngine();
        v1.gas(0.5);

        for(int i = 0;i<4; i++){    //sväng 4 ggr
            v1.turnLeft();
            v1.move();
        }
        // Efter 4 varv bör vi vara tillbaka till (0,0)
        System.out.println((Math.abs(v1.getX())<0.0001)&& (Math.abs(v1.getY())<0.0001 ));
    }


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

        System.out.println(s1.getCurrentSpeed() > s2.getCurrentSpeed()  );

        s1.setTurboOff();
        s1.stopEngine();
        s2.stopEngine();

        s1.gas(1);
        s2.gas(1);

        System.out.println(s1.getCurrentSpeed() == s2.getCurrentSpeed() );
    }

/*  //fungerar inte om Car är abstract
    @Test
    public void abs() {
        Car p = new Car(1,2, Color.black,"prutt");
    }
    */


}
