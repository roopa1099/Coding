package miscellaneous_practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraph {
    // O(n)
    public static void bfsTraversal(List<PairForm> graphDetails, int nodes, int vertex) {
        int[] visited = new int[nodes + 1];
        for (int i = 0; i < nodes + 1; i++) {
            visited[i] = 0;
        }

        List<List<Integer>> list = new ArrayList<>(nodes + 1);
        int p = 0;
        while (p < nodes + 1) {
            list.add(p, new ArrayList<>());
            p++;
        }
        for (PairForm pairForm : graphDetails) {
            list.get(pairForm.val1).add(pairForm.val2);
            list.get(pairForm.val2).add(pairForm.val1);
        }

        Queue queue = new LinkedList<>();
        // whichever is start node take that value;
        queue.add(1);
        visited[1] = 1;

        while (!queue.isEmpty()) {
            int element = (int) queue.poll();
            System.out.println(element);
            for (int connectedNode : list.get(element)) {
                if (visited[connectedNode] == 0) {
                    queue.add(connectedNode);
                    visited[connectedNode] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        PairForm pair1 = new PairForm(1, 2);
        PairForm pair2 = new PairForm(1, 3);
        PairForm pair3 = new PairForm(3, 4);
        PairForm pair4 = new PairForm(3, 6);
        PairForm pair5 = new PairForm(2, 5);
        List<PairForm> temp = new ArrayList<>();
        temp.add(pair1);
        temp.add(pair2);
        temp.add(pair3);
        temp.add(pair4);
        temp.add(pair5);
        bfsTraversal(temp, 6, 5);
    }
}
