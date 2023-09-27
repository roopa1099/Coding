public class SearchInRotatedArray {

    // identify the sorted
    public static int position(int[] array, int start, int end, int element) {

        int pos = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == element) {
                pos = mid;
                break;
            } else if (array[start] == array[mid] && array[end] == array[mid]) {
                // duplicate elements condition
                start++;
                end--;
            } else if (array[start] <= array[mid]) {
                // left sorted
                if (array[start] <= element && array[mid] >= element) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                /// right sorted
                if (array[mid] <= element && array[end] >= element) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] array = { 10, 12, 13, 14, 15, 3, 5, 6, 7 };
        int[] array2 = { 3, 3, 3, 3, 1, 3, 3 };
        System.out.println(position(array, 0, array.length - 1, 1));
        System.out.println(position(array2, 0, array2.length - 1, 2));
    }
}
