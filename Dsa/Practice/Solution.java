package Practice;

class Node {
    int data;
    Node next;

    Node(int val){
        this.data = val;
        this.next = null;
    }
}

public class Solution {

    void convertarrLL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 0; i < arr.length; i++) {
            Node newnode = new Node(i);
            mover.next = newnode;
            mover = newnode;
        }
    }

    void reverse(Node head){
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }

    Node cycleDetection(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;

            if (slow == fast) {
                Node entry = head;

                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println("--> Linked List");
    }


}