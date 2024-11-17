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

import java.util.ArrayList;
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

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int value){
        val = this.val;
        this.left = this.right = null;
    }
    
}

/**
 * InnerSolution
 */
class Stack {
    int top = -1;
    int[] arr = new int[10];

    // Insert in Stach

    void push(int x){
        if (top == 10) System.out.println("memory is full");

        top = top+1;
        arr[top] = x;
    }

    int top(){
        return arr[top];
    }

    void pop(){
        if (top == -1){
            System.out.println("no value in stack");
            return;
        }
        top = top-1;
    }

    int size(){
        if (top == -1) return 0;

        return top + 1;
    }
}

/**
 * Queue
 */
class Queue {

    int currentsiz = -1;
    int arr[] = new int[10];
    int start = -1;
    int end = -1;
    int size = 10;

    void push(int x){
        currentsiz = currentsiz +1;
        if (currentsiz == size) {
            System.out.println("Memory out of size");
            return;
        }else if (currentsiz == 0) {
            start = 0; end = 0;

        }else{
            end = (end+1)% size;
        }

        arr[end] = x;
    }

    void pop(){
        if (currentsiz == -1) {
            System.out.println("no elements in memory to delete");
            return;
        }

        int element = arr[start];

        if (currentsiz == 0) {
            currentsiz = -1; start = -1; end =-1;
        }

        start = start+1;
        currentsiz = currentsiz-1;
    }

    int top(){
        return arr[start];
    }

    int size(){
        return currentsiz +1;
    }
    
}


/**
 * dinner
 */
class dinner {
    int current = -1;
    int start = -1;
    int end = -1;
    int[] arr = new int[10];
    int size = arr.length;

    void push(int x){
        current = current + 1;
        if (current+1 > arr.length) {
            System.out.println("Memory full");
            return;
        }

        if (current == 0) {
            start = 0; end =0;
        }else{
            end = (end +1) % size;
        }
        arr[end] = x;
    }

    int top(){
        return arr[start];
    }

    int size(){
        return current+1;
    }

    void pop(){
        start = start + 1;
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

    public static int adder(int[] arr, int n){
        if (n == 1) return arr[0];
        return Math.min(arr[n-1], adder(arr, n-1));
    }

    public static int recursion(int x){
      if (x < 10) return x;
      return x % 10 + recursion(x / 10);
    }

    public static int powerCcal(int x, int n){
        if (n == 1) return x;
        return x*powerCcal(x, n-1);
    }

    public static void gfSeries(int x){
        System.out.println("fdfg--->" + x);
        if (x == 0) return;
        gfSeries((int)(Math.pow(x-2, 2)-(x-1)));
    }

    public static int recession(TreeNode number){
        if (number.val % 2 == 0) {
            if (number.left != null) {
                recession(number);
                return number.val;
            }else if (number.right != null) {
                recession(number);
                return number.val;
            }
            return number.val;
        }
        return 0;
    }

    public static ArrayList<Integer> SpiralOrderTraversal(TreeNode treee){

        ArrayList result = new ArrayList<>();
        result.add(recession(treee));
        return result;
    }


    public static void main(String[] args) {
        TreeNode treee = new TreeNode(1);
        treee.left = new TreeNode(2);
        treee.right = new TreeNode(3);

        System.out.println(
            SpiralOrderTraversal(treee)
        );
    }
}