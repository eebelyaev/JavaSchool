package lesson02.task01;

import java.util.*;

public class SplitCarList {
    public static void main(String[] args) {
        List<Car> lstCar = Car.getDefaultList();
        System.out.println(lstCar);

        Map<String, ArrayList<Car>> hashMap = new HashMap<>();
        for (Car car : lstCar) {
            if (!hashMap.containsKey(car.getType())) hashMap.put(car.getType(), new ArrayList<Car>());
            hashMap.get(car.getType()).add(car);
        }

        for (Map.Entry entry : hashMap.entrySet())
            System.out.println("Список машин типа " + entry.getKey() + ": " + entry.getValue());
    }
}
