class LRUCache {
    // 双链表内部类，可以存储key，value键值对，prev和next分别指向该节点的前后结点。最近使用过的结点放在头部，最近没有使用过的放在尾部
    private class ListNode {
        private int key;
        private int value;
        private ListNode prev;
        private ListNode next;

        public ListNode() {
        }

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    // size是双链表的大小
    private int size;
    private ListNode head;
    private ListNode rear;
    // map存储一个结点的key值和该结点的引用
    private Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new ListNode();
        rear = new ListNode();
        head.next = rear;
        rear.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        // 先在map中查找该key值对应结点的引用
        ListNode node = map.get(key);
        if (node == null) {
            // 如果没找到，说明双链表中没有该结点，返回-1
            return -1;
        }
        // 如果找到了，将该结点移到双链表的头部，并返回结点的value值
        moveToHead(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        // 先在map中查找该key值对应结点的引用
        ListNode node = map.get(key);
        // 如果没找到，说明双链表中没有该结点，新建一个新结点
        if (node == null) {
            ListNode newNode = new ListNode(key, value);
            // 在map中加入该新结点的key值和其引用
            map.put(key, newNode);
            // 将新结点移动到头部
            addToHead(newNode);
            // 如果size大于容量，需要移除尾部不常用的结点，并删除该结点在map中存储的引用
            if (size > capacity) {
                ListNode tail = removeTail();
                map.remove(tail.key);
            }
        } else {
            // 如果找到了，更新该结点的值，并将其移动到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(ListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    private void moveToHead(ListNode node) {
        removeNode(node);
        addToHead(node);
    }

    private ListNode removeTail() {
        ListNode tail = rear.prev;
        removeNode(tail);

        return tail;
    }

    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }
}
