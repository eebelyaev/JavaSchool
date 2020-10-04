package lesson02.task02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CountOfWords {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> wordsCount = new HashMap<String, Integer>();
        List<String> lstString = Files.readAllLines(Paths.get("C:\\Users\\Evgeny\\IdeaProjects\\JavaSchool\\src\\main\\java\\lesson01\\task03\\FiguresMain.java"));
        // Внесем слова в HashMap
        for (String line : lstString) {
            for (String word : line.toLowerCase().split("[^a-zа-я]")) {
                if (!word.equals("")) {
                    wordsCount.put(word, wordsCount.containsKey(word) ? wordsCount.get(word) + 1 : 1);
                }
            }
        }
        // Задание 1: Подсчитайте количество различных слов в файле
        //System.out.println("Задание 1\nКоличество различных слов в файле: " + wordsCount.size());

        List<String> lstWords = new ArrayList(wordsCount.keySet());
        // Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины
        //task02(lstWords);
        // Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле
        //task03(wordsCount);
        // Задание 4: Выведите на экран все строки файла в обратном порядке
        //task04(lstString);
        // Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядка
        task05(lstWords);
        // Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке
        task06(lstWords);
    }

    /**
     * Задание 2
     * Выведите на экран список различных слов файла, отсортированный по возрастанию их длины
     *
     * @param lstWords
     */
    private static void task02(List lstWords) {
        System.out.println("Задание 2");
        Collections.sort(lstWords, new MaxLengthComparator());
        System.out.println(lstWords);
    }

    private static void task02_2(List<String> lstWords) {
        System.out.println("Задание 2");
        Collections.sort(lstWords, (o1, o2) -> {
            if (o1.length() != o2.length()) return o1.length() - o2.length();
            else return o1.compareTo(o2);
        });
        System.out.println(lstWords);
    }

    /**
     * Задание 3
     * Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле
     *
     * @param hashMap
     */
    private static void task03(HashMap<String, Integer> hashMap) {
        System.out.println("Задание 3");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    /**
     * Задание 4
     * Выведите на экран все строки файла в обратном порядке
     *
     * @param list
     */
    private static void task04(List list) {
        System.out.println("Задание 4");
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }

    /**
     * Задание 5
     * Реализуйте свой Iterator для обхода списка в обратном порядка
     *
     * @param list
     */
    private static void task05(List list) {
        System.out.println("Задание 5");
        WordsIterator wordsIterator = new WordsIterator(list);
        int i = 0;
        while (wordsIterator.hasNext()) System.out.println(++i + ": " + wordsIterator.next());
    }

    /**
     * Задание 6
     * Выведите на экран строки, номера которых задаются пользователем в произвольном порядке
     *
     * @param list
     */
    private static void task06(List list) {
        System.out.println("Задание 6");
        Integer[] userOrder = new Integer[]{2, 8, 7, 3, 1, 5, 4};
        WordsIterator wordsIterator = new WordsIterator(list, userOrder);
        //while (wordsIterator.hasNext()) System.out.println(wordsIterator.next());
        wordsIterator.forEachRemaining(System.out::println);
    }
}

class MaxLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() != o2.length()) return o1.length() - o2.length();
        else return o1.compareTo(o2);
    }
}

class WordsIterator implements Iterator<String> {

    private List<String> list;
    private int index;
    private Integer[] orderIndexes;

    public WordsIterator(List list) {
        this.list = list;
        index = list.size();
    }

    public WordsIterator(List list, Integer[] orderIndexes) {
        this.list = list;
        index = -1;
        this.orderIndexes = orderIndexes;
    }

    @Override
    public boolean hasNext() {
        if (orderIndexes != null) return !list.isEmpty() && index < orderIndexes.length - 1;
        return !list.isEmpty() && index > 0;
    }

    @Override
    public String next() {
        if (orderIndexes != null) return list.get(orderIndexes[++index]);
        return list.get(--index);
    }
}