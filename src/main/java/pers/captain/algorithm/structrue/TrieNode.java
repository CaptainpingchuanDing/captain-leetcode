package pers.captain.algorithm.structrue;

public class TrieNode {


    public char val;

    public TrieNode next[] = new TrieNode[26];

    public boolean isEnd;

    public TrieNode(char val ){
        this.val = val;
    }



}
