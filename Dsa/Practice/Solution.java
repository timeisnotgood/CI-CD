package Practice;

    class Node {
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

public class Solution {
    Node root;

    void insert(int val){
        root = insertrec(val, root);
    }

    Node insertrec(int val, Node root){
        if (root == null) {
            return new Node(val);
        }

        if (val < root.data) {
            root.left = insertrec(val, root.left);
        }else if (val > root.data) {
            root.right = insertrec(val, root.right);
        }

        return root;
    }

    void PostOrderTraversal(Node root){
        if (root != null) {
            PostOrderTraversal(root.left);
            PostOrderTraversal(root.right);
            System.out.println("-->" + root.data);
        }
    }


    public static void main(String[] args) {
        System.out.println("Working");
    }
}