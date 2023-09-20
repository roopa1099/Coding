package miscellaneous_practice;

/**
 * Find max subrray product
 */
public class MaxSubarrayProd {

    /*
     * t(n)=O(n)
     */
    public static int maxProd(int[] array) {
        //[3,2,5,-6,7,3];
        //if we have all positive or even negatives then prefix prod is max,
        
        
        //if we have odd neg, then 
        // [2,4,1,-5,6,2,-2,8,4,9,-3,5]=>
        // Case 1: [2,4,1] or [6,2,-2,8,4,9,-3,5] is max 
        //Case 2: [2,4,1,-5,6,2] or [8,4,9,-3,5] is max
        // Case 3: [2,4,1,-5,6,2,-2,8,4,9] or [5] is max
        // That is removing one negative can make it max, which is basically max between prefix or suffix product from each neg element
        int prefixProd=1,suffixProd=1,maxProd=Integer.MIN_VALUE,n=array.length;
        for(int i=0;i<array.length;i++){
            // in case of 0, ignore the zero, start new case after 0
            if(prefixProd==0){
                prefixProd=1;
            }if(suffixProd==0){
                suffixProd=1;
            }
            prefixProd=prefixProd*array[i];
            suffixProd=suffixProd*array[n-i-1];
            maxProd=Math.max(maxProd, Math.max(prefixProd, suffixProd));
        }
        return maxProd;

    }
    public static void main(String[] args) {
        int[] array={3,2,-5,12,0,2};
        System.out.println(maxProd(array));
    }
}
