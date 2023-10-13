package AOK;

import java.util.*;

class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, V> cache;
    private final LinkedList<K> accessOrder;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.accessOrder = new LinkedList<>();
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            // Memperbarui urutan akses untuk kunci yang baru digunakan
            accessOrder.remove(key);
            accessOrder.addFirst(key);
            return cache.get(key);
        }
        return null; // Jika kunci tidak ada dalam cache
    }

    public void put(K key, V value) {
        if (cache.size() >= capacity) {
            // Menghapus kunci terakhir (LRU) jika cache sudah penuh
            K lruKey = accessOrder.removeLast();
            cache.remove(lruKey);
        }
        
        // Menambahkan atau memperbarui nilai dalam cache dan urutan akses
        cache.put(key, value);
        accessOrder.addFirst(key);
    }
}
