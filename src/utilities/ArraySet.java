/**
* Implements an ArrayList-based set class which wraps an ArrayList and
* adds Set-specific logic.
*
* @author Michael Leiby, Michael Thomas
* @date January 17, 2023
*/

package utilities;

import java.util.*;

public class ArraySet<E> implements List<E>, Set<E>
{
	protected ArrayList<E> _list;

	/*
	 * Creates a new empty ArraySet.
	 */
	public ArraySet() {
		_list = new ArrayList<E>();
	}

	/*
	 * Creates a new ArraySet and pre-populates it with the items in the 
	 * given collection.
	 */
	public ArraySet(Collection<? extends E> collection) {
		this();
		addAll(collection);
	}

	@Override
	public boolean add(E e) {
		// Do not add the e if it is already contained in the list
		if (contains(e)) return false;
		// Otherwise, add the item
		_list.add(e);
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> collection) {
		boolean changed = false;
		for (E e : collection) {
			// add the e, update changed if e was added successfully
			if (add(e) == true) 
				changed = true;
		}
		return changed;
	}

	@Override
	public void add(int index, E e) {
		// Do not add the e if it is already contained in the list
		if(contains(e)) return;
		// Otherwise, add the e
		_list.add(index, e);
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> collection) {
		boolean changed = false;
		int i = index;
		for (E e : collection) {
			if (!contains(e)) {
				// we have changed the list
				changed = true;
				add(i, e);
				// increment the index
				i++;
			}
		}
		return changed;
	}

	@Override
	public void clear() {
		// Clears the list of all es
		_list.clear();
	}

	@Override
	public boolean contains(Object element) {
		// Checks if the list contains an e, respectively returning true or false
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
		// Gets the index of the specified e and returns it
		return _list.indexOf(element);
	}

	@Override
	public boolean isEmpty() {
		// Checks to see if the list is empty and respectively returns true or false
		return _list.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		return _list.iterator();
	}

	@Override
	public java.util.Spliterator<E> spliterator() {
		return _list.spliterator();
	}

	@Override
	public int lastIndexOf(Object element) {
		// Finds the last occurrence of the element and returns the index
		return _list.lastIndexOf(element);
	}

	@Override
	public ListIterator<E> listIterator() {
		return listIterator();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return _list.listIterator(index);
	}

	@Override
	public boolean remove(Object e) {
		// Removes the specified e and returns true or false respectively
		return _list.remove(e);
	}

	@Override
	public E remove(int index) {
		// Removes the e at the specified index and returns true or false respectively
		return _list.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		return _list.removeAll(collection);
	}

	@Override
	public boolean retainAll(Collection<?> collection) {
		return _list.retainAll(collection);
	}

	@Override
	public E set(int index, E element) {
		// if e is already in the set, do nothing
		if (contains(element)) return null;
		// else we should be ok to set the e
		return _list.set(index, element);
	}

	@Override
	public int size() {
		// Returns the number of elements in the list
		return _list.size();
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return _list.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		return _list.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return _list.toArray(a);
	}
}