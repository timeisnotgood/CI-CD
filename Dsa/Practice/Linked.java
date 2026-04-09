package Practice;

import java.util.Arrays;
import java.util.List;

class ListNode{
    int data;
    ListNode next;
    ListNode(int data){
        this.data = data;
    }
}

class LinkedListUtil {

    public ListNode arrToLinked(int[] arr){
        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode newVal = new ListNode(arr[i]);
            mover.next = newVal;
            mover = newVal;
        }

        return head;
    }

    public ListNode insertHead(ListNode head, int val){
        ListNode newVal = new ListNode(val);
        newVal.next = head;
        return newVal;
    }

    public ListNode insertEnd(ListNode head, int val){
        ListNode newVal = new ListNode(val);
        ListNode temp = head;

        while (temp != null) {
            if (temp.next == null) {
                temp.next = newVal;
                break;
            }
            temp = temp.next;
        }

        return head;
    }

    public ListNode insertAnyPoistion(ListNode head, int prev, int val){
        ListNode newVal = new ListNode(val);
        ListNode temp = head;

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

    public void listTraversal(ListNode head){
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public ListNode cycleDetection( ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            while (slow == fast) {
                ListNode entry = head;

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
        LinkedListUtil list = new LinkedListUtil();
        int d = 2;

        list.arrToLinked(new int[]{1, 2, 3, 4, 5});

        int[] arr = {1, 2, 3, 4, 5};
        list.insertAtIndex(arr,arr.length, 0, 6);

        for(int inn : arr){
            System.out.print(inn + " ");
        }

    }
}
