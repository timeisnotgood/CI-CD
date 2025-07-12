package Practice;

class TrieNode {
    TrieNode[] data;
    boolean isLastWord;
    
    TrieNode(){
        data = new TrieNode[26];
        isLastWord = false;
    }
}
public class Solution {
    TrieNode root;

    Solution(){
        root = new TrieNode();
    }

    void insertWord(String val){
        TrieNode node = root;

        for(char ch : val.toCharArray()){
            int index = ch - 'a';
            if(node.data[index] == null){
                node.data[index] = new TrieNode();
            }
            node = node.data[index];

        }
        node.isLastWord = true;
    }

    boolean searchWord(String word){
        TrieNode node = root;

        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(node.data[index] == null){
                return false;
            }
            node = node.data[index];
        }

        return node.isLastWord;
    }

    boolean prefix(String prefix){
        TrieNode node = root;
        for(char ch : prefix.toCharArray()){
            int index = ch - 'a';
            if (node.data[index] == null) {
                return false;
            }
            node = node.data[index];
        }
        return true;
    }


    public static void main(String[] args) {
        Solution obj = new Solution();

        obj.insertWord("bhoopathi");
        obj.insertWord("asiwarya");


        System.out.println("--> " + obj.searchWord("asiwrya"));
        System.out.println("--> " + obj.prefix("as"));

    }
}