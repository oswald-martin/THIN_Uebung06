package ch.zhaw.thin.gruppe25;

import java.util.Arrays;

public class StringStack implements Stack<String> {

    private String[] stackArray;
    private final String iss;
    private final String ess;
    private int top;

    public StringStack(String initialStackSymbol, String emptyStringSymbol) {
        this.iss = initialStackSymbol;
        this.ess = emptyStringSymbol;
        this.stackArray = new String[1];
        this.top = 0;
        stackArray[top] = iss;
    }

    @Override
    public boolean isEmpty() {
        return peek().equals(iss);
    }

    @Override
    public String peek() {
        return stackArray[top];
    }

    @Override
    public String pop() {
        String pop = stackArray[top];
        if (top != 0) {
            top--;
        }
        return pop;
    }

    @Override
    public void push(String stringToPush) {
        if (!(iss.equals(stringToPush) || ess.equals(stringToPush))) {
            if (top == stackArray.length - 1) {
                enlargeArray();
            }
            top++;
            stackArray[top] = stringToPush;
        }
    }

    private void enlargeArray() {
        stackArray = Arrays.copyOf(stackArray, stackArray.length * 2);
    }
}
