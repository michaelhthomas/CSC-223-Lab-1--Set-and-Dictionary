package utilities;

import java.util.*;

public class ArraySet<E> implements List<E>, Set<E>
{
	protected ArrayList<E> _list;
	// HORRIBLE MERGE CONFLICTS HAHAHA

	public ArraySet()
	{
		_list = new ArrayList<E>();
	}

	@Override
	public boolean add(E arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(E arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(int arg0, E arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends E> arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		_list.clear();
	}

	@Override
	public boolean contains(Object element) {
		for (E item : _list) {
			if (item.equals(element)) return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int intex) {
		return _list.get(intex);
	}

	@Override
	public int indexOf(Object element) {
		return _list.indexOf(element);
	}

	@Override
	public boolean isEmpty() {
		return _list.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object element) {
		int max = 0;
		for (int i = 0; i < _list.size(); i++) {
			if (element.equals(_list.get(i))) max = i;
		}
		return max;
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
		return _list.remove(item);
	}

	@Override
	public E remove(int index) {
		return _list.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		
	}

	@Override
	public E set(int arg0, E arg1) {
		
	}

	@Override
	public int size() {
		
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
