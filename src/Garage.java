import java.util.ArrayList;
import java.util.List;

public class Garage <E extends Car> {

    private int nCars;
    private List<E> storage;


    public Garage(int nCars, List<E> storage) {
        this.nCars = 40;
        this.storage = new ArrayList<>();
    }


    public Garage(int size) {
        this.nCars = size;
    }


}

