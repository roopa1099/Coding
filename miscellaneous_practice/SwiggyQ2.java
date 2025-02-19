import java.util.HashSet;

/**
 * In Swiggy archery game takes place in a square grid, where the balloons are
 * kept in the cells of the
 * square grid . Whenever a player shoots the arrow it bursts all the balloons
 * on its path. The players can
 * shoot from any side (only vertically and horizontally) which is outside the
 * square grid arena . Calculate the
 * minimum number of arrows required to burst all the balloons in the arena.
 * Moving across the boundary of the
 * grid is instantaneous and takes no time.
 * 
 * Input Format:
 * The first line contains T the number of test cases. The first line of each
 * test case contains N the number of
 * cells where balloons are present. The following N lines contain two integers
 * X and Y each describing the index of
 * the cell in which balloons are present.
 * 
 * Output Format:
 * For each case print the minimum arrows required to burst all balloons.
 * 
 * Constraints:
 * 1 ≤ T ≤ 10
 * 1 ≤ N ≤ 50
 * 0 ≤ X, Y ≤ (10^9)-1
 * 
 * Sample Input:
 * 
 * 
 * 1
 * 4
 * 0 2
 * 1 0
 * 1 1
 * 1 2
 * 
 * Sample Output:
 * 2
 */

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class SwiggyQ2 {

    public static int minArrows(Point[] balloons) {
        // find unique rows ad cols
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();

        for (Point p : balloons) {
            rows.add(p.x);
            cols.add(p.y);
        }

        int minArrows = Math.min(rows.size(), cols.size());
        return minArrows;
    }

    public static void main(String[] args) {
        Point[] balloons = { new Point(3, 2), new Point(10, 11), new Point(7, 5), new Point(2, 0), new Point(9, 13) };
        System.out.println(minArrows(balloons));
    }
}
