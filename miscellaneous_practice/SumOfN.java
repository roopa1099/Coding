package miscellaneous_practice;

/**
 * SumOfN
 */
public class SumOfN {

    public static int sum(int N) {
        if(N==0){
            return 0;
        }
        //functional
        return N+sum(N-1);
    }

    public static void main(String[] args) {
        System.out.println(sum(3));
    }
}