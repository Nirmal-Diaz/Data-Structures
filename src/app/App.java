package app;

public class App {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(ArraySearcher.binarySearch(arr, 3));
    }

    public static void printArray(int[] array) { 
        StringBuilder s = new StringBuilder();
        for (int i=0; i < array.length; i++) {
            s.append(array[i] + " ");
        }
        System.out.println(s);
    }
}