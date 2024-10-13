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
        if (head == null) return head;

        if (k == 1) {
            Node prev = head;
            Node nextNode = head.next;
            nextNode.prev = null;
            prev.next = null;
            return nextNode;
        }

        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt ++;
            if (cnt == k-1) {
                if (temp.next.next == null) {
                    Node prev = temp;
                    Node nex = temp.
                    prev.next = null;
                    break;
                }
                temp.next = temp.next.next;
                temp.next.next.prev = temp;
                break;
            }
            temp = temp.next;
        }

        return head;
    }

    //------------------------------------------------------------------
    
    public static void main(String[] args) {
        int[] arr = {3,6,2,7,1};
        Node head = convertArrtoDll(arr);
        head = DeleteAnyKey(head, 4);

        // Iteration
        print(head);
    }
}
