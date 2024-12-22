package Practice;

import Practice.LinkedLit.Node;

class LinkedLit {
    static class Node {
        int data;
        Node next;
    
        Node(int data){
            this.data = data;
            this.next = null;
        }
    
        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }


    Node ConvertLLtoArr(int arr[]){
        Node head = new Node(arr[0]);
        // Node Mover = head;
        Node Mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node newEle = new Node(arr[i]);
            Mover.next = newEle;
            Mover = newEle;
        }
        return head;
    }



    void getElements( Node head){
        Node temp = head;

        while (temp != null) {
            System.out.println("--> "  + temp.data);
            temp = temp.next;
        }
    }

    int length(Node head){
        Node temp = head;
        int cnt = 0;
        
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        return cnt;
    }

    int Search(Node head, int val){
        Node temp = head;

        while (temp != null) {
            if (temp.data == val) {
                return 1;
            }
            temp = temp.next;
        }

        return 0;
    }

    int searchKey(Node head, int key){
        int length = length(head);
        if (length < key) {
            return 0;
        }

        Node temp = head;
        int position = 0;

        while (temp != null) {
            if (position == key) {
                return temp.data;
            }
            position++;
            temp = temp.next;
        }

        return 0;
    }

    Node DeleteHead(Node head){
        if (head == null || length(head) == 0) {
            return null;    
        }

        Node temp = head;
        temp = temp.next;
        return temp;
    }

    Node Deletetail(Node head){
        if (head == null || length(head) == 0) {
            return null;    
        }

        Node temp = head;
        
        while (temp != null) {
            if (temp.next.next == null) {
                temp.next = null;
            }
            temp = temp.next;
        }
        return temp;
    }



    Node DeleteKey(Node head, int key){
        if (head == null || key > length(head) ) {
            return null;
        }else if (key == 0) {
            return DeleteHead(head);
        }else if (key + 1  == length(head) ) {
            return Deletetail(head);
        }

        Node temp = head;
        Node prev = null;
        int pos = 0;

        while (temp != null) {
            if (pos == key) {
                prev.next = temp.next;
            }
            pos++;
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    Node DeleteValue(Node head, int val){
        if (head == null) {
            return null;
        }

        Node temp = head;
        Node prev = null;

        while (temp != null) {
            if (head.data == val) {
                return DeleteHead(head);
            }
            if (temp.data == val) {
                prev.next = temp.next;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    Node UpdateValue(Node head, int value, int update){
        if (head == null) {
            return null;
        }else if (head.data == value) {
            Node temp = head.next;
            Node newEle = new Node(update);
            newEle.next = temp;
            return newEle;
        }
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (temp.data == value) {
                Node newEle = new Node(update);
                prev.next = newEle;
                newEle.next = temp.next;
                return head;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

}


public class Solution {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        LinkedLit LL = new LinkedLit();
        Node head = LL.ConvertLLtoArr(arr);
        head = LL.DeleteValue(head, 6);
        head = LL.UpdateValue(head, 6, 88);
        LL.getElements(head);
    }
}