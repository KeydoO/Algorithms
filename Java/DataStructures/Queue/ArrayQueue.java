import java.util.Scanner;

public class ArrayQueue {
    public static void main(String[] args) {
        ArrQueue q = new ArrQueue(5);
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

// define queue class
class ArrQueue {
    private int maxSize;    // max size of the queue
    private int front;      // position before the first element of the queue
    private int rear;       // position of the last element of the queue
    private int[] arr;      // the array used to store elements in the queue
    
    public ArrQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    // whether full
    public boolean isFull() {
        return rear == maxSize - 1;
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
            rear++;
            arr[rear] = n;
        }
    }

    // remove element from the queue
    public int dequeue() {
        if(isEmpty()) {
            throw new RuntimeException("The queue is empty! No elements in the queue!");
        }
        else {
            front++;
            int temp = arr[front];
            arr[front] = 0;
            return temp;
        }
    }

    // print the queue
    public void showQueue() {
        if(isEmpty()) {
            System.out.println("The queue is empty!");
        }
        else {
            for(int i = front+1; i <= rear; i++) {
                System.out.printf("queue[%d] = %d\n", i, arr[i]);
            }
        }
    }

    // print the first element
    public int peekFront() {
        if(isEmpty()) {
            throw new RuntimeException("The queue is empty!");
        }
        else {
            return arr[front+1];
        }
    }

    // return the length of the queue
    public int length() {
        return (rear - front);
    }
}
