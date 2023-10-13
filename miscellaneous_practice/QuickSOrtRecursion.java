package miscellaneous_practice;
/**
 * Quick sort usingrecusrsion
 * 
 * Find first element greater than pivot element, from left.
 * Find first element les than pivot element from riht
 * if righ<left then swap
 */
public class QuickSOrtRecursion {

    private static int sort(int[] array, int start, int end) {
        int pivotElement=array[start];
        int low=start, high=end;
        while(low<=high){
            while(low<=end && array[low]<=pivotElement){
                low++;
            }
            while(high>start && array[high]>pivotElement){
                high--;
            }

            if(low<high){
            int temp=array[low];
            array[low]=array[high];
            array[high]=temp;
            }
          
        }
            int temp=array[start];
            array[start]=array[high];
            array[high]=temp;   
            return high;
    }
    public static void quickSort(int[] array, int low, int high) {

        if(low<high){    
            int index=sort(array, low, high);
            quickSort(array, low, index-1);
            quickSort(array, index+1, high);
        }

        
    }
    public static void main(String[] args) {
        int[] array={4,2,6,1,7};
        quickSort(array, 0, array.length-1);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
