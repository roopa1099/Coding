package miscellaneous_practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Find count of subarray with xor "k".
 */
public class SubarrayWithKXor {

    /**
     * Let there be a array = {4,2,6,1,7,3}
     * We want to find subarray with xor value 'Y';
     * 
     * Lets consider an sub array {2,6,1,7}
     * Assume that there is a subarray {1,7} with this subarray which has an xor of
     * 'Y'.
     * Suppose the xor of rest of the subarray i.e. {2,6} contain an xor of 'x'
     * And the xor of this entire subarray {2,6,1,7} is 'Z'.
     * 
     * In short, x ^ Y = Z => x ^ Y ^ Y = Z ^ Y
     * => x = Z ^ Y
     * where Z is the xor of entire subarray, which includes current element.
     * where Y is the xor value we are searching
     * where x is the xor value we must have encountered before
     *
     *
     */
    public static int countSubarray(int[] array, int xorValue) {
        int count = 0, currentXorValue = 0;
        // x is the xor value we must have encountered before, so for storing we need an
        // hashmap, to also maitain the count
        Map<Integer, Integer> xorMap = new HashMap<>();
        // necessary when we consider and entire subarray with current element, and that
        // has an xor of xorValue
        xorMap.put(0, 1);
        for (int i = 0; i < array.length; i++) {
            currentXorValue = currentXorValue ^ array[i];
            int searchXorValue = currentXorValue ^ xorValue;

            if (xorMap.containsKey(searchXorValue)) {
                count = count + xorMap.get(searchXorValue);
            }
            if (xorMap.containsKey(currentXorValue)) {
                xorMap.put(currentXorValue, xorMap.get(currentXorValue) + 1);
            } else {
                xorMap.put(currentXorValue, 1);
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int[] array = { 4, 2, 2, 6, 4 };
        System.out.println(countSubarray(array, 6));
    }
}
