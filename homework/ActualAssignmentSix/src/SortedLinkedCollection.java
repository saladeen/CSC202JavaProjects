public class SortedLinkedCollection<T extends Comparable<T>> implements CollectionInterface<T> {
    private LLNode<T> head;
    private int numElements = 0;

    private boolean found;
    private LLNode<T> location;
    private LLNode<T> previous;

    // Need to rewrite this entire thing
    // add toString()
    // Logic:
    // Duplicate elements ALLOWED
    // Null elements not allowed
    // All elements SORTED IN PLACE

    public SortedLinkedCollection() {
        head = null;
    }

    public boolean find(T target) {
        LLNode<T> curr = head;
        found = false;
        boolean stop = false;
        while(curr != null && !found && !stop) {
            if (curr.getInfo().equals(target)) {
                location = curr;
                found = true;
            } else {
                if(curr.getInfo().compareTo(target) > 0) {
                    stop = true;
                } else {
                    curr = curr.getLink();
                }
            }
        }
        return found;
    }
    
    public boolean add(T element) {
        if (find(element)) {
            return false;
        }
        if (numElements == 0) { // head.equals(null) not allowed, trying numElements == 0;
            LLNode<T> newNode = new LLNode<T>(element);
            newNode.setLink(head);
            head = newNode;
        } else {
            LLNode<T> curr = head;
            LLNode<T> prev = null;
            boolean stop = false;
            while(curr != null && !stop) {
                if (curr.getInfo().compareTo(element) > 0) {
                    stop = true;
                } else {
                    prev = curr;
                    curr = curr.getLink();
                }
            }
            LLNode<T> temp = new LLNode<T>(element);
            if(previous.equals(null)) {
                temp.setLink(head);
                head = temp;

            } else {
                temp.setLink(curr);
                prev.setLink(temp);
            }
        }
        numElements++;
        return true;
    }
    
    public T get(T target) {
        find(target);
        if(found) {
            return location.getInfo();
        } else {
            return null;
        }
    }
    
    public boolean contains(T target) {
        return find(target);
    }
    
    public boolean remove(T target) {
        find(target);
        if (found) {
            if (head == location) {
                head = head.getLink();
            } else {
                previous.setLink(location.getLink());
            }
            numElements--;
        }
        return found;
    }
    
    public boolean isFull() {
        return false;
    }
    
    public boolean isEmpty() {
        return (numElements == 0);
    }
    
    public int size() {
        return numElements;
    }
}
