package Practice;

class Linkedl{
    int data;
    Linkedl next;
    Linkedl(int data){
        this.data = data;
        this.next = null;
    }
}

class stack {
    Linkedl top;

    void push(int data){
        Linkedl newval = new Linkedl(data);
       newval.next = top;
       top = newval;
    }

    void startQueue(){
        Linkedl temp = top;

        while (temp != null) {
            System.out.println("---->" + temp.data);
            temp = temp.next;
        }
    }
}
class Queue{
    Linkedl start, end;

    void push(int val){
        Linkedl newVal = new Linkedl(val);
        if (start == null) {
            start = end = newVal;
        }

        end.next = newVal;
        end = newVal;
    }

    void startQueue(){
        Linkedl temp = start;

        while (temp != null) {
            System.out.println("---->" + temp.data);
            temp = temp.next;
        }
    }

    void endQueue(){
        Linkedl temp = end;

        while (temp != null) {
            System.out.println("---->" + temp.data);
            temp = temp.next;
        }
    }

}

public class Solution {

    public static void main(String[] args) {
        stack ss = new stack();

        ss.push(1);
        ss.push(2);
        ss.push(3);
        ss.push(4);
        ss.push(5);

        ss.startQueue();
    }

    
}