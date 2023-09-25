package miscellaneous_practice;

import java.util.ArrayList;
import java.util.List;

public class FirstAndLastOccurrenceOfElement {

    /**
     * Another way is using lower and higher bound;
     * 
     * @param array
     * @param start
     * @param end
     * @param element
     * @return
     */

    private static int firstOccurrence(int[] array, int start, int end, int element) {
        int pos = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == element) {
                // first will be towards left
                pos = mid;
                end = mid - 1;
            } else if (array[mid] < element) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return pos;

    }

    private static int lastOccurrence(int[] array, int start, int end, int element) {
        int pos = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == element) {
                // last will be towards right
                pos = mid;
                start = mid + 1;
            } else if (array[mid] < element) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return pos;

    }

    public static List<Integer> occurenceIntegers(int[] array, int element) {
        List<Integer> list = new ArrayList<>();
        int firstOcc = firstOccurrence(array, 0, array.length - 1, element);
        if (firstOcc == -1) {
            list.add(-1);
            list.add(-1);

        } else {
            int lastOccurrence = lastOccurrence(array, 0, array.length - 1, element);
            list.add(firstOcc);
            list.add(lastOccurrence);
        }
        return list;
        /**
         * For count lastOccurrence-firstOcc+1;
         */
    }

    public static void main(String[] args) {
        int[] array = { 2, 3, 4, 4, 4, 4, 5, 6, 6, 7, 8 };
        System.out.println(occurenceIntegers(array, 4));
    }
}
