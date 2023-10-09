package miscellaneous_practice;

/**
 * Given two sorted arrays arr1 and arr2 of size m and n respectively, return the median of the two 
 * sorted arrays. The median is defined as the middle value of a sorted list of numbers. In case the 
 * length of the list is even, the median is the average of the two middle elements.
 */
public class MedianInArray {

    public static double medianInArray(int[] array1, int[] array2) {
        /**
         * Need to find how many elements to be taken from smaller array at left side before mid i.e. array1
         */
        if(array2.length<array1.length){
            medianInArray(array2, array1);
        }

        int low=0, high=array1.length;// 0 elements from array 1  min, or all elements from array 1 at max
        int totalElementTillMedian=(array1.length+array2.length+1)/2;
        int array1Length=array1.length, array2Length=array2.length;
        int l1=Integer.MIN_VALUE,l2=Integer.MIN_VALUE, r1=Integer.MAX_VALUE, r2=Integer.MAX_VALUE;
        

        /**
         * If number of elements selected from array1 is correct i.e l1<=r2, l2<=r1;
         */
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=totalElementTillMedian-mid1;
            if(mid1-1>=0){
                l1=array1[mid1-1];
            }

            if(mid2-1>=0){
                l2=array2[mid2-1];
            }

            if(mid1<array1Length){
                r1=array1[mid1];
            }

            if(mid2<array2Length){
                r2=array2[mid2];
            }
            //l1<=r2, l2<=r1, index=mid-1 as mid is number of elements;
           if(l1<=r2 && l2<=r1){
                 //if odd, take mid element else formula
                 if((array1Length+array2Length)%2==0){
                    return ((double)Math.max(l1, l2)+Math.min(r1, r2))/2.0;   
                 }
                 else{
                    return Math.max(l1, l2);
                 }         
           }
           else if(l1>r2){
                //take less elements
                high=mid1-1;
           }
           else{
                //take more elements
                low=mid1+1;
           }
        }
        return 0;
    }
    

    //find kth element in 2 sorted array
    public static double kthElementInSortedArray(int[] array1, int[] array2, int k) {
        if(array2.length<array1.length){
            kthElementInSortedArray(array2, array1, k);
        }
        
        // Find number of elements in array1
        int low=0, high=array1.length;
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=k-mid1;

            // check if numbe rof elements is correct
            int l1=Integer.MIN_VALUE,l2= Integer.MIN_VALUE, r1= Integer.MAX_VALUE, r2= Integer.MAX_VALUE;
            if(mid1-1>=0) l1=array1[mid1-1];
            if(mid2-1>=0) l2=array2[mid2-1];
            if(mid1<array1.length) r1=array1[mid1];
            if(mid2<array2.length) r2=array2[mid2];


            if(l1<=r2 && l2<=r1){
                if((array1.length+array2.length)%2==0){
                    return ((double)(Math.max(l1, l2)+Math.min(r1, r2)))/2.0;
                }
                else{
                    return Math.max(l1, l2);
                }
            }
            else if(l1>r2){
                //reduce number of elemnts isn array1
                high=mid1-1;
            }
            else{
                low=mid1+1;
            }
        } 
        return 0;
    }
public static void main(String[] args) {
    int[] array1={1, 4, 7, 10, 12};
    int[] array2={2, 3, 6, 15};
    System.out.println(medianInArray(array1, array2));
    System.out.println();
    System.out.println(kthElementInSortedArray(array1, array2, 3));

}
}
