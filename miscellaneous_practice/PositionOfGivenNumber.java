package miscellaneous_practice;

public class PositionOfGivenNumber {

    public static int lowerBound(int[] array, int start, int end, int element) {
        // array[i]>=element
        int pos = end + 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] >= element) {
                // move left to check first number = or > than element
                pos = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return pos;
    }

    public static int upperBound(int[] array, int start, int end, int element) {
        // array[i]>element
        int pos = end + 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] > element) {
                // move left to check first number > than element
                pos = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return pos;
    }

    /**
     * t(n)= log N
     * 
     * @param array
     * @param element
     * @return
     */
    public static int position(int[] array, int element) {
        int lowerBound = lowerBound(array, 0, array.length - 1, element);
        System.out.println("Lower bound " + lowerBound);
        System.out.println("Upper bound " + upperBound(array, 0, array.length - 1, element));
        return lowerBound;
    }

    public static void main(String[] args) {
        int[] array = { 2, 4, 4, 6, 7, 8 };
        System.out.println(position(array, 4));
    }
}
