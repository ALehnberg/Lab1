import java.awt.*;

/**
 *
 */
public class Saab95 extends Car {

    public boolean turboOn;


    /**
     *
     */
    public Saab95() {
        super(2, 125, Color.red, "Saab95");
        stopEngine();
        turboOn = false;
    }


    /**
     * Turbo på
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     *tURBO AV
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * @return speed för Saab, override
     */
    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) {
            turbo = 1.3;
        }
        return getEnginePower() * 0.01 * turbo;
    }

}
