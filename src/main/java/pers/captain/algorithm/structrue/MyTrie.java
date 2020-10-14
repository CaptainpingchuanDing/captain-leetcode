package pers.captain.algorithm.structrue;

public class MyTrie {

    private TrieNode root;

    public MyTrie() {
        root = new TrieNode(' ');
        root.next = new TrieNode[26];

    }

    public TrieNode insert(String word) {
        if (word == null || "".equals(word)) {
            return null;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.next[word.charAt(i) - 'a'] == null) {
                node.next[word.charAt(i) - 'a'] = new TrieNode(word.charAt(i));
            }
            node = node.next[word.charAt(i) - 'a'];
        }
        node.isEnd = true;

        return root;
    }

    public boolean search(String word) {
        if (word == null || "".equals(word)) {
            return false;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.next[word.charAt(i) - 'a'] == null) {
                return false;
            }
            node = node.next[word.charAt(i) - 'a'];
        }
        return node.isEnd;
    }

    public boolean startWith(String prefix) {
        if (prefix == null || "".equals(prefix)) {
            return false;
        }
        TrieNode currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (currentNode.next[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            currentNode = currentNode.next[prefix.charAt(i) - 'a'];
        }

        return true;
    }

    public static void main(String[] args) {
        MyTrie trie = new MyTrie();

//        myTrie.insert("love");
//        myTrie.insert("loft");
//        myTrie.insert("loft");
//
//        System.out.println(myTrie.search("love"));
//        System.out.println(myTrie.startWith("lo"));

        trie.insert("flink");
        trie.insert("netty");
        trie.insert("mysql");
        trie.insert("redis");

        // false
        System.out.println(trie.search("mongodb"));
        // true
        System.out.println(trie.search("redis"));
        //false
        System.out.println(trie.search("my"));
        // true
        System.out.println(trie.search("mysql"));
        // true
        System.out.println(trie.startWith("my"));
    }
}
