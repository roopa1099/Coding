package miscellaneous_practice;

import java.util.ArrayList;
import java.util.List;

public class DFSGraph {
    private static void dfsTraversal(List<List<Integer>> list, int[] visited, int element) {
        visited[element] = 1;
        System.out.println(element);
        int i = 0;
        while (i < list.get(element).size()) {
            if (visited[list.get(element).get(i)] == 0) {
                dfsTraversal(list, visited, list.get(element).get(i));
            }
            i++;
        }
        return;
    }

    public static void findDfsTraversal(List<PairForm> graphDetails, int nodes, int vertex) {
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
        dfsTraversal(list, visited, 1);
    }

    public static void main(String[] args) {
        PairForm pair1 = new PairForm(1, 2);
        PairForm pair2 = new PairForm(1, 4);
        PairForm pair3 = new PairForm(2, 3);
        PairForm pair4 = new PairForm(4, 5);
        PairForm pair5 = new PairForm(4, 8);
        PairForm pair6 = new PairForm(5, 6);
        PairForm pair8 = new PairForm(5, 7);
        PairForm pair9 = new PairForm(6, 7);
        List<PairForm> temp = new ArrayList<>();
        temp.add(pair1);
        temp.add(pair2);
        temp.add(pair3);
        temp.add(pair4);
        temp.add(pair5);
        temp.add(pair6);
        temp.add(pair8);
        temp.add(pair9);
        findDfsTraversal(temp, 8, 8);
    }
}
