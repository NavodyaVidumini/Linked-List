package ll;

public class CDLL {

    class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            next = prev = null;
        }
    }

    private Node head = null;

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node last = head.prev;
            last.next = newNode;
            newNode.prev = last;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    public void delete(int data) {
        if (head == null) return;

        Node temp = head;
        do {
            if (temp.data == data) {
                if (temp.next == temp) { // Only one node
                    head = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    if (temp == head) {
                        head = temp.next;
                    }
                }
                return;
            }
            temp = temp.next;
        } while (temp != head);
    }

    public void display() {
        if (head == null) return;

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CDLL cdll = new CDLL();

        cdll.insertAtEnd(10);
        cdll.insertAtEnd(20);
        cdll.insertAtEnd(30);
        cdll.insertAtEnd(40);

        System.out.println("Circular Doubly Linked List:");
        cdll.display();

        cdll.delete(20);
        System.out.println("After deleting 20:");
        cdll.display();

        cdll.delete(10);
        System.out.println("After deleting 10:");
        cdll.display();
    }
}
