package Practice;

class TrieNode {
    TrieNode[] data;
    boolean isendofWord;

    TrieNode() {
        this.data = new TrieNode[26];
        this.isendofWord = false;
    }
}

public class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    // Insert a word into the trie
    void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.data[index] == null) {
                node.data[index] = new TrieNode();
            }
            node = node.data[index];
        }
        node.isendofWord = true;
    }
    

    // Search a word in the trie
    boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.data[index] == null) {
                return false;
            }
            node = node.data[index];
        }
        return node.isendofWord;
    }

    // Check if any word starts with the given prefix
    boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.data[index] == null) {
                return false;
            }
            node = node.data[index];
        }
        return true;
    }

    // Test in main
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");

        System.out.println(trie.search("apple"));    // true
        System.out.println(trie.search("app"));      // true
        System.out.println(trie.search("appl"));     // false
        System.out.println(trie.startsWith("app"));  // true
        System.out.println(trie.startsWith("ba"));   // true
        System.out.println(trie.startsWith("cat"));  // false
    }
}
