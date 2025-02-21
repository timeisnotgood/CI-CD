package Practice;

class Stack {

    private class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    private Node Top;

    void push(int val){
        Node newNode = new Node(val);
        newNode.next = Top;
        Top = newNode;
    }

    Boolean isEmpty(){return Top == null;};

    int pop(){
        if (isEmpty()) {
            System.out.println("Stack UnderFlow");
        }
        int deleted = Top.data; 
        Top = Top.next;
        return deleted;
    }

    int Peak(){
        if (isEmpty()) {
            System.out.println("Stack UnderFlow");
        }

        return Top.data;
    }

    void printStack(){
        if (isEmpty()) {
            System.out.println("Stack UnderFlow");
        }

        Node temp = Top;
        while (temp != null) {
            System.out.println(" -->" + temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

}

class Queue {
    private class Node {
        int data;
        Node next;
        
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node front, rear;
    void enqueue(int val){
        Node newNode = new Node(val);
        if (rear == null) {
            front = rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
    }

    Boolean isEmpty(){ return rear == null;};

    int Dequeue(){
        if (isEmpty()) {
            System.out.println("queue is empty !!");
        }
        int Deleted = front.data;
        front = front.next;
        return Deleted;
    }

    void printQueue(){
        if (isEmpty()) {
            System.out.println("queue is empty !!");
        }
        Node temp = front;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

public class Solution {

    public static void main(String[] args) {
        // Stack stack = new Stack();

        // stack.push(9);
        // stack.push(5);
        // stack.push(7);
        // stack.push(8);

        // System.out.println("Before Pop : ");
        // stack.printStack();

        Queue queue = new Queue();

        queue.enqueue(5);
        queue.enqueue(4);
        queue.enqueue(7);
        queue.enqueue(2);

        queue.printQueue();
    }
}