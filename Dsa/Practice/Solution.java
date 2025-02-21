package Practice;

class Stack{
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node Top;

    Boolean isEmpty(){return Top == null;};

    void Push(int val){
        Node newNode = new Node(val);
        newNode.next = Top;
        Top = newNode;
    }

    int Pop(){
        if(isEmpty()){
            System.out.println("No element to delete");
        }

        int deleted = Top.data;
        Top = Top.next;
        return deleted;
    }

    int Peak(){
        if(isEmpty()){
            System.out.println("No element to delete");
        }
        return Top.data;
    }

    void printStack(){
        if(isEmpty()){
            System.out.println("No element to delete");
        }

        Node temp = Top;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Queue {
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node front, rear;

    Boolean isEmpty(){return rear == null;};

    void Push(int val){
        Node newNode = new Node(val);
        if (rear == null) {
            front = rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
    }

    int Pop(){
        if (isEmpty()) {
            System.out.println("No element to delete");
        }
        int Deleted = front.data;
        front = front.next;
        return Deleted;
    }

    void printStack(){
        if(isEmpty()){
            System.out.println("No element to delete");
        }

        Node temp = front;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class Solution {

    public static void main(String[] args) {
        // Stack stack = new Stack();
        Queue queue  = new Queue();

        queue.Push(9);
        queue.Push(5);
        queue.Push(7);
        queue.Push(8);

        queue.Pop();

        queue.printStack();
    }
}