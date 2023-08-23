package miscellaneous_practice;

/**
 * Finding missing element
 */
public class MissingElement {
    //t(n)=O(n)
    public static int missingElement(int[] array) {
        int xor1=1,xor2=0;
        for(int i=0;i<array.length;i++){
            xor1=xor1^(i+2);
            xor2=xor2^array[i];
        }

        return xor1^xor2;
    }

     public static int missingElement2(int[] array) {
     //t(n)=   o(2n)
        int pt=0;
        while(pt<array.length){
            int element=array[pt];
            if(element>array.length || array[element-1]==element){
                  pt++;
            }
            else{
                int temp=array[element-1];
                array[element-1]=element;
                array[pt]=temp;
            }


        }

        int res=array.length+1;
        for(int i=0;i<array.length;i++){
            if(array[i]!=i+1){
                res=i+1;
            }
        }


        return res;
    }
 
    public static void main(String[] args) {
        int[] array={1,3,2,4,6,5};
        System.out.println(missingElement(array));
         System.out.println(missingElement2(array));
    }
}
