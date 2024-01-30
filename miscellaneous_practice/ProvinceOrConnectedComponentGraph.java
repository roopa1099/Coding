package miscellaneous_practice;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given list of nodes and their connected nodes, which is in the form
 * of connected componnents. Find number of disjoint components.
 */
public class ProvinceOrConnectedComponentGraph {

    private static void dfs(List<List<Integer>> list, int[] visitedArray, int element) {
        visitedArray[element] = 1;
        int elementCount = 0;
        while (elementCount < list.get(element).size()) {
            if (visitedArray[list.get(element).get(elementCount)] == 0) {
                dfs(list, visitedArray, list.get(element).get(elementCount));
            }
            elementCount++;
        }
    }

    public static int countNumberOfStartNodes(List<PairForm> list, int nodes, int vertices) {
        int[] visitedArray = new int[nodes + 1];
        List<List<Integer>> connectedNodeList = new ArrayList<>();

        for (int i = 0; i < nodes + 1; i++) {
            visitedArray[i] = 0;
            connectedNodeList.add(i, new ArrayList<>());
        }

        for (PairForm pairForm : list) {
            connectedNodeList.get(pairForm.val1).add(pairForm.val2);
            connectedNodeList.get(pairForm.val2).add(pairForm.val1);
        }

        int countStart = 0;
        for (int i = 1; i < nodes + 1; i++) {
            if (visitedArray[i] == 0) {
                countStart++;
                dfs(connectedNodeList, visitedArray, i);
            }
        }
        return countStart;
    }

    public static void main(String[] args) {
        PairForm pair1 = new PairForm(1, 2);
        PairForm pair2 = new PairForm(3, 4);
        PairForm pair3 = new PairForm(3, 5);
        PairForm pair4 = new PairForm(5, 6);
        PairForm pair5 = new PairForm(7, 8);
        PairForm pair6 = new PairForm(8, 9);
        List<PairForm> temp = new ArrayList<>();
        temp.add(pair1);
        temp.add(pair2);
        temp.add(pair3);
        temp.add(pair4);
        temp.add(pair5);
        temp.add(pair6);
        System.out.println(countNumberOfStartNodes(temp, 9, 6));

    }
}
