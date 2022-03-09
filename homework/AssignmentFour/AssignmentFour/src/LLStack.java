// copied parts from BookFiles but only really needed push
public class LLStack<T> {
    LLNode<T> top;

    public LLStack() {
        top = null;
    }

    public void push(T element) {
        LLNode<T> nextNode = new LLNode<T>(element);
        nextNode.setLink(top);
        top = nextNode;
    }
}
