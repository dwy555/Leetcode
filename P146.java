// No.146. LRU Cache
class LRUCache {

    private int size = 0;
    private int capacity;
    private Map<Integer,Integer> map;
    private LinkedList<Integer> q;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        q = new LinkedList<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Integer val = map.get(key);
        if(val == null)return -1;
        change(key);
        return val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key,value);
            change(key);
            return;
        }
        if(size == capacity){
            int k = q.poll();
            map.remove(k);
            size--;
        }
        map.put(key,value);
        q.add(key);
        size++;
    }
    
    public void change(int key){
        q.remove(q.indexOf(key));
        q.add(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
