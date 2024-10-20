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

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

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

    //---------------------------------------------------

    // Insertion in LinkedList---------------------------

    // Insertion in Head

    public static Node insertHead(Node head, int val){
        if (head == null) return head;
        return new Node(val, head);
    }

    // Insertion in Tail

    public static Node InsertTail(Node head, int val){
        Node temp = head;

        while (temp.next != null) {
            if (temp.next.next == null) {
                Node newval = new Node(val);
                temp.next.next = newval;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }

    // Insert in any key

    public static Node insertAnyKey(Node head, int key, int val){
        if (head == null)  return head;

        Node temp = head;
        int cnt = 0;

        while (temp != null) {
            cnt ++;
            if (cnt == key-1) {
                Node newNode = new Node(val, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }

        return head;
    }

    // Insert in any key

    public static Node insertAnyValue(Node head, int val, int el){
        if (head == null) {
            return head;
        }

        Node temp = head;

        while (temp != null) {
            
            if (temp.next.num == val) {
                Node newNode = new Node(el, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }

        return head;
    }

    //----------------------------------------------------


    public static String isSubset( int a1[], int a2[], int n, int m) {
        
        Hashtable<Integer, Integer> mainArr = new Hashtable<Integer, Integer>();
    
            for (int i = 0; i < n; i++) {
                mainArr.put(i, a1[i]);
            }
    
            Hashtable<Integer, Integer> two = new Hashtable<Integer, Integer>();
    
            for (int i = 0; i < m; i++) {
                if (two.containsKey(a2[i])) {
                    two.put(a2[i], two.get(a2[i]) + 1);
                }else{
                    two.put(a2[i], 1);
                }

                if (!mainArr.containsValue(a2[i])) {
                    return "No";
                }
            }
            return "Yes";
    }


    // Main function--------------------------------------

    public static int peakElement(int[] arr,int n)
    {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            cnt = cnt+1;

            if (cnt == n) {
                System.out.println(i-1 + " " +i);
                if (arr[i-1] < arr[i]) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        
        // int[] arr = {3,5,1,7,2};

        // Node head = conver(arr);
        // head = insertAnyValue(head, 1, 9);
        // Node temp = head;

        // while (temp != null) {
        //     System.out.println("--> " + temp.num);
        //     temp = temp.next;
        // }

        // int a1[] = {11, 7, 1, 13, 21, 3, 7, 3};
        int a2[] = {1,2,3};
        // System.out.println(
        //     isSubset(a1, a2, a1.length, a2.length)
        // );

        System.out.println(
            peakElement(a2, 3)

        );

    }

    // public static void main(String[] args) {
    //     int arr[] = {3,5,7,2,3,5};

    //     HashMap<Integer, Integer> val = new HashMap<Integer, Integer>();

    //     for (int i = 0; i < arr.length; i++) {
    //          if (val.containsKey(arr[i])) {
    //             System.out.println("yes " + arr[i]);
    //             val.put(arr[i], val.get(arr[i]) + 1);
    //         } else {
    //             val.put(arr[i], 1);
    //         }
    //     }

    //     for (Map.Entry<Integer, Integer> entry : val.entrySet()) {
    //         System.out.println(entry.getKey() + ": " + entry.getValue());
    //     }
    // }
}