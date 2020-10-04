package lesson01.task01;

public class BubbleSort {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 2, 5, 8, 9, 6, 3, 7};
        printArray(a);
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) swap(a, i, j);
            }
        }
        printArray(a);
    }

    private static void printArray(Integer[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print('\n');
    }

    private static void swap(Integer[] a, int i, int j) {
        if (i != j && i < a.length && j < a.length && i >= 0 && j >= 0) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            System.out.println("a[" + i + "] <-> a[" + j + "]");
        }
    }
}