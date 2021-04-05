package ch.zhaw.thin.gruppe25;

public class App {

    private Automata<String> automata;

    public App() {
        setupAutomata();
    }

    public static void main(String[] args) {
        App app = new App();

        //Test a
        System.out.println("Test a");
        app.processWord("34+62+x");
        //Test b
        System.out.println("Test b");
        app.resetAutomata();
        app.processWord("34+x");
        //test c
        System.out.println("Test c");
        app.resetAutomata();
        app.processWord("12+3+45++");
    }

    public void processWord(String wordToProcess) {
        if (automata.processWord(wordToProcess)) {
            System.out.println(true);
            System.out.println(automata.peekStack());
        } else {
            System.out.println(false);
        }
        System.out.println("");
    }

    public void resetAutomata(){
        setupAutomata();
    }

    private void setupAutomata() {
        String[] states = { "q0", "q1", "q2", "q3" };
        String startState = "q0";
        String[] acceptingStates = { "q3" };
        String initialStackSymbol = "$";
        String emptyStringSymbol = "";
        String anyPopSymbol = "*";
        String anyPushSymbol = "#";
        Transition[] transitions = { 
                new Transition("q0", "0", anyPopSymbol, "q0", new String[] { anyPopSymbol, "0" }),
                new Transition("q0", "1", anyPopSymbol, "q0", new String[] { anyPopSymbol, "1" }),
                new Transition("q0", "2", anyPopSymbol, "q0", new String[] { anyPopSymbol, "2" }),
                new Transition("q0", "3", anyPopSymbol, "q0", new String[] { anyPopSymbol, "3" }),
                new Transition("q0", "4", anyPopSymbol, "q0", new String[] { anyPopSymbol, "4" }),
                new Transition("q0", "5", anyPopSymbol, "q0", new String[] { anyPopSymbol, "5" }),
                new Transition("q0", "6", anyPopSymbol, "q0", new String[] { anyPopSymbol, "6" }),
                new Transition("q0", "7", anyPopSymbol, "q0", new String[] { anyPopSymbol, "7" }),
                new Transition("q0", "8", anyPopSymbol, "q0", new String[] { anyPopSymbol, "8" }),
                new Transition("q0", "9", anyPopSymbol, "q0", new String[] { anyPopSymbol, "9" }),

                new Transition("q0", "+", anyPopSymbol, "q1", new String[] { emptyStringSymbol }),
                new Transition("q0", "-", anyPopSymbol, "q1", new String[] { emptyStringSymbol }),
                new Transition("q0", "x", anyPopSymbol, "q1", new String[] { emptyStringSymbol }),
                new Transition("q0", "/", anyPopSymbol, "q1", new String[] { emptyStringSymbol }),

                new Transition("q1", "+", anyPopSymbol, "q1", new String[] { emptyStringSymbol }),
                new Transition("q1", "-", anyPopSymbol, "q1", new String[] { emptyStringSymbol }),
                new Transition("q1", "x", anyPopSymbol, "q1", new String[] { emptyStringSymbol }),
                new Transition("q1", "/", anyPopSymbol, "q1", new String[] { emptyStringSymbol }),

                new Transition("q1", "0", anyPopSymbol, "q0", new String[] { anyPopSymbol, "0" }),
                new Transition("q1", "1", anyPopSymbol, "q0", new String[] { anyPopSymbol, "1" }),
                new Transition("q1", "2", anyPopSymbol, "q0", new String[] { anyPopSymbol, "2" }),
                new Transition("q1", "3", anyPopSymbol, "q0", new String[] { anyPopSymbol, "3" }),
                new Transition("q1", "4", anyPopSymbol, "q0", new String[] { anyPopSymbol, "4" }),
                new Transition("q1", "5", anyPopSymbol, "q0", new String[] { anyPopSymbol, "5" }),
                new Transition("q1", "6", anyPopSymbol, "q0", new String[] { anyPopSymbol, "6" }),
                new Transition("q1", "7", anyPopSymbol, "q0", new String[] { anyPopSymbol, "7" }),
                new Transition("q1", "8", anyPopSymbol, "q0", new String[] { anyPopSymbol, "8" }),
                new Transition("q1", "9", anyPopSymbol, "q0", new String[] { anyPopSymbol, "9" }),

                new Transition("q1", emptyStringSymbol, anyPopSymbol, "q2", new String[] { emptyStringSymbol }),

                new Transition("q2", emptyStringSymbol, initialStackSymbol, "q3", new String[] { initialStackSymbol }) };

        this.automata = new PushdownAutomaton(transitions, startState, initialStackSymbol, acceptingStates,
                emptyStringSymbol, anyPopSymbol, anyPushSymbol);
    }
}
