package miscellaneous_practice;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Pair {
    TreeNode node;
    int hd;

    public Pair(TreeNode node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class TopViewOfTree {

    public static ArrayList<Integer> viewTree(TreeNode root) {

        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair it = q.remove();
            int hd = it.hd;
            TreeNode temp = it.node;
            if (map.get(hd) == null)
                map.put(hd, temp.data);
            if (temp.left != null) {

                q.add(new Pair(temp.left, hd - 1));
            }
            if (temp.right != null) {

                q.add(new Pair(temp.right, hd + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;

    }

    public static void main(String[] args) {

    }
}
