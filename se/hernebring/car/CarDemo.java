package se.hernebring.car;
public class CarDemo {
    public static void main(String[] args) {
        Car car1 = new Car(54321,"Ford",1992,380,120);
        Car car2 = new Car(13245,"Audi",2018,500,170);
        
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(Car.getCurrentYear());
    }
}
