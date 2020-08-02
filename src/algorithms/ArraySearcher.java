package algorithms;

public class ArraySearcher {
    public static int linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] array, int value, int startIndex, int endIndex) {
        int midIndex = (startIndex + endIndex) / 2;

        if (array[midIndex] == value) {
            return midIndex;
        } else if (startIndex == endIndex) {
            return -1;
        } else {
            if (array[midIndex] > value) {
                //CASE: Value must be at a lower index than midIndex
                return binarySearch(array, value, 0, midIndex - 1);
            } else {
                //CASE: Value must be at a higher index than midIndex
                return binarySearch(array, value, midIndex + 1, array.length - 1);
            }
        }
    }
}