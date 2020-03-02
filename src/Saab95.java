import java.awt.*;

/**
 *
 */
public class Saab95 extends Car implements HasTurbo {

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
    @Override
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     *tURBO AV
     */
    @Override
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
