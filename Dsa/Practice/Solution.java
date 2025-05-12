package Practice;

import java.util.HashSet;
import java.util.Set;

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

     void maxSumarrayKadan(int arr[]){
        int maxSum = 0;
        int currSum = 0;
        
        for(int num : arr){
            currSum += num;
            maxSum = Math.max(currSum, maxSum);
         
             if(currSum < 0){
                 currSum = 0;
             }   
        }
        
        System.out.println("-- > " +  maxSum);
    }

    void maxSumarrayPrefixSum(int arr[], int n){
       int[] result = new int[n];
       result[0] = arr[0];
       for(int i = 1; i < n; i++){
           result[i] = result[i - 1] + arr[i];
       }
       
       for(int num : result){
           System.out.println("--> " + num);
       }
    }

    Boolean ls(int[] arr, int num){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }

    void longestSuccessiveElements(int[] arr){
        int longest = 1;

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            int cnt = 1;

            while (ls(arr, x+1) == true) {
                x = x+1;
                cnt +=1;
            }

            longest = Math.max(longest, cnt);
        }
    }

}