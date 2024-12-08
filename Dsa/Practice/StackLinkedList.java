package Practice;



public class StackLinkedList {

    static class LinkedList {
        int data;
        LinkedList next;
    
        LinkedList(int x) {
            this.data = x;
            this.next = null;
        }
    
    
    }

    LinkedList top;
    int size ;

    StackLinkedList() {
        top = null;
        size = 0;
    }

    void Push(int x){
        LinkedList newNode = new LinkedList(x);
        newNode.next = top;
        top = newNode;
        size += 1;
    }

    void Pop(){
        if (top == null) {
            System.out.println("No element to Delete");
            return;
        }
        top = top.next;
        size -=1;
    }

    int SizeOfStack(){
        if (size == -1) {
            System.out.println("No element in Stack");
            return 0;
        }

        return size;
    }

    void GetStackElements(){
        LinkedList temp = top;

        while (temp != null) {
            System.out.println("--->"+ temp.data);
            temp = temp.next;
        }
    }

    int TopElement(){
        if (top == null) {
            System.out.println("No element to Display");
        }

        return top.data;
    }

    public static void main(String[] args) {
        StackLinkedList stk = new StackLinkedList();

        stk.Push(3);
        stk.Push(4);
        stk.Push(5);

        stk.GetStackElements();

        System.out.println(
            "-----> Top  " +
            stk.TopElement()
        );
    }
}
