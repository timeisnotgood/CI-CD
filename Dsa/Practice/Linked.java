package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public Node cycleDetection( Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            while (slow == fast) {
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

    void leftRotate(int arr[], int d) {
        // code here
          int temp = arr[0];
          int a = 0;
          while(a < d){
              for(int i = 0; i < arr.length - 1;i++){
                  arr[i] = arr[i + 1];
              }
              arr[arr.length - 1] = temp;
              temp = arr[0];
              a++;
          }
    }

    public int maxSubArray(int[] nums) {
        int maxvalue =nums[0];
        int current = nums[0];


        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            maxvalue = Math.max(current, maxvalue);
        }

        return Integer.MAX_VALUE;
    }

    public int stock(int[] prices){
        if (prices.length == 1) {
            return 0;
        }
        int min_val = Integer.MAX_VALUE;
        int max_val = 0;
       


        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min_val) {
                min_val = prices[i];
            }else{
                max_val = Math.max(max_val, prices[i] - max_val);
            }
        }

        return max_val;
    }

    public void binSort(int[] arr, int d) {
        // code here

        int n = arr.length;
        for (int a = 0; a < d; a++) {
            int temp = arr[0];
            for (int i = 0; i < n - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[n - 1] = temp;
        }

       for (int inn : arr) {
        System.out.print(inn + " ");
       }

    }

    public static boolean isPerfect(int[] arr) {
        // code here
        for(int i = 0;i < arr.length;i++){
            int j = (arr.length - 1) - i;
            if(i == j || i + 1 ==  j) return true;
            if(arr[i] != arr[j]){
                return false;
            }
        }
        return false;
    }

    public void countOfElements(){
        List<Integer> arr = Arrays.asList(10, 1, 2, 8, 4, 5);        
        int x = 5, cnt = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) <= x) {
                cnt++;
            }
        }

        System.out.println("---> " + cnt);
    }

    public void insertAtIndex(int arr[],int sizeOfArray,int index,int element){
        //Your code here, Geeks
        int[] altered = new int[sizeOfArray + 1];
        int j = 0;
        for(int i = 0;i < altered.length;i++){
            if(i == index){
                 altered[i] = element;
            }else{
                altered[i] = arr[j];
                j++;
            }
        }
    }
}
public class Linked {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int d = 2;

        int[] arr = {1, 2, 3, 4, 5};
        list.insertAtIndex(arr,arr.length, 0, 6);

        for(int inn : arr){
            System.out.print(inn + " ");
        }

    }
}