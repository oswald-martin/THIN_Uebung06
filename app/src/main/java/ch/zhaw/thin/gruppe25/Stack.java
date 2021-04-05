package ch.zhaw.thin.gruppe25;

/**
 * Represents a Stack.
 */
public interface Stack<T> {
    
    /**
     * Tests if the stack is empty.
     * @return true if the stack is empty.
     */
    boolean isEmpty();

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     * @return top most object in the stack.
     */
    T peek();

    /**
     * Removes the object at the top of the stack.
     * @return that object as the value of this function.
     */
    T pop();

    /**
     * Puts an object on top of the stack.
     * @param object to be put on the stack.
     */
    void push(T object);
}
