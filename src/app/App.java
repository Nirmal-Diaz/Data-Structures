package app;

public class App {
    public static void main(String[] args) {
        int[] x = {54, 26, 93, 17, 77, 31, 44, 55, 20};

        algorithms.ArraySorter.bubbleSort(x);
        printArray(x);
    }

    public static void printArray(int[] array) { 
        StringBuilder s = new StringBuilder();
        for (int i=0; i < array.length; i++) {
            s.append(array[i] + " ");
        }
        System.out.println(s);
    }
}