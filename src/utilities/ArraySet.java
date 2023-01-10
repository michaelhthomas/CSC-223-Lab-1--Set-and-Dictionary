package utilities;

import java.util.*;

public class ArraySet<E> implements List<E>, Set<E>
{
	protected ArrayList<E> _list;

	public ArraySet()
	{
		_list = new ArrayList<E>();
	}

	@Override
	public boolean add(E item) {
		// Do not add the item if it is already contained in the list
		if (contains(item)) return false;
		// Otherwise, add the item
		_list.add(item);
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> collection) {
		boolean changed = false;
		for (E item : collection) {
			// add the item, update changed if item was added successfully
			if (add(item) == true) 
				changed = true;
		}
		return changed;
	}

	@Override
	public void add(int index, E item) {
		// Do not add the item if it is already contained in the list
		if(contains(item)) return;
		// Otherwise, add the item
		_list.add(index, item);
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> collection) {
		boolean changed = false;
		int i = index;
		for (E item : collection) {
			if (!contains(item)) {
				// we have changed the list
				changed = true;
				add(i, item);
				// increment the index
				i++;
			}
		}
		return changed;
	}

	@Override
	public void clear() {
		// Clears the list of all items
		_list.clear();
	}

	@Override
	public boolean contains(Object element) {
		// Checks if the list contains an item, respectively returning true or false
		return _list.contains(element);
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		return _list.containsAll(collection);
	}

	@Override
	public E get(int index) {
		return _list.get(index);
	}

	@Override
	public int indexOf(Object element) {
		// Gets the index of the specified item and returns it
		return _list.indexOf(element);
	}

	@Override
	public boolean isEmpty() {
		// Checks to see if the list is empty and respectively returns true or false
		return _list.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.Spliterator<E> spliterator() {
		return null;
    }

	@Override
	public int lastIndexOf(Object element) {
		// Finds the last occurrence of the element and returns the index
		return _list.lastIndexOf(element);
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object item) {
		// Removes the specified item and returns true or false respectively
		return _list.remove(item);
	}

	@Override
	public E remove(int index) {
		// Removes the item at the specified index and returns true or false respectively
		return _list.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		boolean changed = false;
		for (Object item : collection) {
			// if the item is removed, the changed boolean is set to true
			if (collection.remove(item) == true) changed = true;
		}
		return changed;
	}

	@Override
	public boolean retainAll(Collection<?> collection) {
		
	}

	@Override
	public E set(int index, E item) {
		// if item is already in the set, do nothing
		if (contains(item)) return null;
		// else we should be ok to set the item
		return _list.set(index, item);
	}

	@Override
	public int size() {
		// Returns the number of elements in the list
		return _list.size();
	}

	@Override
	public List<E> subList(int arg0, int arg1) {
		
	}

	@Override
	public Object[] toArray() {
		
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		
	}
}