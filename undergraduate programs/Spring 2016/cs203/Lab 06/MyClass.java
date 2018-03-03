package Lab;

import java.util.Iterator;

public class MyClass <E> extends MyAbstractList <E> implements MyList<E>{

	public static int Capacity = 16;
	public E[] InfoArray = (E[])new Object[Capacity];

	class Node<E>{
		E element;
		Node<E> next;
		Node(E e){
			e = element;
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	//Add the element into the last 
	@Override
	public void add(E e) {
		add(size, e);
	}


	@Override
	public void add(int index, E e) {
		//Moves elements in the array forward
		for(int i = size - 1 ; i >= index ; i++){
			InfoArray[i + 1] = InfoArray[i];
		}

		//Adds the new element into the new array index
		InfoArray[index] = e;
		
		size++;
	}


	@Override
	public void clear() {
		InfoArray = (E[])new Object[Capacity];
		size = 0;
		System.out.println("Successful cleared the linked list");
	}


	@Override
	public boolean contains(E e) {
		for(int i = 0 ; i < InfoArray.length ; i++){
			if(e.equals(InfoArray[i]))
				return true;
		}
		return false;
	}


	@Override
	public E get(int index) {
		return InfoArray[index];
	}


	@Override
	public int indexOf(E e) {
		for(int i = 0 ; i < InfoArray.length ; i++){
			if(e.equals(InfoArray[i]))
				return i;
		}
		return -1;
	}


	@Override
	public boolean isEmpty() {
		if(size > 0)
			return false;

		return true;
	}


	@Override
	public int lastIndexOf(E e) {
		for(int i = size - 1 ; i >= 0 ; i++){
			if(e.equals(InfoArray[i]))
				return i;
		}
		return -1;
	}


	@Override
	public E remove(int index) {
		E delete = InfoArray[index];
		
		//If we remove something it must have to be shift everything left.
		for(int i = index ; i < InfoArray.length - 1 ; i++){
			InfoArray[i] = InfoArray[ i + 1 ];
		}
		
		InfoArray[index] = null;
		
		size--;
		
		return delete;

	}


	@Override
	public Object set(int index, E e) {
		E temp = InfoArray[index];
		InfoArray[index] = e;
		return temp;
	}


	@Override
	public int size() {
		return size;
	}


}
