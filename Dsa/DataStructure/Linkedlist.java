package DataStructure;

/**
 * InnerLinkedList
 */
class Node {
    int data;
    Node next;

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    Node(int data){
        this.data = data;
        this.next = null;
    }
    
}


public class Linkedlist{


    private static Node convertArrtoLL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }  
        return head;
    }

    private static int LengthOfLL(Node head){
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }

    private static int searchLL(Node head, int val){
        Node temp = head;
        while (temp != null) {
            if (temp.data == val) return temp.data;
            temp = temp.next;
        }
        return 0;
    }

    public static Node DeleteHead(Node head){
        if (head == null) return head;
        head = head.next;
        return head;
    }

    public static Node lastDelete(Node head){
        if (head == null || head.next == null) return null;

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;

        return head;
    }

    public static Node anyPosition(Node head, int key){
        Node temp = head;

        while (temp != null) {
            if (temp == null || temp.next == null) return head;
            if (temp.next.data == key){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }

        return head;
    }


    public static void main(String[] args) {
        int[] arr = {3,7,1,8};
        Node head = convertArrtoLL(arr);

        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }

        int l = LengthOfLL(head);

        System.out.println("here --> " + l);
        System.out.println("searchLL --> " + searchLL(head, 3));
    }
}