package miscellaneous_practice;

/**
 * Given an array of stocks, find max profit possible.
 */
public class MaxProfitStock {

    public static int maxProfit(int[] array) {
        // t(n)=O(n)
        int minimal=array[0], maxProfit=Integer.MIN_VALUE;
        for(int i=1;i<array.length;i++){
            maxProfit=Math.max(maxProfit,array[i]-minimal);
            minimal=Math.min(minimal, array[i]);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] array={7,2,8,4,1,3,6,8};
        System.out.println(maxProfit(array));
    }
}
