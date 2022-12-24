package com.coding.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of words in lexicographic order where no word is
 *  the prefix of another, find the shortest unique prefix to identify each word in the
 *  array uniquely.
 */

class TrieNode{
    Map<Character,TrieNode> child=new HashMap<>();
    int frequency=0;
}
public class SmaleestCommonPrefix {

    public static void insert (TrieNode root,String word){

        TrieNode current=root;
        // insert node into child of root, increase frequenc of that child, make that child as current
        for(char chr:word.toCharArray()){
            current.child.putIfAbsent(chr, new TrieNode());
            // get that particular child from root and increase frequency.
            current.child.get(chr).frequency++;
            // make that child current node, as next will be added as child to this child.
            current=current.child.get(chr);
            
        }
    }

    public static void printSmallestFreququencyPrefix(TrieNode root,String word_to_display) {
        if(root==null){
            return;
        }

        // // print `word_so_far` if the current Trie node is visited only once
        if(root.frequency==1){
            System.out.println(word_to_display);
            return;
        }
        
        // Keep on entering every child node of current node(as each will be leading to a word)
       for( Map.Entry<Character, TrieNode> node: root.child.entrySet()){
                printSmallestFreququencyPrefix(node.getValue(), word_to_display+node.getKey());
       }
    }

    public static void findSmallestWord(String[] words) {
        TrieNode root=new TrieNode();

        // insert all word one by one to form trienode with root
        for(String word:words){
            insert(root, word);
        }
        
        printSmallestFreququencyPrefix(root,"");
    }

    public static void main(String[] args)
    {
        String[] words = { "AND", "BONFIRE", "BOOL", "CASE", "CATCH", "CHAR" };
        findSmallestWord(words);
    }
}
