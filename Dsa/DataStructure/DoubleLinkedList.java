package DataStructure;


class Node {

    int data;
    Node prev;
    Node next;

    Node(int data1, Node next1, Node prev1){
        this.data = data1;
        this.next = next1;
        this.prev = prev1;
    }

    Node(int data1){
        this.data = data1;
        this.next = null;
        this.prev = null;
    }
    
}


public class DoubleLinkedList {


    public static Node convertArrtoDll(int[] arr){

        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }

        return head;
    }

    public static void print(Node head){

        while (head != null) {
            System.out.println(
                "-->  "+
                head.data
            );
            head = head.next;
        }
    }

    // Deletetion in Double LinkedList

    // Delete Head

    public static Node DeleteHead(Node head){
        Node prev = head;
        head = head.next;
        head.prev = null;
        prev.next = null;
        return head;
    }

    // Delete Tail

    public static Node DeleteTail(Node head){
        if (head == null) return head;
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        Node prev = temp.prev;
        prev.next = null;
        temp.prev = null;

        return head;
    }

    // Delete Key

    public static Node DeleteAnyKey(Node head, int k){

        Node kNode = head;
        int cnt = 0;

        while (kNode != null) {
            cnt ++;
            if (cnt == k) break;
            kNode = kNode.next;
        }

        Node prev = kNode.prev;
        Node next = kNode.next;

        if (prev == null && next == null) {
            return null;
        }else if (prev == null) {
            return DeleteHead(head);
        }else if (next == null) {
            return DeleteTail(head);
        }

        prev.next = next;
        next.prev = prev;
        kNode.prev = null;
        kNode.next = null;
        return head;
    }

    // Delete Node

    public static void DeleteNode(Node temp){
        Node prev = temp.prev;
        Node next = temp.next;
        if (next == null) {
            prev.next = null;
            temp.prev = null;
        }

        prev.next = next;
        next.prev = prev;
        temp.prev = null;
        temp.next = null;
    }

    //------------------------------------------------------------------
    
    public static void main(String[] args) {
        int[] arr = {3,6,2,7,1};
        Node head = convertArrtoDll(arr);
        DeleteNode(head.next.next);

        // Iteration
        print(head);
    }
}
