// package Practice;

// /**
//  * Node
//  */
// class Node {
//     int data;
//     Node next;

//     Node(int data, Node next){
//         this.data = data;
//         this.next = next;
//     }

//     Node(int data){
//         this.data = data;
//         this.next = null;
//     }
// }
// public class Solution {

//     private static Node convertArrtoLL(int[] arr){
//         Node head = new Node(arr[0]);
//         Node mover = head;

//         for (int i = 1; i < arr.length; i++) {
//             Node temp = new Node(arr[i]);
//             mover.next = temp;
//             mover = temp;
//         }
//         return head;
//     }

//     private static void arrIteration(Node head){
//         Node temp = head;
//         while (temp != null) {
//             System.out.println("iter " + temp.data);
//             temp = temp.next;
//         }
//     }

//     private static int length(Node head){
//         Node temp = head;
//         int cnt = 0;
//         while (temp != null) {
//             cnt++;
//             temp = temp.next;
//         }

//         return cnt;
//     }

//     private static int search(Node head, int val){
//         Node temp = head;
//         while (temp != null) {
//             if(temp.data == val) return 1;
//             temp = temp.next;
//         }

//         return 0;
//     }


//     public static void main(String[] args) {
//         Node head = new Node(6);
//         // single value
//         // System.out.println("head "+ head.data);

//         int[] arr = {4,6,1,8};
//         Node arrHead = convertArrtoLL(arr);

//         // System.out.println("arrHead " + arrHead.data);

//         arrIteration(arrHead);

//         //search
//         System.out.println("length - > "+ length(arrHead));
//         System.out.println("find - > "+ search(arrHead, 4));
//     }
    
// }



package Practice;

class Node{
    int num;
    Node next;

    Node(int num, Node next){
        this.num = num;
        this.next = next;
    }

    Node(int num){
        this.num = num;
        this.next = null;
    }
}

public class Solution {

    
    // conver Array to LinkedList
    // req arr[]

    public static Node convertArrtoLL(int arr[]){
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    public static int searchEle(Node head, int el){
        Node temp = head;
        while (temp != null) {
            if (temp.num == el) return 1;
            temp = temp.next;
        }
        return 0;
    }

    public static Node DeleteHead(Node head){
        if (head == null) return head;
        head = head.next;
        return head;
    }

    public static Node lastDelete(Node head){
        if (head == null || head.next == null) return null;

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;

        return head;
    }

    public static Node anyvalue(Node head, int key){
        Node temp = head;

        while (temp != null) {
            if (temp == null || temp.next == null) return head;
            if (temp.num == key) {
                head = head.next;
                return head;
            }
            if (temp.next.num == key){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }

        return head;
    }

    public static Node conver(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static Node anyPosition(Node head, int k){

        if (head == null) return head;

        Node temp = head;
        Node prev = null;
        
        int cnt = 0;



        while (temp != null) {
            cnt ++;
            if (k == 1 && cnt == 1) {
                head = head.next;
                return head;
            }
            if (cnt == k) {
             prev.next = prev.next.next;   
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }


    public static Node insertHead(Node head, int val){
        if (head == null)  return head;

        Node temp = head;
        Node prev = new Node(val);
        head = prev;
        head.next = temp;
        // while (temp != null) {
        //     prev = prev.next;
        // }

        return head;
    }

    public static void main(String[] args) {
        
        int[] arr = {3,5,1,7,2};

        Node head = conver(arr);
        head = insertHead(head, 0);
        head = anyvalue(head, 5);
        Node temp = head;

        while (temp != null) {
            System.out.println("--> " + temp.num);
            temp = temp.next;
        }
    }
}