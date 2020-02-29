import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Factory {


    public static ArrayList<Car> create3Cars() {

        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        saab.setY(100);
        Scania scania = new Scania();
        scania.setY(200);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(volvo);
        cars.add(saab);
        cars.add(scania);

        return cars;
    }





}
