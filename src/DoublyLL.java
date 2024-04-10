public class DoublyLL {
    Node head;
    Node tail;
    int size;
    void insert(int data){
        Node newNode = new Node(data);
        if (head == null && tail == null){
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
        size++;
    }

    void insertionAtMiddle(int data, int loc){
        Node node = new Node(data);

        if (head == null){
            head = tail = node;
            size++;
            return;
        }
        if (loc == 1) {
            node.next = head;
            head.previous = node;
            head = node;
            size++;
            return;
        }
        int count = 0;
        Node current = head;
        while (current != null){
            count++;
            if (count == loc) {
                node.next = current;
                node.previous = current.previous;
                current.previous.next = node;
                current.previous = node;
                size++;
            }
            current = current.next;
        }

    }

    void print(){
        if (head == null && tail == null){
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null){
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
}
