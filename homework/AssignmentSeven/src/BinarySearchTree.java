//---------------------------------------------------------------------------
// BinarySearchTree.java          by Dale/Joyce/Weems               Chapter 7
//
// Defines all constructs for a reference-based BST.
// Supports three traversal orders Preorder, Postorder & Inorder ("natural")
//---------------------------------------------------------------------------


import java.util.*;   // Iterator, Comparator
 

public class BinarySearchTree<T> implements BSTInterface<T>
{
  protected BSTNode<T> root;      // reference to the root of this BST
  protected Comparator<T> comp;   // used for all comparisons

  protected boolean found;   // used by remove

  public BinarySearchTree() 
  // Precondition: T implements Comparable
  // Creates an empty BST object - uses the natural order of elements.
  {
    root = null;
    comp = new Comparator<T>()
    {
       public int compare(T element1, T element2)
       {
         return ((Comparable)element1).compareTo(element2);
       }
    };
  }

  public BinarySearchTree(Comparator<T> comp) 
  // Creates an empty BST object - uses Comparator comp for order
  // of elements.
  {
    root = null;
    this.comp = comp;
  }

  public boolean isFull()
  // Returns false; this link-based BST is never full.
  {
    return false;
  }

  public boolean isEmpty()
  // Returns true if this BST is empty; otherwise, returns false.
  {
    return (root == null);
  }

  public T min()
  // If this BST is empty, returns null;
  // otherwise returns the smallest element of the tree.
  {
    if (isEmpty())
       return null;
    else
    {
       BSTNode<T> node = root;
       while (node.getLeft() != null)
         node = node.getLeft();
       return node.getInfo();
    }
  }

  // Added for #29
  // way easier to pass root as argument
  public T min2(BSTNode<T> node) {
    if (node == null) {
      return null;
    } else if (node.getLeft() == null) {
      return node.getInfo();
    } else {
      return min2(node.getLeft());
    }

  }

  // Added for #30
  // A node is a leaf node if both left and right child nodes of it are null. (bottom row of a tree, basically)
  // iterative
  public int iterLeafCount() {
    if (root == null) {
      return 0;
    }
    int leafCount = 0;
    // Use a stack, like they did for size()
    LinkedStack<BSTNode<T>> stack = new LinkedStack<BSTNode<T>>();
    stack.push(root);
    while(!stack.isEmpty()) {
      BSTNode<T> curr = stack.top();
      stack.pop();
      if(curr.getLeft() != null) {
        stack.push(curr.getLeft());
      }
      if (curr.getRight() != null) {
        stack.push(curr.getRight());
      }
      if (curr.getLeft() == null && curr.getRight() == null) {
        leafCount++;
      }
    }
    return leafCount;
  }

  // recursive
  public int recLeafCount(BSTNode<T> node) {
    if (node == null) {
      return 0;
    }
    if (node.getLeft() == null & node.getRight() == null) {
      return 1;
    } else {
      return recLeafCount(node.getLeft()) + recLeafCount(node.getRight());
    }
  }

  // #31
  
  // recursively counts nodes with 1 child
  public int recOneChild?????????(BSTNode<T> node) {
    if (node == null) {
      return 0;
    }
    int count = 0;
    if ((node.getLeft() == null && node.getRight() != null) || (node.getLeft() != null && node.getRight() == null)) {
      count++;
    }
    count += (recOneChild?????????(node.getLeft()) + recOneChild?????????(node.getRight()));
    return count;
  }

  // iteratively counts nodes with 1 child
  public int iterOneChildPolicy() {
    if (root == null) {
      return 0;
    }
    int count = 0;
    LinkedQueue<BSTNode<T>> q = new LinkedQueue<BSTNode<T>>();
    q.enqueue(root);
    while(!q.isEmpty()) {
      BSTNode<T> node = q.dequeue();
      if ((node.getLeft() == null && node.getRight() != null) || (node.getLeft() != null && node.getRight() == null)) {
        count++;
      }
      if (node.getLeft() != null) {
        q.enqueue(node.getLeft());
      }
      if (node.getRight() != null) {
        q.enqueue(node.getRight());
      }
    }
    return count;
  }

  // #32
  // recursive height
  public int recHeight(BSTNode<T> node) {
    if (node == null) {
      return 0;
    }
    int leftHeight = recHeight(node.getLeft());
    int rightHeight = recHeight(node.getRight());
    return Integer.max(leftHeight, rightHeight) + 1;
  }

