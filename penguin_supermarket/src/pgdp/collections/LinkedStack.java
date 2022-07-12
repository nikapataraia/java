package pgdp.collections;

public class LinkedStack<T> implements Stack<T>{
    private List<T> available;
    private int size;

    @Override
    public int size() {
//        List<T> a = available;
//        if(a == null) return 0;
//        int result = 0;
//        while(a.getNext()!=null){
//            a = a.getNext();
//            result++;
//        }
//        return result;
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void push(T obj) {
        if(this.isEmpty()){this.available = new List<>(obj);}
        if(obj!=null){
            List<T> a = this.available;
            available = new List<>(obj);
            this.available.setNext(a);
            size++;
        }
    }


    @Override
    public T pop() {
        if(this.isEmpty())return null;
        List<T> a = this.available;
        available = available.getNext();
        size--;
        return a.getInfo();
    }
}
