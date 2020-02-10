import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//en typ-parameter är en variabel som representerar en typ. Vi vet inte vilken typ detta är - det bestäms att det
//argument som ges vid instansieringen, och kan vara olika typer olika gånger vi instansierar.

//typparameter E och upper bound Car, upper bound på typ-parametern ger oss möjlighet att kontrollera vilka sorts typer
// vi kan ge som argument

//Wildcard ? = typ-argument som representerar en okänd typ. Vi kommer aldrig veta mer om denna typ än de bounds
//upper/lower som är givna.
public class Garage <E extends Car> {

    private int nCars;
    private Stack<E> storage;
    private int Capacity;
    private List<Class<? extends Car>> allowedTypes;

    public Garage (int nCars, int Capacity,List<Class<? extends Car>> allowedTypes) {
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

    public E pop() {
        return storage.pop();
    }