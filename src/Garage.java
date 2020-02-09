import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Garage <E extends Car> {

    private int nCars;
    private Stack<E> storage;
    private int Capacity;
    private List<Class<? extends Car>> allowedTypes;

    public Garage(int nCars, Stack<E> storage, int Capacity,List<Class<? extends Car>> allowedTypes) {
        this.nCars = nCars;
        this.storage = storage;
        this.Capacity=Capacity;
        this.allowedTypes=allowedTypes;
    }


    public int getCars() {
        return storage.size();
    }

    public int getCapacity(){
        return Capacity;
    }


    public void push(E car){
        if (storage.size() < Capacity && allowedTypes.contains(car.getClass())){
            storage.push(car);
        } else {
            System.out.println("Wrong type of Car");
        }
    }



}

