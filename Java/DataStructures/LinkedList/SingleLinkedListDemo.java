public class SingleLinkedListDemo {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        SingleLinkedList list = new SingleLinkedList();

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

        list.reverse();
        list.showList();
    }
}

// define List class
class SingleLinkedList {
    // head node
    private Node head = new Node(0);

    // whether empty
    public boolean isEmpty() {
        return head.next == null;
    }

    // length of the list
    public int length() {
        int length = 0;
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }

    // append a node to the tail of the list
    public void append(Node newNode) {
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // insert a node at somewhere
    public void insertAt(Node newNode, int pos) {
        if(pos > length()+1) {
            throw new RuntimeException("Unreachable position!");
        }
        else {
            int curPos = 0;
            Node temp = head;
            while(curPos != pos-1) {
                temp = temp.next;
                curPos++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // remove the node at somewhere
    public void removeAt(int pos) {
        if(pos > length()) {
            throw new RuntimeException("Unreachable position!");
        }
        else {
            int curPos = 0;
            Node temp = head;
            while(curPos != pos-1) {
                temp = temp.next;
                curPos++;
            }
            temp.next = temp.next.next;
        }
    }

    // replace element at somewhere with new element
    public void replaceAt(int pos, Node newNode) {
        if(pos > length()) {
            throw new RuntimeException("Unreachable position!");
        }
        else {
            int curPos = 0;
            Node temp = head;
            while(curPos != pos-1) {
                temp = temp.next;
                curPos++;
            }
            newNode.next = temp.next.next;
            temp.next = newNode;
        }
    }

    // show element at somewhere
    public int searchAt(int pos) {
        if(pos > length()) {
            throw new RuntimeException("Unreachable position!");
        }
        else {
            int curPos = 0;
            Node temp = head;
            while(curPos != pos) {
                temp = temp.next;
                curPos++;
            }
            return temp.data;
        }
    }

    // reverse the list
    public void reverse() {
        if(length() == 0) {
            throw new RuntimeException("Empty list!");
        }
        else {
            Node newHead = new Node(0);
            Node temp = head;
            
            while(head.next != null) {
                temp = head.next;
                head.next = head.next.next;
                temp.next = newHead.next;
                newHead.next = temp;
            }

            head.next = newHead.next;
        }
    }

    // print the list
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

// define Node class
class Node {
    public int data;
    public Node next;

    public Node(int element) {
        this.data = element;
    }
}
