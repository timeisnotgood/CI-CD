package Practice;


class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}

class LinkedList {

    public Node arrToLinked(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node newVal = new Node(arr[i]);
            mover.next = newVal;
            mover = newVal;
        }

        return head;
    }

    public Node insertHead(Node head, int val){
        Node newVal = new Node(val);
        newVal.next = head;
        return newVal;
    }

    public Node insertEnd(Node head, int val){
        Node newVal = new Node(val);
        Node temp = head;

        while (temp != null) {
            if (temp.next == null) {
                temp.next = newVal;
                break;
            }
            temp = temp.next;
        }

        return head;
    }

    public Node insertAnyPoistion(Node head, int prev, int val){
        Node newVal = new Node(val);
        Node temp = head;

        while (temp != null) {
            if (temp.data == prev) {
                newVal.next = temp.next;
                temp.next = newVal;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public void listTraversal(Node head){
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }

    public Node reverse(Node head){
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

    public int maxSubArray(int[] nums) {
        int maxvalue =nums[0];
        int current = nums[0];


        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            maxvalue = Math.max(current, maxvalue);
        }

        return maxvalue;
    }
}
public class Linked {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // int[] arr = {1,2,3,4,6,7,8};
        // Node head = list.arrToLinked(arr);
        // head = list.insertHead(head, 0);
        // head = list.insertEnd(head, 9);
        // head = list.insertAnyPoistion(head, 4, 5);
        // list.listTraversal(head);
        // head = list.reverse(head);
        // System.out.println();
        // list.listTraversal(head);

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        list.maxSubArray(nums);



        // System.out.println("Print List"+ head);
        // head = list.insertVal(head, 4, 3);
        // list.getList(head);
    }
}