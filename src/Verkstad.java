import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Verkstad <E extends Car> {


    private Stack<E> storage;
    private int Capacity;
    private List<Class<? extends Car>> allowedTypes;



    public Verkstad( int Capacity, List<Class<? extends Car>> allowedTypes) {
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


    public void push(E car){    //Kollar så det finns plats och tillåten typ
        if (storage.size() < Capacity && allowedTypes.contains(car.getClass())){
            storage.push(car);
        } else {    //kan oxå göra ett throw error...
            System.out.println("Wrong type of Car");
        }
    }


    public E pop() {

            return storage.pop();
           //lämpar ut bil.
    }
}

