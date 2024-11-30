package Practice;

class Tree {
    int data;
    Tree left, right;

    Tree(int data){
        this.data = data;
    }
}

class BinaryTree{
    Tree root;

    void insert(int val){
        root = insertRec(root, val);
    }

    Tree insertRec(Tree root,int val){
        if (root == null) {
            root = new Tree(val);
            return root;
        }
        if (val < root.data) {
            root.left = insertRec(root.left, val);
        }else if (val > root.data) {
            root.right  = insertRec(root.right, val);
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
            inOrderTraversal(root.left);
            System.out.println(root.data);
            inOrderTraversal(root.right);
        }
    }

    void PostOrderTraversal(Tree root){
        if (root != null) {
            inOrderTraversal(root.left);
            inOrderTraversal(root.right);
            System.out.println(root.data);
        }
    }
}

public class Bine {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int arr[] = {10, 5, 15, 3, 7, 12, 18};


        for (int i = 0; i < arr.length; i++) {
            tree.insert(arr[i]);
        }

        System.out.println("PreOrder ------->");
        tree.preOrderTraversal(tree.root);

        System.out.println("InOrder ------->");
        tree.inOrderTraversal(tree.root);

        System.out.println("PostOrder ------->");
        tree.PostOrderTraversal(tree.root);
    }
}