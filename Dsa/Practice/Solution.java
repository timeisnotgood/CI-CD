package Practice;

class Lnode{
    int data;
    Lnode next;
    Lnode(int data){
        this.data = data;
    }
}

class Queue {
    Lnode start, end;
    int size;

    void push(int val){
        Lnode newVal = new Lnode(val);
        if (start == null) {
            start = end = newVal;
        }

        end.next = newVal;
        end = newVal;
    }

    void getAll(){
        Lnode temp = start;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    int getTop(){
        return end.data;
    }
}

public class Solution {

    public static void main(String[] args) {
        Queue q = new Queue();

        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);

        q.getAll();

        System.out.println("------->");
        System.out.println(q.getTop());
    }
}