import java.util.Arrays;

public class StackCalculator {
    public static void main(String[] args) {
        String expression = "50+6*2*1-4+6/2";
        
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack opStack = new ArrayStack(10);

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int op = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";

        while(true) {
            ch = expression.substring(index, index+1).charAt(0);
            if(opStack.isOper(ch)) {
                if(!opStack.isEmpty()) {
                    if(opStack.priority(ch) > opStack.priority(opStack.peekTop())) {
                        opStack.push(ch);
                    }
                    else {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        op = opStack.pop();
                        res = numStack.cal(num1, num2, op);
                        numStack.push(res);
                        opStack.push(ch);
                    }
                }
                else {
                    opStack.push(ch);
                }
            }
            else {
                keepNum += ch;
                if(index == expression.length()-1) {
                    numStack.push(Integer.parseInt(keepNum));
                }
                else {
                    if(opStack.isOper(expression.substring(index+1, index+2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }

            index++;
            if(index >= expression.length()) {
                break;
            }
        }

        while(!opStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            op = opStack.pop();
            res = numStack.cal(num1, num2, op);
            numStack.push(res);
        }

        System.out.printf("%s = %d\n", expression, numStack.pop());
    }
}

class ArrayStack {
    private int top;
    private int maxSize;
    private int[] arrStack;

    public ArrayStack(int size) {
        top = -1;
        maxSize = size;
        arrStack = new int[maxSize];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public int length() {
        return top+1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("Full stack!");
        }
        else {
            top++;
            arrStack[top] = value;
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Empty stack!");
        }
        else {
            int temp = arrStack[top];
            arrStack[top] = 0;
            top--;
            return temp;
        }
    }

    public int peekTop() {
        if (isEmpty()) {
            throw new RuntimeException("Empty stack!");
        }
        else {
            return arrStack[top];
        }
    }

    public void showStack() {
        if (isEmpty()) {
            throw new RuntimeException("Empty stack!");
        }
        else {
            for(int i = 0; i <= top; i++) {
                System.out.printf("Stack[%d] = %d\n", i, arrStack[i]);
            }
        }
    }

    public boolean isOper(int op) {
        return op == '+' || op == '-' || op == '*' || op == '/';
    }

    public int priority(int op) {
        if (op == '*' || op == '/') {
            return 1;
        }
        else if (op == '+' || op == '-') {
            return 0;
        }
        else {
            return -1;
        }
    }

    public int cal(int num1, int num2, int op) {
        int res = 0;
        switch(op) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}