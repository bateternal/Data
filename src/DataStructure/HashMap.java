package DataStructure;

/**
 * Created by abolfazl on 8/8/2017.
 */
public class HashMap<K,V> implements Map<K,V> {
    @SuppressWarnings("unchecked")
    private tool<K,V>[] tools = new tool[100000];
    private int size;



    @Override
    public int size() {
        return size;
    }

    @Override
    public V put(K key, V value) {
        int index = getIndex(key);
        while (true) {
            if (tools[index] == null) {
                tool<K, V> newEntry = new tool<K, V>(key, value);
                tools[index] = newEntry;
                ++size;
                return null;
            } else if (tools[index].getKey().equals(key)) {
                V oldValue = tools[index].getValue();
                tools[index] = new tool<K, V>(key, value);
                return oldValue;
            } else {
                index = incIndex(index);
            }
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        while (true) {

            if (tools[index] == null) {
                return null;
            } else if (tools[index].getKey().equals(key)) {
                return tools[index].getValue();
            } else {
                index = incIndex(index);

            }
        }
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int incIndex(int index) {
        ++index;
        if (index >= tools.length) {
            index = 0;
        }
        return index;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % tools.length;
    }

}
