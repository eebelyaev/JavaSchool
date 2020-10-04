package lesson02.task01;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class SplitCarListWithStream {
    public static void main(String[] args) {
        List<Car> lstCar = Car.getDefaultList() ;
        System.out.println(lstCar);

        Map<String, List<Car>> map = lstCar.stream().collect(groupingBy(Car::getType, HashMap::new, toList()));
        map.entrySet().forEach(x -> System.out.println("Список машин типа " + x.getKey() + ": " + x.getValue()));
    }
}
