package ch.zhaw.thin.gruppe25;

public interface Automata<T> {
   boolean processWord(String wordToProcess);
   T peekStack();

}
