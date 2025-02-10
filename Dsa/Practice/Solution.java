package Practice;

public class Solution {

    static class Node {
        int data;
        Node next;

        Node(int val){
            this.data = val;
            this.next = null;
        }

        Node(int val, Node next){
            this.data = val;
            this.next = next;
        }

    }

    Node convertArrtoLL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node newVal = new Node(arr[i]);
            mover.next = newVal;
            mover = newVal;
        }

        return head;
    }

    // Insert

    Node InsertHead(Node head, int val){
        if (head == null) {
            return new Node(val);
        }else{
            return new Node(val, head);
        }
    }

    // Update

    Node UpdateVal(Node head, int prevVal, int val){
        if (head == null) {
            System.err.println("Linked List is Empty");
        }

        if (val == head.data) {
            return new Node(val, head.next);
        }
        Node temp = head;
        Node newVal = new Node(val);
        while (temp != null) {
            if (temp.next.data == prevVal) {
                newVal.next = temp.next.next;
                temp.next = newVal;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    // Delete

    Node DeleteValue(Node head, int val){
        if (head == null) {
            System.out.println("No data to delete");
        }

        if (val == head.data) {
            return head.next;
        }

        Node temp = head;

        while (temp != null) {
            if (temp.next.data == val) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    // Print Linked List

    void PrintLL(Node head){
        if (head == null) {
            System.err.println("Linked List is Empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.println(" --> " + temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Solution LinkedList = new Solution();

        int[] ids = {4,8,9,2};

        Node head =  LinkedList.convertArrtoLL(ids);
        head = LinkedList.InsertHead(head, 10);
        head = LinkedList.UpdateVal(head, 8, 18);

        LinkedList.PrintLL(head);
        System.out.println("--------------->");
        head = LinkedList.DeleteValue(head, 9);

        LinkedList.PrintLL(head);

    }
}




// Insert  -- Done
// Delete  -- 
// Update  -- Done