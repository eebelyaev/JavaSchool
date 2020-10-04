package lesson04.task01;

import java.util.HashMap;
import java.util.Map;

public class GenericMain {
    public static void main(String[] args) {
        CountMap<Integer> integerCountMap = new CountMapImpl<>();
        System.out.println(integerCountMap);
        System.out.println("size() = " + integerCountMap.size());
        integerCountMap.add(10);
        integerCountMap.add(10);
        integerCountMap.add(5);
        integerCountMap.add(6);
        integerCountMap.add(5);
        integerCountMap.add(10);
        System.out.println(integerCountMap);

        Integer key = 10, key2 = key + 1;
        System.out.println("getCount(" + key + ") = " + integerCountMap.getCount(key));
        System.out.println("getCount(" + key2 + ") = " + integerCountMap.getCount(key2));

        System.out.println("remove(" + key + ") = " + integerCountMap.remove(key));
        System.out.println("remove(" + key2 + ") = " + integerCountMap.remove(key2));
        System.out.println(integerCountMap);
        System.out.println("size() = " + integerCountMap.size());

        System.out.println("remove(" + key2 + ") = " + integerCountMap.remove(key2));
        System.out.println(integerCountMap);

        CountMap<Integer> integerCountMapForAddAll = new CountMapImpl<>();
        integerCountMapForAddAll.add(5);
        integerCountMapForAddAll.add(7);

        integerCountMap.addAll(integerCountMapForAddAll);
        System.out.println("addAll(" + integerCountMapForAddAll + ") = " + integerCountMap);

        System.out.println("toMap() = " + integerCountMap.toMap());

        Map<Integer, Integer> map = new HashMap<>();
        map.put(key2, 5);
        System.out.print(integerCountMap + ".toMap(" + map + "): ");
        integerCountMap.toMap(map);
        System.out.println("map = " + map);
    }
}