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

    void preOrderTraversal(Tree root){
        if (root != null) {
            System.out.println(root.data);
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
        }
    }

    void inOrderTraversal(Tree node){
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.data + " ");
            inOrderTraversal(node.right);
        }
    }

    void postOrderTraversal(Tree root){
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.data);

        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Inserting nodes into the binary tree
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int value : values) {
            tree.insert(value);
        }

        System.out.println("pre-order Traversal:");
        tree.preOrderTraversal(tree.root);

        System.out.println("In-order Traversal:");
        tree.inOrderTraversal(tree.root);

        System.out.println("Post-order Traversal:");
        tree.postOrderTraversal(tree.root);
    }
}