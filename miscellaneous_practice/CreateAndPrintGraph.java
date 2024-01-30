package miscellaneous_practice;

import java.util.ArrayList;
import java.util.List;

class PairForm {
    int val1;
    int val2;

    public PairForm(int val1, int val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

}

/**
 * CreateAndPrintGraph
 */
public class CreateAndPrintGraph {

    public static List<List<Integer>> createAndPrintGraph(List<PairForm> graphDetails, int nodes, int vertex) {
        List<List<Integer>> resuList = new ArrayList<>();

        // 1based indexing

        for (int i = 1; i <= nodes; i++) {
            // here each i is each edge, and it stores list of nodes connected to it.
            List<Integer> temp = new ArrayList<>();
            resuList.add(temp);
        }

        for (PairForm ePair : graphDetails) {
            resuList.get(ePair.val1 - 1).add(ePair.val2);
            // if undirected
            resuList.get(ePair.val2 - 1).add(ePair.val1);
        }

        return resuList;

    }

    public static void main(String[] args) {
        PairForm pair1 = new PairForm(1, 2);
        PairForm pair2 = new PairForm(1, 3);
        PairForm pair3 = new PairForm(3, 4);
        List<PairForm> temp = new ArrayList<>();
        temp.add(pair1);
        temp.add(pair2);
        temp.add(pair3);
        System.out.println(createAndPrintGraph(temp, 4, 3));

    }
}