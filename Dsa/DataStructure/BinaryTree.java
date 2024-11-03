package DataStructure;

class Tree{
    int data;
    Tree left, right;

    Tree(int val){
        this.data = val;
    }
}

public class BinaryTree {
    Tree root;

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

    void inOrderTraversal(Tree node){
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.data + " ");
            inOrderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Inserting nodes into the binary tree
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int value : values) {
            tree.insert(value);
        }

        System.out.println("In-order Traversal:");
        tree.inOrderTraversal(tree.root);  // Output: 20 30 40 50 60 70 80
    }
}