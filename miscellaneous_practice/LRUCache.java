package miscellaneous_practice;

import java.util.HashMap;

class DoubleNode{
   DoubleNode prev, next;
        int key, value;
        DoubleNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
}
public class LRUCache {

    static HashMap<Integer, DoubleNode> map=null;
    static DoubleNode head, tail;
    static int size=0;
    public static void createCache(int size){
        map=new HashMap<>();
        head=new DoubleNode(0,0);
        tail= new DoubleNode(0,0);
        head.next=tail;
        tail.prev=head;
        size=size;
    }
    
    public static int get(int key) {
        if(map.containsKey(key)){
            DoubleNode node = map.get(key);
            remove(node);
            insert(node);
            return node.value;

        }
        else{
            return -1;
        }
    }

    public static void put(int key,int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == size) {
            remove(tail.prev);
        }
        insert(new DoubleNode(key, value));
    }


    private static void remove(DoubleNode node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private static void insert(DoubleNode node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    public static void main(String[] args) {
        
    }
}
