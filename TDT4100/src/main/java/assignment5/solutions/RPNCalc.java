package assignment5.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BinaryOperator;

public class RPNCalc {
    private Stack<Double> stack = new Stack<>();
    private Map<Character, BinaryOperator<Double>> binaryOperators = new HashMap<>();

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
        if (!binaryOperators.containsKey(operation))
            throw new UnsupportedOperationException("This operation has not been defined");

        if (stack.size() < 2)
            return;

        if (stack.peek() == 0) {
            stack.pop();
            return;
        }

        double val2 = stack.pop(), val1 = stack.pop();

        stack.push(binaryOperators.get(operation).apply(val1, val2));
    }

    public boolean addOperator(char operatorChar, BinaryOperator<Double> operator) {
        if (operator == null || binaryOperators.containsKey(operatorChar))
            return false;
        binaryOperators.put(operatorChar, operator);
        return true;
    }

    public void removeOperator(char operatorChar) {
        binaryOperators.remove(operatorChar);
    }
}
