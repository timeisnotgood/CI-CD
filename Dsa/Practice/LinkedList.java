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

// class LL {

//     Node arrtoLL(int[] arr){
//         Node head = new Node(arr[0]);
//         Node prev = head;

//         for (int i = 1; i < arr.length; i++) {
//             Node next = new Node(arr[i]);
//             prev.next = next;
//             prev = next;
//         }

//         return head;
//     }

//     Node insertHead(Node head, int data){
//         if (head == null) {
//             return new Node(data);
//         }

//         Node prev = new Node(data);
//         prev.next = head;
//         return prev;
//     }

//     Node insertTail(Node head, int data){
//         Node next = new Node(data);
//         if (head == null) {
//             return next;
//         }

//         Node temp = head;

//         while (temp != null) {
//             if (temp.next == null) {
//                 temp.next = next;
//                 return head;
//             }
//             temp = temp.next;
//         };
//         return head;
//     }

//     Node insertPosti(Node head, int pos, int data){
//         if (pos == 1) return insertHead(head, data);

//         Node temp = head;
//         int count = 1;

//         while (temp != null) {
//             Node newNode = new Node(data);
//             if (count == pos - 1) {
//                 newNode.next = temp.next;
//                 temp.next = newNode;
//             }
//             count++;
//             temp = temp.next;
//         }

//         return head;
//     }

//     Node deletehead(Node head){
//         if (head.next == null) {
//             return null;
//         }

//         head = head. next;
//         return head;
//     }

//     Node deleteTail(Node head){
//          if (head.next == null) {
//             return null;
//         }

//         Node temp = head;
//         while (temp != null) {
//             if (temp.next.next == null) {
//                 temp.next = null;
//                 return head;
//             }
//             temp = temp.next;
//         }

//         return head;
//     }
    
//     Node deletePosition(Node head, int pos){
//         if (head.next == null || pos == 1) {
//             return null;
//         }

//         Node temp = head;
//         int count = 1;

//         while (temp != null) {
//             if (count == pos - 1) {
//                 temp.next = temp.next.next;
//             }
//             count++;
//             temp = temp.next;
//         }

//         return head;
//     }

//     Node revrese(Node head){
//         Node prev = null;
//         Node curr = head;

//         while (curr != null) {
//             Node next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//         }

//         return prev;
//     }

//     Node findmid(Node head){
//         if (head.next == null) {
//             return head;
//         }

//         Node slow = head;
//         Node fast = head;

//         while(fast != null && fast.next != null){
//             slow= slow.next;
//             fast = fast.next.next;
//         }

//         return slow;
//     }

//     Boolean detectCycle(Node head){
//          if (head.next == null) {
//             return null;
//         }

//         Node slow = head;
//         Node fast = head;

//         while (fast != null && fast.next != null) {
//             slow= slow.next;
//             fast = fast.next.next;

//             if (slow == fast) {
//                 return true;
//             }
//         }

//         return false;
//     }

//     // Node startOfCycle(Node head){
//     //     if(head.next == null) {
//     //             return head;
//     //     }

//     //     Node slow = head;
//     //     Node fast = head;

//     //     while (true) {
//     //         slow= slow.next;
//     //         fast = fast.next.next;

//     //         if (slow == fast) {
//     //             break;
//     //         }
//     //     }

//     //     slow = head;

//     //     while (slow != fast) {
//     //         slow= slow.next;
//     //         fast = fast.next;
//     //     }

//     //     return slow;
//     // }

//     Node mergeTwoLL(Node l1, Node l2){
//         Node dummy = new Node(-1);
//         Node temp = dummy;

//         while (l1 != null && l2 != null) {
//             if (l1.data < l2.data) {
//                 temp.next = l1;
//                 l1 = l1.next;
//             }else{
//                 temp.next = l2;
//                 l2 = l2.next;
//             }
//             temp = temp.next;
//         }

//         temp.next = (l1 != null) ? l1 : l2;

//         return dummy.next;
//     }



