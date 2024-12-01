package Practice;


class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}

class LinkedList{
    Node convertArrtoLL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            mover.next = newNode;
            mover = newNode;
        }
        return head;
    }

    void getList(Node head){
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    Node insertVal(Node root, int data, int val){
        if (root == null) {
            return root;
        }

        Node temp = root;

        while (temp != null) {
            Node newVal = new Node(data);
            if (temp.data == val ) {
                Node prev = temp;
                Node next = temp.next;
                prev.next = newVal;
                newVal.next = next;
            }
            temp = temp.next;
        }

        return root;
    }
}

public class Linked {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int[] arr = {3,6,1,7,8,9};
        Node head = list.convertArrtoLL(arr);

        System.out.println("Print List"+ head);
        head = list.insertVal(head, 4, 3);
        list.getList(head);
    }
}