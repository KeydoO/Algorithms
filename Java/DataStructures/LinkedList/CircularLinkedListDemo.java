public class CircularLinkedListDemo {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        for(int i = 1; i <= 7; i++) {
            Node newNode = new Node(i);
            list.append(newNode);
        }
        
        list.showList();
        System.out.println(list.length());

        list.Joseph(1, 2);

        try {
            list.showList();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}

class CircularLinkedList {
    private Node head = null;
    private Node tail = null;

    public boolean isEmpty() {
        return head == null;
    }

    public int length() {
        int length = 0;
        if(isEmpty()) {
            return length;
        }
        else {
            Node temp = head;
            length = 1;
            while(temp.next != head) {
                temp = temp.next;
                length++;
            }
            return length;
        }
    }

    public void append(Node newNode) {
        if(isEmpty()) {
            newNode.next = newNode;
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }

    public void removeAt(int pos) {
        if(isEmpty()) {
            throw new RuntimeException("Empty list!");
        }
        else {
            int cur = 1;
            Node temp = head;
            while(cur != pos-1) {
                temp = temp.next;
                cur++;
            }
            temp.next = temp.next.next;
        }
    }

    public void Joseph(int k, int m) {
        Node temp = head;
        while(temp.data != k) {
            temp = temp.next;
        }
        while(length() != 1) {
            for(int i = 1; i < m-1; i++) {
                temp = temp.next;
            }
            System.out.printf("Number %d is out.\n", temp.next.data);
            temp.next = temp.next.next;
            temp = temp.next;
            head = temp;
        }
        System.out.printf("Number %d is out.\n", temp.data);
        head = null;
    }

    public void showList() {
        if(isEmpty()) {
            throw new RuntimeException("Empty list!");
        }
        else {
            Node temp = head;
            for(int i = 1; i <= length(); i++) {
                System.out.printf("List[%d] = %d\n", i, temp.data);
                temp = temp.next;
            }
        }
    }
}

class Node {
    public int data;
    public Node next;

    public Node(int element) {
        this.data = element;
    }
}