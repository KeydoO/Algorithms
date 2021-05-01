public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);
        
        for(int i = 0; i < 15; i++) {
            try {
                stack.push(i);
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println(e.getMessage());
            }
        }

        stack.showStack();
        System.out.printf("Stack length is %d.\n", stack.length());

        int stackTop;
        stackTop = stack.pop();
        System.out.printf("Stack top is %d\n", stackTop);

        stackTop = stack.pop();
        System.out.printf("Stack top is %d\n", stackTop);

        stackTop = stack.pop();
        System.out.printf("Stack top is %d\n", stackTop);

        stackTop = stack.pop();
        System.out.printf("Stack top is %d\n", stackTop);

        stack.showStack();

        for(int i = 8; i >= 0; i--) {
            try {
                stackTop = stack.pop();
                System.out.printf("Stack top is %d\n", stackTop);
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println(e.getMessage());
            }
        }
    }
}

class ArrayStack {
    private int[] arrStack;
    private int maxSize;
    private int top;

    public ArrayStack(int size) {
        maxSize = size;
        arrStack = new int[maxSize];
        top = -1;
    }
    

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize-1;
    }

    public int length() {
        return top+1;
    }

    public void push(int element) {
        if(isFull()) {
            throw new RuntimeException("Full stack!");
        }
        else {
            top++;
            arrStack[top] = element;
        }
    }

    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("Empty stack!");
        }
        else {
            int temp = arrStack[top];
            arrStack[top] = 0;
            top--;
            return temp;
        }
    }

    public void showStack() {
        if(isEmpty()) {
            throw new RuntimeException("Empty stack!");
        }
        else {
            for(int i = 0; i <= top; i++) {
                System.out.printf("Stack[%d] = %d\n", i, arrStack[i]);
            }
        }
    }
}