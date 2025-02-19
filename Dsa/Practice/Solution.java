package Practice;


class Stack {
    int[] data;
    int capacity;
    int size;
    
    Stack(int cap){
        this.capacity = cap;
        this.size = 0;
        this.data = new int[capacity];
    }

    void Push(int val){
        if (size == capacity) {
            System.out.println("Stack error");
        }
        data[size] = val;
        size ++;
    }

    void Pop(){
        if (size == 0) {
            System.out.println("Stack is Empty");
        }
        size --;
    }

    void GetData(){
        for (int i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
    }
}

class Queue{
    int front = -1;
    int rear = -1;
    int[] data;
    int size;
    int capacity;

    Queue(int cap){
        this.capacity = cap;
        this.size = 0;
        this.data = new int[capacity];
    }

    Boolean isEmpty() {return size == 0;};
    Boolean isFull() {return size == capacity;}




    void enqueue(int val){
        if (isFull()) {
            System.out.println("Queue if Bull");
        }else if (rear == -1) {
            front = rear = 0;
        }else{
            rear = (rear +1) % capacity;
        }

        data[rear] = val;
        size ++;
    }

    int dequeue(){
        if (isEmpty()) {
            System.out.println("No element to Delete");
        }
        int deletedVal = data[front];
        front++;
        size --;
        return deletedVal;
    }

    int front(){
        if(isEmpty()){
            System.out.println("No element to Delete");
            return -1;
        }
        return data[front];
    }

    int rear(){
        if(isEmpty()){
            System.out.println("No element to Delete");
            return -1;
        }
        return data[rear];
    }

     // Print queue elements
     public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(data[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

}
public class Solution {

    public static void main(String[] args) {
        System.out.println("\nQueue using Array:");
        Queue queueArray = new Queue(5);
        queueArray.enqueue(10);
        queueArray.enqueue(20);
        queueArray.enqueue(30);
        queueArray.printQueue();
        System.out.println("Dequeued: " + queueArray.dequeue());

        System.out.println("After Dequeue :");
        queueArray.printQueue();

    }

    
}