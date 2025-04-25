package Algorithams;

class Node{
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
    }
}
public class Tree {
    Node root;

    void insert(int data){
        root = insertrec(root, data);
    }

    Node insertrec(Node root, int data){
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insertrec(root.left, data);
        }else{
            root.right = insertrec(root.right, data);
        }

        return root;
    }

    void inOrderTrav(Node root){
        if (root != null) {
            inOrderTrav(root.left);
            System.out.println("-> " + root.data);
            inOrderTrav(root.right);
        }
    }

    int searchNode(Node root, int val){
        if (root == null || root.data == val ) {
            return root.data;
        }

        if (val < root.data) {
            return searchNode(root.left, val);
        }else{
            return searchNode(root.right, val);
        }
    }

    Node searchIterative(Node root, int val){
        while (root != null) {
            if (root.data == val) {
                return root;
            }else if(val < root.data ){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Tree binTree = new Tree();

        binTree.insert(5);
        binTree.insert(3);
        binTree.insert(7);
        binTree.insert(2);
        binTree.insert(4);
        binTree.insert(6);
        binTree.insert(8);

        binTree.inOrderTrav(binTree.root);

        System.out.println(" ------ > " + binTree.searchNode(binTree.root, 7));
    }
}
