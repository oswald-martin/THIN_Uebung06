package ch.zhaw.thin.gruppe25;

public class Transition {
    private final String curentState;
    private final String wordSymbol;
    private final String stackPopSymbol;
    private final String nextState;
    private final String[] stackPushSymbol;

    public Transition(String curentState, String wordSymbol, String stackPopSymbol, String nextState,
            String[] stackPushSymbol) {
        this.curentState = curentState;
        this.wordSymbol = wordSymbol;
        this.stackPopSymbol = stackPopSymbol;
        this.nextState = nextState;
        this.stackPushSymbol = stackPushSymbol;
    }

    public String getCurentState() {
        return curentState;
    }

    public String getWordSymbol() {
        return wordSymbol;
    }

    public String getStackPopSymbol() {
        return stackPopSymbol;
    }

    public String getNextState() {
        return nextState;
    }

    public String[] getStackPushSymbol() {
        return stackPushSymbol;
    }

}
