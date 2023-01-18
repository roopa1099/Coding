package com.coding.recursion;

/**
 * Given a set of characters generate all possible passwords from them. This means we should generate all possible permutations of words using the 
 * given characters, with repetitions and also upto a given length. 
 */
public class RecPossiblePassword {
    

    public static void possiblePatternOfLength(char[] array, int possibleLength, String str, int totalLength){

        if(possibleLength==0){
            System.out.println(str);
            return;
        }
        for(int j=0;j<totalLength;j++){
            String appended=str+array[j];
            // possiblelength-1 possibilities
            possiblePatternOfLength(array,possibleLength-1,appended,totalLength);
        }
    }

    public static void patternOfGivenArray(char array[]) {
        //loop for all possible length
        for(int i=1;i<=array.length;i++){
            possiblePatternOfLength(array, i, "", array.length);
        }
    }
    public static void main(String[] args) {
        char[] array={'a','b','c'};
        patternOfGivenArray(array);
    }
}
