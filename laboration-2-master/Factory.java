import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
            for (Car car : cars) {
                car.setY(0 + i * 600 / cars.size());
                i++;
        }
    }


    static void addCar(ArrayList<Car> cars){
        Random random = new Random();
        int r = random.nextInt(2);
        if (c < 7) {
            if(r==0) {
                cars.add(new Volvo240());
            } else if(r==1){
                cars.add(new Saab95());
            } else  {
                cars.add(new Scania());
            }
            c++;
            System.out.println(cars.size() + " bilar");
        }
    }

    static void removeCar (ArrayList<Car> cars){
        if(c>0) {
            Random random = new Random();
            int r = random.nextInt(cars.size());
            cars.remove(r);
            c--;
        }
    }



}
