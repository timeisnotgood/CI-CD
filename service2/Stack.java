package Practice;

public class Stack {

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

        while (temp == null) {
            System.out.println(" -->" + temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

}