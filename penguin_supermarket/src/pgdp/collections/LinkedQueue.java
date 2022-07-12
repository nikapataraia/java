package pgdp.collections;

public class LinkedQueue<T> implements Queue<T>{
    private List<T> first;


    @Override
    public int size() {
        if(first == null) return 0;
        int i = 1;
        List<T> a = first;
        while(a.getNext()!=null){
            a = a.getNext();
            i++;
        }
        return i;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void enqueue(T obj) {
        if(obj == null) return;
        List<T> a = new List<>(obj);
        List<T> b = first;
        if(b == null) {
            first = a;
            return;
        }
        while(b.getNext()!=null){
            b = b.getNext();
        }
        b.setNext(a);
    }

    @Override
    public T dequeue() {
        if(isEmpty()) return null;
        List<T> a = first;
        first = first.getNext();
        return a.getInfo();
    }
}

