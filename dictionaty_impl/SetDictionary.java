import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class SetDictionary<K, V> implements Dictionary<K,V> {
    private final Set<Pair<K, V>> entries = new HashSet<>();

    @Override
    public Option get(Object key) {
        for (Pair<K, V> entry : entries) {
            if(entry.first.equals(key)){
                return Option.some(entry.second);
            }
        }
        return Option.none();


    }

    @Override
    public V get(K key, V defaultValue) {
        for(Pair<K,V> entry : entries){
            if(entry.first.equals(key)){
                return entry.second;
            }
        }
        return defaultValue;
    }

    @Override
    public boolean containsKey(Object key) {
        for(Pair entry : entries){
            if(entry.first.equals(key)){
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
        entries.add(new Pair<K,V>((K)key,(V)value));
        return true;
    }

    @Override
    public boolean update(K key, V value) {
        if(!containsKey(key)){
            return false;
        }
        for(Pair entry : entries){
            if(entry.first.equals(key)){
                entry.second = value;
            }
        }
        return true;
    }

    @Override
    public void clear(K key) {
        entries.forEach(element -> {
            if(element.first.equals(key)){
            entries.remove(element);}
        });
    }

    @Override
    public Stream keyStream() {
        Set<K> mykeys = new HashSet<>();
        entries.forEach(element -> {
            mykeys.add(element.first);
        });
        return mykeys.stream();
    }

    @Override
    public Stream valueStream() {
        Set<V> myvalues = new HashSet<>();
        entries.forEach(element -> {
            myvalues.add(element.second);
        });
        return myvalues.stream();
    }
}

