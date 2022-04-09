public class SortedLinkedCollectionv2<T extends Comparable<T>> implements CollectionInterface<T> {
    private LLNode<T> head;
    private int numElements = 0;

    private boolean found;
    private LLNode<T> location;
    private LLNode<T> previous;

    @Override
    public boolean add(T element) {
        // Search through the list, updating location and previous, until current spot > element

        // Insert before current (at previous?)
        // Special cases:
        // 1. Empty list: just set head
        // 2. Nothing is larger: insert at end
        // 3. First spot (head) is larger than element: set new head, relink
        find(element);
        if (!found) { // if not found, either empty list or nothing is larger: insert at end
            
        }
        return false;
    }
    
    // Look for the last duplicate - search until target > location, then return previous
    public boolean find(T target) {
        location = head;
        found = false;
        while(location != null && !found) {
            if(location.getInfo().compareTo(target) > 0) { // if location info > target
                location = previous;
                found = true;
            }
            previous = location;
            location = location.getLink();
        }
        return found;
    }

    @Override
    public T get(T target) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean contains(T target) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean remove(T target) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean isFull() {
        return false; // never full
    }

    public boolean isEmpty() {
        return (numElements == 0);
    }

    public int size() {
        return numElements;
    }
    
}
