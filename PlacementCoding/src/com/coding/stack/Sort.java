

import java.util.ArrayList;
import java.util.List;

/**
 * Given a stack of integers, sort it in ascending order using another temporary stack.
 */
public class Sort {


    public static void insertElement(List<Integer> array, int element,int top){
// top will contain smallest LIFO
        if(top==-1){
            array.add(element);
            return;
        }

        if(array.get(top)>element){
            array.add(element);
            return;
        }

        int topELe=array.get(top);
        array.remove(top);
        top--;
        insertElement(array, element,top);
        array.add(topELe);
    }
    

    public static List<Integer> sort(int[] array) {
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<array.length;i++){
            insertElement(res, array[i],i-1);
        }
        return res;
    }
   public static void main(String[] args) {
        int[] array={56,3,12,5,7,23};
        System.out.println(sort(array));
   }

}
