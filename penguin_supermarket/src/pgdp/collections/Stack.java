package pgdp.collections;

public interface Stack<T> extends DataStructure{
    void push(T obj);
    T pop();
}