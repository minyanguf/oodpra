package myrewrite;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private Level[] levels;
    private int NUM_LEVELS;


    public ParkingLot(int NUM_LEVELS, int num_rows, int spots_per_row) {
        levels = new Level[NUM_LEVELS];
        for (int i = 0; i < NUM_LEVELS; i++) {
            levels[i] = new Level();
        }
    }
    public void parkVehicle(Vehicle v){
        v.print();
//        System.out.println(v.getName()+" is parked");

    }
}
class Level {
    private List<ParkingSpot> parkingSpots;

    public Level() {
        parkingSpots = new ArrayList<ParkingSpot>();

    }
}
class ParkingSpot{
    private Vehicle v;

}
abstract class Vehicle{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    protected String name;
    protected int size;


    public abstract void print();


}
class Car extends Vehicle{
    public Car(){
        name = "xiaoche";
        size =0;
    }
    public void print(){
        System.out.println(name+size);



    }


}
class Bus extends Vehicle{
    public Bus(){
        name = "bashi";
        size =1;
    }
    public void print(){
        System.out.println(name+size);



    }


}
class Test3{
    public static void main(String[] args){
        var pl = new ParkingLot(5,6,7);
        var v = new Car();
        var bus= new Bus();
        pl.parkVehicle(v);
        pl.parkVehicle(bus);
    }
}
