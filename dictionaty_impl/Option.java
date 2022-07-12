public class Option<T> {
    private final T obj;
    private Option(T obj){
        this.obj = obj;
    }
    private Option(){
        obj = null;
    }

    public static <T> Option<T> some(T obj){
        return new Option<>(obj);
    }
    public static <T> Option<T> none(){
        return new Option<>();
    }

    public T get() throws Exception {
        if(obj == null){
//            throw new Exception("EmptyOptionException");
            throw new EmptyOptionException("EmptyOptionException");
        }
        return obj;
    }

    public T getOrDefault(T def){
        if(obj == null){
            return def;
        }
        return obj;
    }
    public boolean isNone(){
        return obj == null;
    }
}
