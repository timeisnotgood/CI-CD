package Practice;

class TrieNode{
    TrieNode[] data;
    boolean isendofWord;

    TrieNode(){
        this.data = new TrieNode[26];
        this.isendofWord = false;
    }
}

public class Trie {
    private TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    void insert(String word){
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if (node.data[index] == null) {
                node.data[index] = new TrieNode();
            }
            node = node.data[index];
        }
        node.isendofWord = true;
    }

    boolean search(String word){
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            int index = ch - 'a';
            if (node.data[index] == null) {
                return false;
            }
            node = node.data[index];
        }
        return node.isendofWord;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
    }
}
