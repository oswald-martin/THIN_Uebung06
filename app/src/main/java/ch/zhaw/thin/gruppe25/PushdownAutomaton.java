package ch.zhaw.thin.gruppe25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PushdownAutomaton implements Automata<String> {
    private final String EMPTY_STRING_SYMBOL;
    private final String ANY_POP_SYMBOL;
    private final String ANY_PUSH_SYMBOL;

    private final List<String> operands = Arrays.asList(new String[] { "+", "-", "x", "/" });

    private final Transition[] transitions;
    private final List<String> acceptingStates;
    private final Stack<String> stack;
    private String currentState;
    private String lastCalculation;

    public PushdownAutomaton(Transition[] transitions, String startState, String initialStackSymbol,
            String[] acceptingStates, String emptyStringSymbol, String anyPopSymbol, String anyPushSymbol) {
        this.EMPTY_STRING_SYMBOL = emptyStringSymbol;
        this.ANY_POP_SYMBOL = anyPopSymbol;
        this.ANY_PUSH_SYMBOL = anyPushSymbol;
        this.transitions = transitions;
        this.currentState = startState;
        this.acceptingStates = Arrays.asList(acceptingStates);
        this.stack = new StringStack(initialStackSymbol, emptyStringSymbol);
    }

    @Override
    public boolean processWord(String wordToProcess) {
        try {
        String wordSymbol = determineWordSymbol(wordToProcess);
        String restOfWord = determinerestOfWord(wordToProcess);
        String stackSymbol = stack.pop();

        for (Transition transition : transitions) {
            if (transition.getCurentState().equals(currentState)
                    && (transition.getWordSymbol().equals(wordSymbol)
                            || transition.getWordSymbol().equals(ANY_PUSH_SYMBOL))
                    && (transition.getStackPopSymbol().equals(stackSymbol)
                            || transition.getStackPopSymbol().equals(ANY_POP_SYMBOL))) {
                for (String symbol : transition.getStackPushSymbol()) {
                    if(operands.contains(wordSymbol)){
                        calculate(stackSymbol, stack.pop(), transition.getWordSymbol());
                        stack.push(lastCalculation);
                     }else 
                     if (symbol.equals(ANY_POP_SYMBOL)) {
                        stack.push(stackSymbol);
                    } else if (symbol.equals(ANY_PUSH_SYMBOL)) {
                        stack.push(wordSymbol);
                    } else {
                        stack.push(symbol);
                    }
                }
                currentState = transition.getNextState();
                processWord(restOfWord);
                break;
            }
        }
        stack.push(lastCalculation);
        return acceptingStates.contains(currentState);
    } catch (Exception e) {
        return false;
    }
    }

    @Override
    public String peekStack() {
        return stack.peek();
    }

    private String determineWordSymbol(String string) {
        String wordChar;
        if (string.length() > 0) {
            wordChar = String.valueOf(string.charAt(0));
        } else {
            wordChar = EMPTY_STRING_SYMBOL;
        }
        return wordChar;
    }

    private String determinerestOfWord(String string) {
        String restOfWord;
        if (string.length() > 1) {
            restOfWord = string.substring(1);
        } else {
            restOfWord = EMPTY_STRING_SYMBOL;
        }
        return restOfWord;
    }

    private void calculate(String symbol_1, String symbol_2, String operand) {
        String result;
        switch (operand) {
        case "+":
            result = "" + (Integer.parseInt(symbol_1) + Integer.parseInt(symbol_2));
            break;
        case "-":
            result = "" + (Integer.parseInt(symbol_1) - Integer.parseInt(symbol_2));
            break;
        case "x":
            result = "" + (Integer.parseInt(symbol_1) * Integer.parseInt(symbol_2));
            break;
        case "/":
            result = "" + (Integer.parseInt(symbol_1) / Integer.parseInt(symbol_2));
            break;
        default:
            result = EMPTY_STRING_SYMBOL;
        }
        lastCalculation = result;
    }
}
