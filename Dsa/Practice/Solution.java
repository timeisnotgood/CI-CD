package Practice;

public class Solution {

    static class Tree {
        int data;
        Tree left, right;

        Tree(int data){
            this.data = data;
        }
    }

    static class BinaryTree {
        Tree root;

        void insert(int data){
            root = insertRec(data, root);
        }

        Tree insertRec(int data, Tree root){
            if (root == null) {
                root = new Tree(data);
                return root;
            }

            if (data < root.data) {
                root.left = insertRec(data, root.left);
            }else if (data > root.data) {
                root.right = insertRec(data, root.right);
            }
            return root;
        }

        void PostOrderTraversal(Tree root){
            if (root != null) {
                PostOrderTraversal(root.left);
                System.out.println("--> " + root.data);
                PostOrderTraversal(root.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree rt = new BinaryTree();

        rt.insert(2);
        rt.insert(3);
        rt.insert(4);
        rt.insert(5);
        rt.insert(1);


        rt.PostOrderTraversal(rt.root);
    }



    
}