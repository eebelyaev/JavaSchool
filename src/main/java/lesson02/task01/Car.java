package lesson02.task01;

import java.util.Arrays;
import java.util.List;

public class Car {
    private String model;
    private String type;

    public Car(String model, String type) {
        this.model = model;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public static List<Car> getDefaultList() {
        return Arrays.asList(
                new Car("Lada", "sedan")
                , new Car("Lada", "hatch")
                , new Car("Mercedes", "sedan")
                , new Car("BMW", "cross")
                , new Car("Ford", "hatch")
                , new Car("Pegeout", "cross")
                , new Car("Toyota", "sedan")
        );
    }
}
