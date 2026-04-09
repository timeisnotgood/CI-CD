package Practice;

class Node {
    Node prev;
    int data;
    Node next;

    Node(int data){
        this.prev = null;
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

        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
    }

    Node deleteVal(Node head, int val){
        Node temp = head;

        if (temp.data == val) {
            temp = temp.next;
            return temp;
        }

        while (temp != null) {
            if (temp.next.data == val) {
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
        }

        return head;
    }

    Node reverseLL(Node head){
        Node prev = null;
        Node curr = head;

        while(curr != null){
            Node next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    
}


public class LinkedList {

    public static void main(String[] args) {
        int[] arr = {1,4,3,2,5};

        LL list = new LL();

        Node head = list.arrtoLL(arr);
        list.pristlist(head);
        System.out.println();
        System.out.println(" --->  ");

        head = list.deleteVal(head, 1);

        list.pristlist(head);
        System.out.println();
        System.out.println(" --->  ");

        head = list.reverseLL(head);
        list.pristlist(head);

        System.out.println();
        System.out.println(" --->  ");
        // System.out.println(head);
    }
}

