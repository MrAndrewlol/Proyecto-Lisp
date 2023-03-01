import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> miStack;

    public Stack(){
        miStack = new ArrayList<T>();
    }

    public int count() {
        return miStack.size();
    }

    public boolean isEmpty(){
        return miStack.isEmpty();
    }

    public void push(T value) {
        miStack.add(0, value);
    }

    public T pull(){
        return miStack.remove(0);
    }

    public T peek() {
        return miStack.get(0);
    }
    
}
