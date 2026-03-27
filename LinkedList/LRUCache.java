package LinkedList;

import java.util.HashMap;

class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = this.next = null;
    }
}

// 146. LRU Cache
public class LRUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    Node left = new Node(0, 0);
    Node right = new Node(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public void add(Node node) {
        Node prev = right.prev;
        Node next = right;

        prev.next = next.prev = node;
        node.prev = prev;
        node.next = next;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            remove(map.get(key));
            add(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        map.put(key, new Node(key, value));
        add(map.get(key));
        if (map.size() > capacity) {
            Node lru = left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1)); // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2)); // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1)); // return -1 (not found)
        System.out.println(lRUCache.get(3)); // return 3
        System.out.println(lRUCache.get(4)); // return 4
    }
}