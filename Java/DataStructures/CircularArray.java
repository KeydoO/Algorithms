import java.util.Scanner;

public class CircularArray {
    public static void main(String[] args) {
        CirArrQueue q = new CirArrQueue(5);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while(loop) {
            System.out.println();
            System.out.println("s(show): print the queue.");
            System.out.println("e(exit): exit the program.");
            System.out.println("a(add): add an element to the queue.");
            System.out.println("r(remove): remove an element from the queue.");
            System.out.println("p(peek): peek the first element of the queue.");
            System.out.println("l(length): show the length of the queue.");

            key = scanner.next().charAt(0);
            switch(key) {
                case 's':
                    q.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("Enter an integer:");
                    int value = scanner.nextInt();
                    q.enqueue(value);
                    break;
                case 'r':
                    try {
                        int res = q.dequeue();
                        System.out.printf("Output: %d\n", res);
                    } catch (Exception e) {
                        //TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    try {
                        int res = q.peekFront();
                        System.out.printf("queue[front] = %d\n", res);
                    } catch (Exception e) {
                        //TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'l':
                    System.out.printf("The length of the queue: %d\n", q.length());
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }

        System.out.println("Exit the program.");
    }
}

// define class Circular Array Queue
class CirArrQueue {
    private int maxSize;    // max size of the queue
    private int front;      // position before the first element of the queue
    private int rear;       // position of the last element of the queue
    private int[] arr;      // the array used to store elements in the queue
    
    public CirArrQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    // whether full
    public boolean isFull() {
        return ((rear+1) % maxSize) == front;
    }

    // whether empty
    public boolean isEmpty() {
        return rear == front;
    }

    // add element to the queue
    public void enqueue(int n) {
        if(isFull()) {
            System.out.println("The queue is full! No room for new element!");
            return;
        }
        else {
            arr[rear] = n;
            rear = (rear+1) % maxSize;
        }
    }

    // remove element from the queue
    public int dequeue() {
        if(isEmpty()) {
            throw new RuntimeException("The queue is empty! No elements in the queue!");
        }
        else {
            int temp = arr[front];
            arr[front] = 0;
            front = (front+1) % maxSize;
            return temp;
        }
    }

    // print the queue
    public void showQueue() {
        if(isEmpty()) {
            System.out.println("The queue is empty!");
        }
        else {
            for(int i = front; i < front+length(); i++) {
                System.out.printf("queue[%d] = %d\n", i%maxSize, arr[i%maxSize]);
            }
        }
    }

    // print the first element
    public int peekFront() {
        if(isEmpty()) {
            throw new RuntimeException("The queue is empty!");
        }
        else {
            return arr[front];
        }
    }

    // return the length of the queue
    public int length() {
        return (rear + maxSize - front) % maxSize;
    }
}