package Practice;


class BinTree {
    int data;
    BinTree left, right;
    
    BinTree(int val){
        this.data = val;
        this.left=this.right = null;
    }
}

public class Solution {
    BinTree root;

    void insert(int val){
        root = insertRec(root, val);
    }

    BinTree insertRec(BinTree root, int val){
        if (root == null) {
            return new BinTree(val);
        }

        if (val < root.data) {
            root.left = insertRec(root.left, val);
        }else if (val > root.data) {
            root.right = insertRec(root.right, val);
        }

        return root;
    }

    void preOrderTraversal(BinTree root){
        if (root != null) {
            System.out.println(" Pre-Order------> "+ root.data);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    void inOrderTraversal(BinTree root){
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(" In-Order------> "+ root.data);
            inOrderTraversal(root.right);
        }
    }

    void postOrderTraversal(BinTree root){
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(" Post-Order------> "+ root.data);
        }
    }

    public static void main(String[] args) {
        Solution tree = new Solution();

        tree.insert(3);
        tree.insert(1);
        tree.insert(4);
        tree.insert(2);

        tree.preOrderTraversal(tree.root);
    }
}