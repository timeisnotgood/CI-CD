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

    boolean detectCycle(Node head){
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow.data == fast.data){
                return true;
            }
        }
        return false;
    }

    Node rev(Node head){
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

    void middle(Node head){
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("--->  " + slow.data);
    }

    Node mergetwo(Node head_1, Node head_2){
        Node next = head_2;
        Node mover = head_1;
        while (mover != null) {
            if (mover.next == null) {
                mover.next = next;
                return head_1;
            }
            mover = mover.next;
        }

        return mover;
    }

    Node reverseing(Node head){
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

    Node Mid(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle -> " + slow.data);
        return slow;
    }

    Boolean detectCyle(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    Node start(Node head){
        Node slow = head;
        Node fast = head;

        while (true) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        slow = head;

        while (slow == fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    Node MrgTwo(Node l1, Node l2){
        Node dummy = new Node( - 1);
        Node temp = dummy;

        while (temp != null) {
            if (l1.data < l2.data) {
                temp.next = l1;
                l1 = l1.next;
            }else {
                temp.next = l2;
                l2 = l2.next;
            }
        }

        temp.next = (l1 != null) ?l1 : l2;
        
        return dummy;
    }


}


public class LinkedList {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};

        LL list = new LL();
        
        // convert array to Linked List
        Node head = list.arrtoLL(arr);

        // Reverse an LinkedList
        head = list.reverseing(head);

        list.Mid(head);

        System.out.println("-- > " +

        list.detectCyle(head)

        );
    }
}

