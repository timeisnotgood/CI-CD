package Practice;

public class Solution {

    static class Tree {
        int data;
        Tree left, right;

        Tree(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    Tree root;

    Solution(){
        this.root = null;
    }

    void insert(int val){
        root = insertRec(root, val);
    }

    Tree insertRec(Tree root, int val){
        if (root == null) {
            root = new Tree(val);
            return root;
        }

        if (val < root.data) {
            root.left = insertRec(root.left, val);
        }else if (val > root.data) {
            root.right = insertRec(root.right, val);
        }

        return root;
    }

    void preOrderTraversal(Tree root){
        if (root != null) {
            System.out.println(root.data);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    void inOrderTraversal(Tree root){
        if (root != null) {
            preOrderTraversal(root.left);
            System.out.println(root.data);
            preOrderTraversal(root.right);
        }
    }

    Boolean search(Tree root, int val ){
        if (root == null) {
            return false;
        }else if (root.data == val) {
            return true;
        }
        
        return val < root.data ? 
        search(root.left, val) : search(root.right, val);
    }

    public static void main(String[] args) {

        Solution bineTree = new Solution();

        bineTree.insert(1);
        bineTree.insert(2);
        bineTree.insert(3);
        bineTree.insert(4);

        System.out.println("Traversal ---->");
        bineTree.preOrderTraversal(bineTree.root);

        System.out.println("Search ---> ");
        System.out.println("Key " + 3 + "--> " + bineTree.search(bineTree.root, 2));
    }
}