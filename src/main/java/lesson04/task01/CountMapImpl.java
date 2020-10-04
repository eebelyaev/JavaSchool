package lesson04.task01;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {
    private Map<T, Integer> map;

    public CountMapImpl() {
        map = new HashMap<>();
    }

    @Override
    public String toString() {
        return "CountMapImpl" + map + '}';
    }

    @Override
    public void add(T o) {
        map.put(o, getCount(o) + 1);
    }

    @Override
    public int getCount(T o) {
        return map.containsKey(o) ? map.get(o) : 0;
    }

    @Override
    public int remove(T o) {
        Integer count = map.remove(o);
        return count != null ? count : 0;
    }

    @Override
    public int size() {
        return map.size();
    }

    /**
     * Добавить все элементы из source в текущий контейнер,
     * при совпадении ключей, суммировать значения
     *
     * @param source
     */
    @Override
    public void addAll(CountMap<T> source) {
        for (Map.Entry<T, Integer> entry : source.toMap().entrySet()) {
            T key = entry.getKey();
            if (map.containsKey(key)) map.put(key, map.get(key) + entry.getValue());
            else map.put(key, entry.getValue());
        }
    }

    /**
     * Вернуть java.util.Map. ключ - добавленный элемент,
     * значение - количество его добавлений
     *
     * @return
     */
    @Override
    public Map<T, Integer> toMap() {
        return new HashMap<>(map);
    }

    /**
     * Тот же самый контракт как и toMap(), только всю информацию записать в destination
     *
     * @param destination
     */
    @Override
    public void toMap(Map<T, Integer> destination) {
        destination.clear();
        destination.putAll(toMap());
    }
}
