package Practice;

class Node {
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
    
}

class LL {

    Node arrtoLL(int[] arr){

        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            mover.next = newNode;
            mover = newNode;
        }

        return head;
    }

    void pristlist(Node head){
        Node temp = head;

        while (temp.next == null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }
    
}


public class LinkedList {

    public static void main(String[] args) {
        int[] arr = {1,4,3,2,5};

        LL list = new LL();

        Node head = list.arrtoLL(arr);
        list.pristlist(head);

        // System.out.println(head);
    }
}

