package app;

public class App {
    public static void main(String[] args) {

    }

    public static void printArray(int[] array) { 
        StringBuilder s = new StringBuilder();
        for (int i=0; i < array.length; i++) {
            s.append(array[i] + " ");
        }
        System.out.println(s);
    }
}