package Practice;

class Nod {
    int data;
    Nod next;

    Nod(int data) {
        this.data = data;
        this.next = null;
    }
}
class MyLinkedList {

    Nod convertArrtoLL(int[] arr) {
        if (arr.length == 0) return null;

        Nod head = new Nod(arr[0]);
        Nod mover = head;

        for (int i = 1; i < arr.length; i++) {
            Nod newNod = new Nod(arr[i]);
            mover.next = newNod;
            mover = newNod;
        }

        return head;
    }

    Nod UpdateLL(Nod head, int prev, int newval) {
        if (head == null) {
            return new Nod(newval);
        }

        Nod temp = head;
        while (temp != null) {
            if (temp.data == prev) {
                temp.data = newval;
            }
            temp = temp.next;
        }

        return head;
    }

    void printLL(Nod head) {
        if (head == null) {
            System.out.println("No element to print");
            return;
        }

        Nod temp = head;
        while (temp != null) {
            System.out.print("--> " + temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class Solution {
    public static void main(String[] args) {
        MyLinkedList linkedlist = new MyLinkedList();
        int[] arr = {2, 3, 4, 5, 6, 7};

        Nod head = linkedlist.convertArrtoLL(arr);
        head = linkedlist.UpdateLL(head, 5, 15);

        linkedlist.printLL(head);
    }
}
