import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

public class ListDictionary<K, V> implements Dictionary<K,V>  {
   private final List<K> keys = new ArrayList<>();
   private final List<V> values = new ArrayList<>();

    @Override
    public Option get(Object key) {
        int index = -1;
        for(int i = 0; i < keys.size(); i ++){
            if(keys.get(i).equals(key)){
                index = i;
            }
        }
        if(index == -1){
            return Option.none();
        }
        return Option.some(values.get(index));
    }

    @Override
    public V get(K key, V defaultValue) {
        int index = -1;
        for(int i = 0; i < keys.size(); i ++){
            if(keys.get(i).equals(key)){
                index = i;
            }
        }
        if(index == -1){
            return defaultValue;
        }
        return values.get(index);
    }

    @Override
    public boolean containsKey(K key) {
        for(int i = 0; i < keys.size(); i++){
            if(keys.get(i).equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean put(K key, V value) {
        if(containsKey(key)){
            return false;
        }
        keys.add((K) key);
        values.add((V) value);
        return true;
    }

    @Override
    public boolean update(K key, V value) {
        if(!containsKey(key)){
            return false;
        }
        int index = keys.indexOf(key);
        values.set(index, (V) value);
        return true;
    }

    @Override
    public void clear(K key) {
        if(containsKey(key)){
            int a = keys.indexOf(key);
            keys.remove(a);
            values.remove(a);
        }
    }

    @Override
    public Stream keyStream() {
        return keys.stream();
    }

    @Override
    public Stream valueStream() {
        return values.stream();
    }
}