  // iterative height
  public int iterHeight() {
    if (root == null) {
      return 0;
    }
    int height = 0;
    LinkedQueue<BSTNode<T>> q = new LinkedQueue<BSTNode<T>>();
    q.enqueue(root);
    while (!q.isEmpty()) {
      int size = q.size();
      while(size > 0) {
        BSTNode<T> front = q.dequeue();

        if (front.getLeft() != null) {
          q.enqueue(front.getLeft());
        }
        if (front.getRight() != null) {
          q.enqueue(front.getRight());
        }
        size--;
      }
      height++;
    }
    return height;
  }

  public T max()
  // If this BST is empty, returns null;
  // otherwise returns the largest element of the tree.
  {
    if (isEmpty())
       return null;
    else
    {
       BSTNode<T> node = root;
       while (node.getRight() != null)
         node = node.getRight();
       return node.getInfo();
    }
  }

  private int recSize(BSTNode<T> node)
  // Returns the number of elements in subtree rooted at node.
  {
    if (node == null)    
      return 0;
    else
      return 1 + recSize(node.getLeft()) + recSize(node.getRight());
  }

  public int size()
  // Returns the number of elements in this BST.
  {
    return recSize(root);
  }

  public int size2()
  // Returns the number of elements in this BST.
  {
    int count = 0;
    if (root != null)
    {
      LinkedStack<BSTNode<T>> nodeStack = new LinkedStack<BSTNode<T>>();
      BSTNode<T> currNode;
      nodeStack.push(root);
      while (!nodeStack.isEmpty())
      {
        currNode = nodeStack.top();
        nodeStack.pop();
        count++;
        if (currNode.getLeft() != null)
          nodeStack.push(currNode.getLeft());
        if (currNode.getRight() != null)
          nodeStack.push(currNode.getRight());
      }
    }
    return count;
  }

  private boolean recContains(T target, BSTNode<T> node)
  // Returns true if the subtree rooted at node contains info i such that 
  // comp.compare(target, i) == 0; otherwise, returns false.
 {
    if (node == null)
      return false;       // target is not found
    else if (comp.compare(target, node.getInfo()) < 0)
      return recContains(target, node.getLeft());   // Search left subtree
    else if (comp.compare(target, node.getInfo()) > 0)
      return recContains(target, node.getRight());  // Search right subtree
    else
      return true;        // target is found
  }

  public boolean contains (T target)
  // Returns true if this BST contains a node with info i such that 
  // comp.compare(target, i) == 0; otherwise, returns false.
  {
    return recContains(target, root);
  }

  
  private T recGet(T target, BSTNode<T> node)
  // Returns info i from the subtree rooted at node such that 
  // comp.compare(target, i) == 0; if no such info exists, returns null.
  {
    if (node == null)
      return null;             // target is not found
    else if (comp.compare(target, node.getInfo()) < 0)
      return recGet(target, node.getLeft());         // get from left subtree
    else
    if (comp.compare(target, node.getInfo()) > 0)
      return recGet(target, node.getRight());        // get from right subtree
    else
      return node.getInfo();  // target is found
  }

  public T get(T target)
  // Returns info i from node of this BST where comp.compare(target, i) == 0;
  // if no such node exists, returns null.
  {
    return recGet(target, root);
  }

  private BSTNode<T> recAdd(T element, BSTNode<T> node)
  // Adds element to tree rooted at node; tree retains its BST property.
  {
    if (node == null)
      // Addition place found
      node = new BSTNode<T>(element);
    else if (comp.compare(element, node.getInfo()) <= 0)
      node.setLeft(recAdd(element, node.getLeft()));    // Add in left subtree
    else
      node.setRight(recAdd(element, node.getRight()));   // Add in right subtree
    return node;
  }

  public boolean add (T element)
  // Adds element to this BST. The tree retains its BST property.
  {
    root = recAdd(element, root);
    return true;
  }

/*
  public boolean add (T element)
  // Adds element to this BST. The tree retains its BST property.
  {
    BSTNode<T> newNode = new BSTNode<T>(element);
    BSTNode<T> prev = null, curr = null;
    
    if (root == null)
      root = newNode;
    else
    {
      curr = root;
      while (curr != null)
      {
        if (comp.compare(element, curr.getInfo()) <= 0)
        {
          prev = curr;
          curr = curr.getLeft();
        }
        else
        {
          prev = curr;
          curr = curr.getRight();
        }
      }
      if (comp.compare(element, prev.getInfo()) <= 0)
        prev.setLeft(newNode);
      else
        prev.setLeft(newNode);
    }
    return true;
  }
*/

