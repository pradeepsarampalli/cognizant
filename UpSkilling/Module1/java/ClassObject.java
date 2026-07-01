class Car{
    int  make;
    String model;
    int year;

    public Car(int make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String displayDetails() {
        return "Car Details: " + make + " " + model + " (" + year + ")";
    }
}
public class ClassObject{
    public static void main(String[] args) {
        Car car1 = new Car(2020, "Toyota Camry", 2020);
        Car car2 = new Car(2018, "Honda Accord", 2018);

        System.out.println(car1.displayDetails());
        System.out.println(car2.displayDetails());
    }
}