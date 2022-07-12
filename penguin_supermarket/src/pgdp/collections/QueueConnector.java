package pgdp.collections;
public class QueueConnector<T> implements DataStructureConnector<T> {
    private final Queue<T> Mylist;
    public QueueConnector(Queue<T> queueu){
        this.Mylist = queueu;
    }
    @Override
    public boolean hasNextElement() {
        return !Mylist.isEmpty();
    }

    @Override
    public void addElement(T obj) {
        Mylist.enqueue(obj);
    }

    @Override
    public T removeNextElement() {
        return Mylist.dequeue();
    }

}