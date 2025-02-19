/**
 * 1. Swiggy Pantry - Knight Moves
 * At Swiggy, people tend to move diagonally instead of straight line as moving
 * straight is too mainstream. Every floor in Swiggy office is an infinite
 * canvas, where you can only move diagonally. In one move you can take multiple
 * steps i.e you can jump more than one cell on the two dimensional grid. The
 * move is considered to be a single move unless you take a turn where the # of
 * moves is increased by 1(whenever you change your direction). Calculate the
 * minimum number of moves required to reach pantry from your cubicle.
 * 
 * Input Format:
 * First line has integer T, the number of test cases
 * In each test case first line contains integer N
 * Next line contains 4 integers a,b,c,d first two are the co-ordinates of
 * source(your cubicle) and the next two are co-ordinates of destination(pantry)
 * 
 * Output Format:
 * Print the minimum number of moves.
 * If you can’t reach print -1
 * 
 * Constraints
 * 1 <= T <=10
 * 1 <= N <= 10^18
 * 1 <= a , b , c , d <= N
 * 
 * Sample Input:
 * 1
 * 4
 * 1 1 3 3
 * 
 * Sample Output:
 * 1
 */

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class SwiggyQ1 {
    private static int numberOfMoves(Point source, Point target) {
        if (((source.x + source.y) % 2) != ((target.x + target.y) % 2)) {
            return -1;
        }
        // there is always a center point till where we can go and the return to
        // destination
        return (Math.abs(target.x - source.x) == Math.abs(target.y - source.y)) ? 1 : 2;
    }

    public static void main(String[] args) {
        Point source = new Point(0, 1);
        Point target = new Point(0, 5);
        System.out.println(numberOfMoves(source, target));
    }
}
