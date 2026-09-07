class LRUCache {
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head; // Dummy head (Most Recently Used side)
    private final Node tail; // Dummy tail (Least Recently Used side)

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Initialize dummy head and tail to avoid edge cases during pointer manipulation
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        // Move the accessed node to the front (Most Recently Used)
        remove(node);
        insertAtHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update value and move node to the front
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertAtHead(node);
        } else {
            // If at full capacity, evict the least recently used item (node before dummy tail)
            if (map.size() == capacity) {
                Node lru = tail.prev;
                map.remove(lru.key);
                remove(lru);
            }
            // Insert new node at the front
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertAtHead(newNode);
        }
    }

    // Helper: Remove a node from the doubly linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper: Insert a node right after the dummy head (Most Recently Used position)
    private void insertAtHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */