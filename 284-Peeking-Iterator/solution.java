// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iter;
    Integer pk;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
	    pk = null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(pk == null) 
            pk = iter.next();
        return pk;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer ans = null;
	    if(pk != null) {
	        ans = pk;
	        pk = null;
	    } else {
	        ans = iter.next();
	    }
	    return ans;
	}

	@Override
	public boolean hasNext() {
	    return pk != null || iter.hasNext();
	}
}