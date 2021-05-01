import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PECalculatorDemo {
    public static void main(String[] args) {
        String infixExpression = "10 + ( ( 2 * 3 ) + 4 - 2 ) / 2 - 5";
        List<String> ieList = getListString(infixExpression);
        System.out.println("Infix expression: " + ieList);

        List<String> peList = getPostfixExpression(ieList);
        System.out.println("Postfix expression: " + peList);

        int res = calculate(peList);
        System.out.printf("%s = %d\n", infixExpression, res);
    }

    public static List<String> getListString(String expression) {
        String[] split = expression.split(" ");
        List<String> list = new ArrayList<String>();
        for(String ele: split) {
            list.add(ele);
        }
        return list;
    }

    public static int calculate(List<String> list) {
        Stack<String> stack = new Stack<String>();
        for(String item: list) {
            if(item.matches("\\d+")) {
                stack.push(item);
            }
            else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")) {
                    res = num1 + num2;
                }
                else if(item.equals("-")) {
                    res = num1 - num2;
                }
                else if(item.equals("*")) {
                    res = num1 * num2;
                }
                else if(item.equals("/")) {
                    res = num1 / num2;
                }
                else {
                    throw new RuntimeException("Invalid operator!");
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static int priority(String op) {
        if (op.equals("*") || op.equals("/")) {
            return 1;
        }
        else if (op.equals("+") || op.equals("-")) {
            return 0;
        }
        else {
            return -1;
        }
    }

    public static List<String> getPostfixExpression(List<String> list) {
        Stack<String> s1 = new Stack<String>(); // store operator
        List<String> s2 = new ArrayList<String>(); // store temporary result

        for(String item: list) {
            if(item.matches("\\d+")) {
                s2.add(item);
            }
            else {
                if(item.equals("(")) {
                    s1.push(item);
                }
                else if(item.equals(")")) {
                    while(!s1.peek().equals("(")) {
                        s2.add(s1.pop());
                    }
                    s1.pop();
                }
                else if(s1.isEmpty() || s1.peek().equals("(") || priority(item) > priority(s1.peek())) {
                    s1.push(item);
                }
                else if(priority(item) <= priority(s1.peek())) {
                    while(!s1.isEmpty() && priority(item) <= priority(s1.peek()) && !s1.peek().equals("(")) {
                        s2.add(s1.pop());
                    }
                    s1.push(item);
                }
            }
            System.out.println();
            System.out.println("s1: " + s1);
            System.out.println("s2: " + s2);
        }
        while(s1.size() != 0) {
            s2.add(s1.pop());
        }

        return s2;
    }
}
