import java.time.Instant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LRUCache<K, V> implements Cache<K, V> {

    private static final int DEFAULT_CAPACITY = 50;

    private int capacity;

    // Actual in-memory cache storage with O(1) complexity
    private HashMap<K, V> cache;

    // Last usage time; greater is better
    private HashMap<K, Instant> lastUsage;

    public LRUCache(int capacity) {
        if (capacity < 1) throw new IllegalArgumentException("Idiot!!!");
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.lastUsage = new HashMap<>();
    }

    public LRUCache() {
        this(DEFAULT_CAPACITY);
    }

    public void put(K key, V value) {
        if (cache.size() >= this.capacity
                && !cache.containsKey(key)) {
            K keyOfLre = this.keyOfLre();
            cache.remove(keyOfLre);
            lastUsage.remove(keyOfLre);
        }
        lastUsage.put(key, Instant.now());
        cache.put(key, value);
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {
            throw new NoSuchElementException(String.format("Cache has no element with key: %s", key.toString()));
        }
        lastUsage.put(key, Instant.now());
        return cache.get(key);
    }

    // O(capacity) complexity
    private K keyOfLre() {
        Iterator<K> iter = lastUsage.keySet().iterator();
        K keyOfLre = iter.next();
        K cur;
        while (iter.hasNext()) {
            cur = iter.next();
            if (lastUsage.get(keyOfLre).isAfter(lastUsage.get(cur))) {
                keyOfLre = cur;
            }
        }
        return keyOfLre;
    }
}