  private T getPredecessor(BSTNode<T> subtree)
  // Returns the information held in the rightmost node of subtree
  {
    BSTNode<T> temp = subtree;
    while (temp.getRight() != null)
      temp = temp.getRight();
    return temp.getInfo();
  }

  private BSTNode<T> removeNode(BSTNode<T> node)
  // Removes the information at node from the tree. 
  {
    T data;
    if (node.getLeft() == null)
      return node.getRight();
    else if (node.getRight() == null) 
      return node.getLeft();
    else
    {
      data = getPredecessor(node.getLeft());
      node.setInfo(data);
      node.setLeft(recRemove(data, node.getLeft()));  
      return node;
    }
  }

  private BSTNode<T> recRemove(T target, BSTNode<T> node)
  // Removes element with info i from tree rooted at node such that
  // comp.compare(target, i) == 0 and returns true; 
  // if no such node exists, returns false. 
  {
    if (node == null)
      found = false;
    else if (comp.compare(target, node.getInfo()) < 0)
      node.setLeft(recRemove(target, node.getLeft()));
    else if (comp.compare(target, node.getInfo()) > 0)
      node.setRight(recRemove(target, node.getRight()));
    else  
    {
      node = removeNode(node);
      found = true;
    }
    return node;
  }

  public boolean remove (T target)
  // Removes a node with info i from tree such that comp.compare(target,i) == 0
  // and returns true; if no such node exists, returns false.
  {
    root = recRemove(target, root);
    return found;
  }

  public Iterator<T> getIterator(BSTInterface.Traversal orderType)
  // Creates and returns an Iterator providing a traversal of a "snapshot" 
  // of the current tree in the order indicated by the argument.
  // Supports Preorder, Postorder, and Inorder traversal.
  {
    final LinkedQueue<T> infoQueue = new LinkedQueue<T>();
    if (orderType == BSTInterface.Traversal.Preorder)
      preOrder(root, infoQueue);
    else
    if (orderType == BSTInterface.Traversal.Inorder)
      inOrder(root, infoQueue);
    else
    if (orderType == BSTInterface.Traversal.Postorder)
      postOrder(root, infoQueue);

    return new Iterator<T>()
    {
      public boolean hasNext()
      // Returns true if the iteration has more elements; otherwise returns false.
      {
        return !infoQueue.isEmpty();
      }
      
      public T next()
      // Returns the next element in the iteration.
      // Throws NoSuchElementException - if the iteration has no more elements
      { 
        if (!hasNext())
          throw new IndexOutOfBoundsException("illegal invocation of next " + 
                                     " in BinarySearchTree iterator.\n");
        return infoQueue.dequeue();
      }

      public void remove()
      // Throws UnsupportedOperationException.
      // Not supported. Removal from snapshot iteration is meaningless.
      {
        throw new UnsupportedOperationException("Unsupported remove attempted on " 
                                              + "BinarySearchTree iterator.\n");
      }
    };
  }

  private void preOrder(BSTNode<T> node, LinkedQueue<T> q)
  // Enqueues the elements from the subtree rooted at node into q in preOrder.
  {
    if (node != null)
    {
      q.enqueue(node.getInfo());
      preOrder(node.getLeft(), q);
      preOrder(node.getRight(), q);
    }
  }

  private void inOrder(BSTNode<T> node, LinkedQueue<T> q)
  // Enqueues the elements from the subtree rooted at node into q in inOrder.  
  {
    if (node != null)
    {
      inOrder(node.getLeft(), q);
      q.enqueue(node.getInfo());
      inOrder(node.getRight(), q);
    }
  }

  private void postOrder(BSTNode<T> node, LinkedQueue<T> q)
  // Enqueues the elements from the subtree rooted at node into q in postOrder.  
  {
    if (node != null)
    {
      postOrder(node.getLeft(), q);
      postOrder(node.getRight(), q);
      q.enqueue(node.getInfo());
    }
  }
  
  public Iterator<T> iterator()
  // InOrder is the default, "natural" order.
  {
    return getIterator(BSTInterface.Traversal.Inorder);
  }
}