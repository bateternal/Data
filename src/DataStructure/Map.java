package DataStructure;

/**
 * Created by abolfazl on 8/8/2017.
 */
public interface Map<K, V>
{
    public V put(K key, V value);
    public V get(K key);
    public V remove(K key);
    public int size();
}
