// No.460. LFU Cache
class LFUCache {

        int cap;
	    LinkedHashMap<Integer, Integer> map;
	    LinkedHashMap<Integer, Integer> freqMap;
	    
	    public LFUCache(int capacity) {
	        cap = capacity;
	        map = new LinkedHashMap<Integer, Integer>(capacity) {
                protected boolean removeEldestEntry(Map.Entry en) {
                    return size() > capacity;
                }
	        };
	        freqMap = new LinkedHashMap<>();
	    }
	    
	    public int get(int key) {
	        Integer i = map.get(key);
	        if (i == null) {
	            return -1;
	        }

            refreshMap(key, i);
            refreshFreq(key);

            return i;
	    }
	    
	    public void put(int key, int value) {
	        Integer f = freqMap.get(key);

	        if (f == null && freqMap.size() >= cap) {
                removeLFUorLRU();
	        }
	        
	        refreshMap(key, value);
            refreshFreq(key);
	    }
	    
	    private void refreshFreq(int key) {
	        Integer j = freqMap.get(key);
            freqMap.remove(key);
            freqMap.put(key, j == null ? 1 : j + 1);
	    }
	    
	     private void refreshMap(int key, int val) {
	        map.remove(key);
            map.put(key, val);
	     }
	     
	     private void removeLFUorLRU() {
	         	int min = Integer.MAX_VALUE;
	            int minKey = -1;
	            
	            for (Map.Entry en : freqMap.entrySet()) {
	                int fre = (int)en.getValue();
	                if (fre < min) {
	                    min = fre;
	                    minKey = (int)en.getKey();
	                }
	            }
	            freqMap.remove(minKey);
	            map.remove(minKey);
	     }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
