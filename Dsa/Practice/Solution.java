package Practice;

public class Solution {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node convertArrtoLL(int arr[]){
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            mover.next = newNode;
            mover = newNode;
        }

        return head;
    }

    void printLL(Node head){
        Node temp = head;
        
        while (temp != null) {
            System.out.println("--> " + temp.data);
        }
    }

    Node reverse(Node head){
        Node prev = null;
        Node cur = head;

        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}