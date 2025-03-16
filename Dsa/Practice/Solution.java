package Practice;

class Treeee{
    int data;
    Treeee left, right;

    Treeee(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

class BinaryTr {

    Treeee root;

    void insert(int val){
        root = insertRec(root, val);
    }

    Treeee insertRec(Treeee root, int val){
        if (root == null) {
            return new Treeee(val);
        }

        if (val < root.data) {
            root.left = insertRec(root.left, val);
        }else if (val > root.data) {
            root.right = insertRec(root.right, val);
        }

        return root;
    }

    void preOrderTraversal(Treeee root){
        if (root != null) {
            System.out.println("preOrderTraversal -->" + root.data);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    void inOrderTraversal(Treeee root){
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println("inOrderTraversal -->" + root.data);
            inOrderTraversal(root.right);
        }
    }

    void postOrderTraversal(Treeee root){
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println("postOrderTraversal -->" + root.data);
        }
    }
}
public class Solution {
    public static void main(String[] args) {
        BinaryTr tree = new BinaryTr();

        tree.insert(5);
        tree.insert(2);
        tree.insert(4);
        tree.insert(3);
        tree.insert(1);

        tree.preOrderTraversal(tree.root);
        tree.inOrderTraversal(tree.root);
        tree.postOrderTraversal(tree.root);

    }
}