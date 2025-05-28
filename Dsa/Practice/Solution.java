package Practice;
/**
 * LinkedList
 */
class LinkedLst {
    int data;
    LinkedLst next;

    LinkedLst(int dat){
        this.data = dat;
        this.next = null;
    }

    LinkedLst(int dat, LinkedLst nxt){
        this.data = dat;
        this.next = nxt;
    }
}


class stack {
    int[] stk;
    int cap, top;

    stack(int cap){
        this.cap = cap;
        this.top = 0;
        this.stk = new int[cap];
    }

    void push(int val){
        if (top + 1 == cap) {
            System.out.println("Stack is full");
            return;
        }

        stk[top++] = val;
    }

    void pop(){
        if (top == 0) {
            System.out.println("Stk is empty");
            return;
        }
        top--;
    }
    
}

class queue {
    int[] que;
    int top, end, cap, size;

    queue(int cap){
        this.cap = cap;
        this.top = this.end = -1;
        this.size = 0;
        this.que = new int[cap];
    }

    void push(int val){
        if (size == cap) {
            System.out.println("Queue is full");
            return;
        }else if (top == -1) {
            top = end = 0;
        }else{
            end = (end + 1 ) % 10;
        }

        que[end] = val;
    }

    void pop(){
        if (size == 0) {
            System.out.println("queue is empty");
            return;
        }

        top++;
    }
    
}


class stkLL {

    LinkedLst top;
    int size = 0;

    void push(int val){
       LinkedLst newNode = new LinkedLst(val);
       top.next = newNode;
       top = newNode;
       size++;
    }

    void pop(){
        if (size == 0) {
            System.out.println("stk is empty");
            return;
        }

        this.top = this.top.next;
        size--;
    }
    
}

class queueLL {
    LinkedLst top, end;
    int size = 0;
    
    void push(int val){
        LinkedLst newNode = new LinkedLst(val);

        if (top == null) {
            top = end = newNode;
        }else{
            end.next = newNode;
            end = newNode;
        }
    }
}
public class Solution {

    public static void main(String[] args) {
        System.out.println("sddgf");
    }
}