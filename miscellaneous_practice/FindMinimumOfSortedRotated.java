public class FindMinimumOfSortedRotated {
    public static int res = -1;

    // doubt : What for 5,4,3,2,1
    public static int minElement(int[] array, int start, int end) {
        int minElement = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = (start + end) / 2;

            // based on minimum value in a sorted part
            if (array[start] <= array[end]) {
                // if we reach a start end end, and if it is completely sorted then min value
                // wil be first value itself;
                minElement = Math.min(minElement, array[start]);
                break;
            }
            // min value can be on unsorted side as well
            if (array[mid] >= array[start]) {
                minElement = Math.min(minElement, array[start]);
                // left sorted, smallest might be on right
                start = mid + 1;
            } else {
                end = mid - 1;
                minElement = Math.min(minElement, array[mid]);
                // right sorted, smallest might be on left
            }
        }
        return minElement;
    }

    public static int minElementPos(int[] array, int start, int end) {
        int minElement = Integer.MAX_VALUE;
        int pos = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            // based on minimum value in a sorted part
            if (array[start] <= array[end]) {
                // if we reach a start end end, and if it is completely sorted then min value
                // wil be first value itself;
                if (minElement >= array[start]) {
                    minElement = array[start];
                    pos = start;
                }
                break;
            }
            // min value can be on unsorted side as well
            if (array[mid] >= array[start]) {
                if (minElement >= array[start]) {
                    minElement = array[start];
                    pos = start;
                }
                // left sorted, smallest might be on right
                start = mid + 1;
            } else {
                end = mid - 1;
                if (minElement >= array[mid]) {
                    minElement = array[mid];
                    pos = mid;
                }
                // right sorted, smallest might be on left
            }
        }
        return pos;
    }

    public static int numberOfRotations(int[] array, int start, int end) {
        int minPos = minElementPos(array, 0, array.length - 1);
        return minPos;

    }

    public static void main(String[] args) {
        int[] array = { 5, 6, 7, 8, 9, 1, 2, 3 };
        int[] array3 = { 5, 4, 3, 2, 1 };
        // unsorted contain min
        int[] array2 = { 4, 5, 1, 2, 3 };

        System.out.println(minElement(array3, 0, array3.length - 1));
        System.out.println(numberOfRotations(array2, 0, array2.length - 1));
    }
}
