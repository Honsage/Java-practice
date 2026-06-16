import java.util.Map;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

public class LRUCache<K, V> implements Cache<K, V> {

    private static final int DEFAULT_CAPACITY = 64;

    private static final float LOAD_FACTOR = 1f;

    private final int capacity;

    // Actual in-memory cache storage with O(1) complexity
    private final LinkedHashMapCache<K, V> cache;

    public LRUCache(int capacity) {
        if (capacity < 1)
            throw new IllegalArgumentException("Capacity must be greater than zero");
        this.capacity = capacity;
        this.cache = new LinkedHashMapCache<>(capacity, LOAD_FACTOR, true);
    }

    public LRUCache() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void put(K key, V value) {
        this.cache.put(key, value);
    }

    @Override
    public V get(K key) {
        if (!this.cache.containsKey(key))
            throw new NoSuchElementException(String.format("There is no key: %s in cache", key));
        return this.cache.get(key);
    }

    @Override
    public boolean containsKey(K key) {
        return this.cache.containsKey(key);
    }

    @Override
    public int size() {
        return this.cache.size();
    }

    public int capacity() {
        return this.capacity;
    }

    private static class LinkedHashMapCache<K, V> extends LinkedHashMap<K, V> {

        private final int capacity;

        public LinkedHashMapCache(int capacity,
                             float loadFactor,
                             boolean accessOrder) {
            super(capacity, loadFactor, accessOrder);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
            return this.size() > this.capacity;
        }
    }
}
