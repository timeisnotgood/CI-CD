package DataStructure;

/**
 * InnerLinkedList
 */
class Node {
    int data;
    Node next;

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    Node(int data){
        this.data = data;
        this.next = null;
    }
    
}


public class Linkedlist{


    private static Node convertArrtoLL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }  
        return head;
    }

    private static int LengthOfLL(Node head){
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }

    private static int searchLL(Node head, int val){
        Node temp = head;
        while (temp != null) {
            if (temp.data == val) return temp.data;
            temp = temp.next;
        }
        return 0;
    }


    //  Deleteion in linked list

    public static Node DeleteHead(Node head){
        if (head == null) return head;
        head = head.next;
        return head;
    }

    public static Node lastDelete(Node head){
        if (head == null || head.next == null) return null;

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;

        return head;
    }

    public static Node DeleteanyValue(Node head, int key){
        Node temp = head;

        while (temp != null) {
            if (temp == null || temp.next == null) return head;
            if (temp.data == key) {
                head = head.next;
                return head;
            }
            if (temp.next.data == key){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }

        return head;
    }

    public static Node DeleteanyPosition(Node head, int k){

        if (head == null) return head;

        Node temp = head;
        Node prev = null;
        
        int cnt = 0;
        while (temp != null) {
            cnt ++;
            if (k == 1 && cnt == 1) {
                head = head.next;
                return head;
            }
            if (cnt == k) {
             prev.next = prev.next.next;   
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }


    //------------------------------------------------------------------



    // Insertion in LinkedList---------------------------

    // Insertion in Head

    public static Node insertHead(Node head, int val){
        if (head == null) return head;
        return new Node(val, head);
    }

    // Insertion in Tail

    public static Node InsertTail(Node head, int val){
        Node temp = head;

        while (temp.next != null) {
            if (temp.next.next == null) {
                Node newval = new Node(val);
                temp.next.next = newval;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }

    // Insert in any key

    public static Node insertAnyKey(Node head, int key, int val){
        if (head == null)  return head;

        Node temp = head;
        int cnt = 0;

        while (temp != null) {
            cnt ++;
            if (cnt == key-1) {
                Node newNode = new Node(val, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }

        return head;
    }

    // Insert in any key

    public static Node insertAnyValue(Node head, int val, int el){
        if (head == null) {
            return head;
        }

        Node temp = head;

        while (temp != null) {
            
            if (temp.next.data == val) {
                Node newNode = new Node(el, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }

        return head;
    }

    //----------------------------------------------------


    // Main Function 

    public static void main(String[] args) {
        int[] arr = {3,7,1,8};
        Node head = convertArrtoLL(arr);

        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }

        int l = LengthOfLL(head);

        System.out.println("here --> " + l);
        System.out.println("searchLL --> " + searchLL(head, 3));
    }
}