//     void print(Node head){
//         Node temp = head;

//         while (temp != null) {
//             System.out.print(temp.data + " -> ");
//             temp = temp.next;
//         }
//     }

// }

class DoubleLinkedList{

    Node arrtoDLL(int[] arr){
        Node head = new Node(arr[0]);
        Node curr = head;

        for(int i = 1;i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            curr.next = newNode;
            newNode.prev = curr;
            curr = newNode;
        }

        return head;
    }

    Node addToHead(Node head, int data){
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }

        return newNode;
    }

    Node addToTail(Node head, int data){
        Node newNode = new Node(data);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;

        return head;
    }

    Node addToPosition(Node head, int pos, int data){
        if (pos == 1) {
            return addToHead(head, data);
        }

        Node temp = head;
        int count = 1;

        while (temp != null && count < pos - 1) {
            temp = temp.next;
        }

        Node newNode = new Node(data);

        if (temp.next != null) {
            temp.next.prev = newNode;
            temp.prev.next = newNode;
        }

        temp.next = newNode;
        newNode.prev = temp;

        return head;
    }

    Node deleteHead(Node head){
        if (head == null || head.next == null) {
            return null;
        }

        head.prev = null;
        head = head.next;

        return head;
    }

    Node deleteTail(Node head){
        if (head == null || head.next == null) {
            return null;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;

        return head;
    }

    Node deletePosition(Node head, int pos){
        if (head == null || head.next == null) {
            return null;
        }

        Node temp = head;
        int count = 1;

        while (temp != null && count < pos) {
            temp = temp.next;
            count++;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }

        return head;
    }

    Node reverse(Node head){

        Node temp = null;
        Node curr = head;

        while (temp != null) {
            temp = curr.next;
            curr.next = curr.prev;
            curr.prev = curr;

            curr = curr.prev;
        }

        if (temp != null) temp = temp.prev;
        return head;
    }



    void printBackward(Node head){
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }

    void printFrontward(Node tail){
        Node temp = tail;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.prev;
        }
    }


}
public class LinkedList {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};

        DoubleLinkedList list = new DoubleLinkedList();

        Node head = list.arrtoDLL(arr);
        list.printBackward(head);








// {
//         LL list = new LL();
//         // convert array to LinkedList
//         Node head = list.arrtoLL(arr);
//         list.print(head);
//         System.out.println();

//         // insert a value at head
//         head = list.insertHead(head, 6);
//         list.print(head);
//         System.out.println();

//         // insert a value at tail
//         head = list.insertTail(head, 0);
//         list.print(head);
//         System.out.println();


//         // insert a value at position

//         head = list.insertPosti(head, 8, 9);
//         list.print(head);
//         System.out.println();


//         // delete a value at tail

//         head = list.deleteTail(head);
//         list.print(head);
//         System.out.println();

//         // delete a value at head

//         head = list.deletehead(head);
//         list.print(head);
//         System.out.println();


//         // delete a value at position

//         head = list.deletePosition(head, 3);
//         list.print(head);
//         System.out.println();


//         // reverse a value 

//         head = list.revrese(head);
//         list.print(head);
//         System.out.println();


//         // ---------------------------------------------------------------------------


//         // Find middle element of a LinkedList 

//         Node mid = list.findmid(head);
//         System.out.print("Middle element-- >" + mid.data);
//         System.out.println();

//         // Detect the cycle of a LinkedList

//         System.out.print("Is cycle exist ? ---->" + list.detectCycle(head));
//         System.out.println();



//         // // start of the cycle of a LinkedList

//         // System.out.print("Is cycle exist ? ---->" + list.startOfCycle(head));
//         // System.out.println();

//         int[] l1 = {1,2,3};
//         int[] l2 = {4,5,6};

//         Node head1 = list.arrtoLL(l1);
//         Node head2 = list.arrtoLL(l2);

//         Node mergehead = list.mergeTwoLL(head1, head2);

//         list.print(mergehead);
//         System.out.println();
// }

    }
}

