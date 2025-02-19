package assignment3;

import java.util.Stack;

public class RPNCalc {
    private Stack<Double> stack = new Stack<>();

    public void push(Double num) {
        stack.push(num);
    }

    public double pop() {
        if (stack.size() == 0)
            return Double.NaN;
        return stack.pop();
    }

    public double peek(int index) {
        if (stack.size() < index + 1 || index < 0) {
            return Double.NaN;
        }
        return stack.get(stack.size() - index - 1);
    }

    public int getSize() {
        return stack.size();
    }

    public void performOperation(char operation) {
        if (stack.size() < 2)
            return;

        if (stack.peek() == 0) {
            stack.pop();
            return;
        }

        double val2 = stack.pop(), val1 = stack.pop();

        switch (operation) {
            case '+':
                stack.add(val1 + val2);
                break;
            case '-':
                stack.add(val1 - val2);
                break;
            case '*':
                stack.add(val1 * val2);
                break;
            case '/':
                stack.add(val1 / val2);
                break;
            default:
                break;
        }
    }
}
