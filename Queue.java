public class Queue {
    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int length;

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void printQueue() {
        Node temp = first;
        while (temp != null) {
            System.out.printf("%d\t", temp.value);
            temp = temp.next;
        }
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }

        length++;
    }

    public Node dequeue() {
        if (length == 0) {
            return null;
        }

        Node temp = first;

        if (length == 1) {

            first = null;
            last = null;

        } else {
            first = first.next;
            temp.next = null;
        }

        length--;
        return temp;
    }

    public void getFirst() {
        System.out.printf("\nFirst: %d", first.value);
    }

    public void getLast() {
        System.out.printf("\nLast: %d", last.value);
    }

    public void getLength() {
        System.out.printf("\nLength: %d", length);
    }

    public static void main(String[] args) {
        Queue queue = new Queue(7);
        queue.enqueue(8);
        queue.dequeue();
        queue.printQueue();
    }

}
