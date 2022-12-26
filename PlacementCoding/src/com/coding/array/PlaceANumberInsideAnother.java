package com.coding.array;
// Not correct
/**
 * Given a 32bit number M and N. Given 2 position i and j. Replace te i to j index of N with M.
 * Examplw: N=10000000.
 * M=1010,i=2,j=5;
 * Output= 10010100
 */
public class PlaceANumberInsideAnother {

    public static int updateNumber(int N,int M,int i,int j){
//        first clear bits from j to i and then do an or opertation.
//        clearBits
        int maskLeft=~0<<j+1;
        int maskRight=~(~1<<i);
        int mask=maskLeft | maskRight;
        int num=N & mask;
//        move M between i and j
        int k=M<<i;
        return num | k;
    }


    public static void main(String[] args){
        int num=15;
        System.out.println(updateNumber(15,2,1,3));
    }
}
