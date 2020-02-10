import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Verkstad <E extends Car> {

    private int nCars;
    private Stack<E> storage;
    private int Capacity;
    private List<Class<? extends Car>> allowedTypes;



    public Verkstad(int nCars, int Capacity,List<Class<? extends Car>> allowedTypes) {
        this.nCars = nCars;
        this.Capacity=Capacity;
        this.allowedTypes=allowedTypes;
        this.storage = new Stack<E>();
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


    public E pop(){
        return storage.pop();
    }

}

