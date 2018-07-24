// No.284 Peeking Iterator
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it;
	Integer cur;
	boolean next;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        it = iterator;
	    next = false;
	    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (!next) {
            cur = it.next();
            next = true;
        }
        return cur;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (next) {
	        next = false;
	        return cur;
	    }
	    return it.next();
	}

	@Override
	public boolean hasNext() {
	    if (!next) return it.hasNext();
	    return true;
	}
}
