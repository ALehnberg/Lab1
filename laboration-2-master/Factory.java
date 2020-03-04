import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Factory {

    static int c = 0;

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

    static void replaceCars(ArrayList<Car> cars) {
        int i = 0;
        if (c < 10) {
            for (Car car : cars) {
                car.setY(0 + i * 600 / cars.size());
                i++;
            }
        }
    }

    static void addVolvo(ArrayList<Car> cars) {
        if (c < 10) {
            cars.add(new Volvo240());
            c++;
        }
    }

    static void addSaab(ArrayList<Car> cars) {
        if (c < 10) {
            cars.add(new Saab95());
            c++;
        }
    }

    static void addScania(ArrayList<Car> cars) {
        if (c < 10) {
            cars.add(new Scania());
            c++;
        }
    }


}
