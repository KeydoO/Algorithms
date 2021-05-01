public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        DoubleLinkedList list = new DoubleLinkedList();

        System.out.println(list.length());

        list.append(node1);
        list.append(node2);
        //list.append(node3);
        list.append(node4);
        list.append(node5);
        //list.append(node6);

        list.showList();
        System.out.println();

        try {
            list.insertAt(node6, 3);
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }

        list.showList();
        System.out.println();

        try {
            list.insertAt(node3, 8);
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }

        System.out.printf("List's length = %d\n\n", list.length());

        try {
            list.removeAt(4);
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }

        list.showList();
        System.out.println();

        try {
            list.removeAt(10);
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}

class DoubleLinkedList {
    private Node head = new Node(0);
    private Node tail = new Node(0);

    public DoubleLinkedList() {
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }

    public int length() {
        int length = 0;
        if(isEmpty()) {
            length = 0;
        }
        else {
            Node temp = head.next;
            while(temp != tail) {
                length++;
                temp = temp.next;
            }
        }
        return length;
    }

    public void append(Node newNode) {
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;
    }
    
    public void insertAt(Node newNode, int pos) {
        if(pos > length() || pos <= 0) {
            throw new RuntimeException("Unreachable postion!");
        }
        else {
            int count = 0;
            Node temp = head;
            while(count != pos) {
                temp = temp.next;
                count++;
            }
            newNode.next = temp;
            newNode.prev = temp.prev;
            temp.prev.next = newNode;
            temp.prev = newNode;
        }
    }

    public void removeAt(int pos) {
        if(pos > length() || pos <= 0) {
            throw new RuntimeException("Unreachable position!");
        }
        else {
            int count = 0;
            Node temp = head;
            while (count != pos) {
                temp = temp.next;
                count++;
            }
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    public void replaceAt(int pos, Node newNode) {
        if(pos > length() || pos <= 0) {
            throw new RuntimeException("Unreachable position!");
        }
        else {
            int count = 0;
            Node temp = head;
            while(count != pos) {
                temp = temp.next;
                count++;
            }
            newNode.next = temp.next;
            newNode.prev = temp.prev;
            temp.prev.next = newNode;
            temp.next.prev = newNode;
        }
    }

    public int searchAt(int pos) {
        if(pos > length() || pos <= 0) {
            throw new RuntimeException("Unreachable position!");
        }
        else {
            int count = 0;
            Node temp =  head;
            while(count != pos) {
                temp = temp.next;
                count++;
            }
            return temp.data;
        }
    }

    public void showList() {
        if(isEmpty()) {
            throw new RuntimeException("Empty list!");
        }
        else {
            Node temp = head.next;
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
    public Node prev;

    public Node(int element) {
        this.data = element;
    }
}