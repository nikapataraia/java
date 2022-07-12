package pgdp.collections;

public class StackConnector<T> implements DataStructureConnector<T> {
    private final Stack<T> Mystack;
    public StackConnector(Stack<T> stack){
        this.Mystack = stack;
    }

    @Override
    public boolean hasNextElement() {
        return !Mystack.isEmpty();
    }

    @Override
    public void addElement(T obj) {
        Mystack.push(obj);
    }

    @Override
    public T removeNextElement() {
        return Mystack.pop();
    }
}
