package miscellaneous_practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given and matrix of oranges, where 0 means no orange, 1 means fresh orange
 * and 2 means rotten. Find time taken to rotten all fresh oranges, rottening
 * can happen when if any orange in top,left,down or right has a rotten orange.
 */
class BfsQueueData {
    int row;
    int col;
    int time;

    public BfsQueueData(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class RottenOranges {

    public static int timeToRottenAllFreshOrange(int[][] matrix, int rows, int cols) {

        int[][] rottenOrangesVisited = new int[rows][cols];
        Queue<BfsQueueData> queue = new LinkedList<>();
        int maxTim = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 2) {
                    rottenOrangesVisited[i][j] = 2;
                    queue.add(new BfsQueueData(i, j, 0));
                } else {
                    rottenOrangesVisited[i][j] = 0;
                }

            }
        }
        int[] rowPos = { -1, 0, +1, 0 };
        int[] colPos = { 0, +1, 0, -1 };

        while (!queue.isEmpty()) {
            BfsQueueData data = queue.poll();
            int checkRow = data.row;
            int checkCol = data.col;
            for (int i = 0; i < 4; i++) {
                checkRow = data.row + rowPos[i];
                checkCol = data.col + colPos[i];
                if (checkRow >= 0 && checkRow < rows && checkCol >= 0 && checkCol < cols) {
                    if (matrix[checkRow][checkCol] == 1 && rottenOrangesVisited[checkRow][checkCol] != 2) {
                        rottenOrangesVisited[checkRow][checkCol] = 2;
                        queue.add(new BfsQueueData(checkRow, checkCol, data.time + 1));
                        maxTim = Math.max(maxTim, data.time + 1);
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1 && rottenOrangesVisited[i][j] != 2) {
                    return -1;
                }
            }
        }

        return maxTim;

    }

    public static void main(String[] args) {
        int[] row1 = { 0, 1, 2 };
        int[] row2 = { 0, 1, 1 };
        int[] row3 = { 2, 1, 1 };
        int[][] array = new int[3][3];

        array[0] = row1;
        array[1] = row2;
        array[2] = row3;
        System.out.println(timeToRottenAllFreshOrange(array, 3, 3));

    }
}
