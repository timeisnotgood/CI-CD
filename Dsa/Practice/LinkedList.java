package Practice;


class Node{
    int data;
    Node next;
    Node prev;
    Node (int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class LL {

    Node arrtoLL(int[] arr){
        Node head = new Node(arr[0]);
        Node curr = head;

        for (int i = 1; i < arr.length; i++) {
            Node next = new Node(arr[i]);
            curr.next = next;
            curr = next;
        }
        return head;
    }

    Node insertHead(Node head, int data){
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        newNode.next = head;
        return newNode;
    }

    Node insertTail(Node head, int data){
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }


        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        return head;
    }

    Node insertPos(Node head, int pos, int data){
        if (head == null) {
            return null;
        }

        if (pos == 1) return insertHead(head, data);

        Node curr = head;
        int count = 1;

        while (curr != null && count < pos - 1) {
            curr = curr.next;
            count++;
        }

        Node newNode = new Node(data);
        if (curr.next != null) {
            newNode.next = curr.next;
        }
        curr.next = newNode;
        return head;
    }

    Node deleteHead(Node head){
        if (head == null || head.next == null) {
            return null;
        }
        return head.next;
    }

    Node deleteTail(Node head){
        if (head == null || head.next == null) {
            return null;
        }

        Node curr = head;

        while (curr != null) {
            if (curr.next.next == null) {
                curr.next = null;
                return head;
            }
            curr = curr.next;
        }

        return head;
    }

    Node deletePostion(Node head, int pos){
        if (head == null ) {
            return null;
        }

        if (pos == 1) return deleteHead(head);

        Node curr = head;
        int count = 1;


        while (curr != null && count < pos - 1) {
            curr = curr.next;
            count++;
        }

        curr.next = curr.next.next;

        return head;
    }


    // reverse a LL

    Node reverse(Node head){
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // detect cycle

    boolean detectCycle(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow= slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    // find middle

    Node middle(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow= slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    // start of cycle

    Node startofCycle(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow= slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        slow = head;

        if (slow == fast) {
            while (slow != fast) {
                fast = fast.next;
            }

            fast.next = null;
            return;
        }

        while (slow.next != fast.next) {
            slow= slow.next;
            fast = fast.next.next;
        }

        fast.next = null;
    }

    // merge two LL

    Node merge(Node l1, Node l2){
       Node dummy = new Node(0);
       Node tail = dummy;

       while (l1 != null && l2 != null) {
        if (l1.data < l2.data) {
            tail.next = l1;
            l1 = l1.next;
        }else{
            tail.next = l2;
            l2 = l2.next;
        }
       }

       if (l1 != null) tail.next = l1;
       if (l2 != null) tail.next = l2;

       return dummy.next;
    }


    void removeLoop(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != head) {
            if (fast.next == head) {
                fast.next = null;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
    }

    void print(Node head){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }
}



// class DLL {
//     Node arrtoDLL(int[] arr){
        
//     }
// }




public class LinkedList {
    
    public static void main(String[] args) {
        int[] arr = {2,3,5,6};

        LL list = new LL();
        Node head = list.arrtoLL(arr);
        list.print(head);
        System.out.println();

        // Insert head
        head = list.insertHead(head, 1);
        list.print(head);
        System.out.println();

        // Insert head
        head = list.insertTail(head, 7);
        list.print(head);
        System.out.println();

        // Insert head
        head = list.insertPos(head, 4, 4);
        list.print(head);
        System.out.println();

        // Insert head
        head = list.deleteHead(head);
        list.print(head);
        System.out.println();

        // Insert head
        head = list.deleteTail(head);
        list.print(head);
        System.out.println();

        // Insert head
        head = list.deletePostion(head, 3);
        list.print(head);
        System.out.println();


        head = list.reverse(head);
        list.print(head);
        System.out.println();
        
    }
}