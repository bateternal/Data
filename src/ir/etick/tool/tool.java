package ir.etick.tool;

/**
 * Created by abolfazl on 8/8/2017.
 */
public class tool<K,V> {
    private K key;
    private V value;

    public tool(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public V getValue(){
        return value;
    }

    public K getKey(){
        return key;
    }

    public void setKey(K Key){
        this.key = Key;
    }

    public void setValue(V Value){
        this.value = Value;
    }
}
