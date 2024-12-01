package Practice;

class stark{
    int arr[] = new int[10];
    int top = -1;

    void push(int x){
        if (top == 9) {
            System.out.println("The memory is full");
        }

        top = top+1;
        arr[top] = x;
    }

    void toparr(){
        System.out.println("arr --> " + arr[top]);
    }

    void pop(){
        if (top == -1) {
            System.out.println("No element to Delete");
        }

        top = top-1;
    }
}


class Quuue {

    int currentsiz = -1;
    int front = -1;
    int rear = -1;
    int size = 10;
    int arr[] = new int[size];

    void push(int data){
        currentsiz = currentsiz +1;
        if (currentsiz == size) {
            System.out.println("Out of Memory");
        }else if (currentsiz == 0) {
            front = 0; rear = 0;
        }else{
            rear = (rear+1)% size;
        }
        arr[rear] = data;
    }

    void topVal(){
        System.out.println("Top most Value  " + arr[front]);
    }

    void pop(){
        front = front + 1;
        System.out.println("Top element is now  " + arr[front]);
    }

}

public class StkNQueue {
    public static void main(String[] args) {
        int arr[] = {4,7,2,9,1,0,4};
       
        Quuue qq = new Quuue();

        for (int i = 0; i < arr.length; i++) {
            qq.push(arr[i]);
        }

        qq.topVal();
        qq.pop();
        qq.pop();
        qq.pop();
        qq.pop();
        qq.topVal();

    }
}
