package Lab;

public abstract class MyAbstractList<E> implements MyList<E> {
	
	  protected int size = 0; // The size of the list

	  /** Create a default list */
	  protected MyAbstractList() {
	  }

	  /** Create a list from an array of objects */
	  protected MyAbstractList(E[] objects) {
	    for (int i = 0; i < objects.length; i++)
	      add(objects[i]);
	  }

	  /** Add a new element at the end of this list */
	  public void add(E e) {
	    add(size, e);
	  }

	  /** Return true if this list contains no elements */
	  public boolean isEmpty() {
	    return size == 0;
	  }

	  /** Return the number of elements in this list */
	  public int size() {
	    return size;
	  }

	  /** Remove the first occurrence of the element o from this list.
	   *  Shift any subsequent elements to the left.
	   *  Return true if the element is removed. */
	  public boolean remove(E e) {
	    if (indexOf(e) >= 0) {
	      remove(indexOf(e));
	      return true;
	    }
	    else
	      return false;
	  }
	}