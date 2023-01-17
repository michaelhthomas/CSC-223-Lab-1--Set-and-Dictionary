/**
* 
*
* <p>Bugs: (a list of bugs and / or other problems)
*
* @author Michael Leiby, Michael Thomas
* @date January 17, 2023
*/

package utilities;

import java.util.*;

public class ArraySet<E> implements List<E>, Set<E>
{
	protected ArrayList<E> _list;

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

	/**
	 * Adds the specified element to this set if it is not already present
	 * (optional operation).  More formally, adds the specified element
	 * {@code e} to this set if the set contains no element {@code e2}
	 * such that
	 * {@code Objects.equals(e, e2)}.
	 * If this set already contains the element, the call leaves the set
	 * unchanged and returns {@code false}.  In combination with the
	 * restriction on constructors, this ensures that sets never contain
	 * duplicate elements.
	 *
	 * <p>The stipulation above does not imply that sets must accept all
	 * elements; sets may refuse to add any particular element, including
	 * {@code null}, and throw an exception, as described in the
	 * specification for {@link Collection#add Collection.add}.
	 * Individual set implementations should clearly document any
	 * restrictions on the elements that they may contain.
	 *
	 * @param e element to be added to this set
	 * @return {@code true} if this set did not already contain the specified
	 *         element
	 * @throws UnsupportedOperationException if the {@code add} operation
	 *         is not supported by this set
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this set
	 * @throws NullPointerException if the specified element is null and this
	 *         set does not permit null elements
	 * @throws IllegalArgumentException if some property of the specified element
	 *         prevents it from being added to this set
	 */
	@Override
	public boolean add(E e) {
		// Do not add the e if it is already contained in the list
		if (contains(e)) return false;
		// Otherwise, add the item
		_list.add(e);
		return true;
	}

	/**
	 * Adds all of the elements in the specified collection to this set if
	 * they're not already present (optional operation).  If the specified
	 * collection is also a set, the {@code addAll} operation effectively
	 * modifies this set so that its value is the <i>union</i> of the two
	 * sets.  The behavior of this operation is undefined if the specified
	 * collection is modified while the operation is in progress.
	 *
	 * @param  c collection containing elements to be added to this set
	 * @return {@code true} if this set changed as a result of the call
	 *
	 * @throws ClassCastException if the class of an element of the
	 *         specified collection prevents it from being added to this set
	 * @throws NullPointerException if the specified collection contains one
	 *         or more null elements and this set does not permit null
	 *         elements, or if the specified collection is null
	 * @throws IllegalArgumentException if some property of an element of the
	 *         specified collection prevents it from being added to this set
	 * @see #add(Object)
	 */
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

	/**
	 * Inserts the specified element at the specified position in this list
	 * (optional operation).  Shifts the element currently at that position
	 * (if any) and any subsequent elements to the right (adds one to their
	 * indices).
	 *
	 * @param index index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws UnsupportedOperationException if the {@code add} operation
	 *         is not supported by this list
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this list
	 * @throws NullPointerException if the specified element is null and
	 *         this list does not permit null elements
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *         ({@code index < 0 || index > size()})
	 */
	@Override
	public void add(int index, E e) {
		// Do not add the e if it is already contained in the list
		if(contains(e)) return;
		// Otherwise, add the e
		_list.add(index, e);
	}

	/**
	 * Inserts all of the elements in the specified collection into this
	 * list at the specified position (optional operation).  Shifts the
	 * element currently at that position (if any) and any subsequent
	 * elements to the right (increases their indices).  The new elements
	 * will appear in this list in the order that they are returned by the
	 * specified collection's iterator.  The behavior of this operation is
	 * undefined if the specified collection is modified while the
	 * operation is in progress.  (Note that this will occur if the specified
	 * collection is this list, and it's nonempty.)
	 *
	 * @param index index at which to insert the first element from the
	 *              specified collection
	 * @param c collection containing elements to be added to this list
	 * @return {@code true} if this list changed as a result of the call
	 * @throws UnsupportedOperationException if the {@code addAll} operation
	 *         is not supported by this list
	 * @throws ClassCastException if the class of an element of the specified
	 *         collection prevents it from being added to this list
	 * @throws NullPointerException if the specified collection contains one
	 *         or more null elements and this list does not permit null
	 *         elements, or if the specified collection is null
	 * @throws IllegalArgumentException if some property of an element of the
	 *         specified collection prevents it from being added to this list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *         ({@code index < 0 || index > size()})
	 */
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

	/**
	 * Removes all of the elements from this set (optional operation).
	 * The set will be empty after this call returns.
	 */
	@Override
	public void clear() {
		// Clears the list of all es
		_list.clear();
	}

	/**
	 * Returns {@code true} if this set contains the specified element.
	 * More formally, returns {@code true} if and only if this set
	 * contains an element {@code e} such that
	 * {@code Objects.equals(o, e)}.
	 *
	 * @param o element whose presence in this set is to be tested
	 * @return {@code true} if this set contains the specified element
	 * @throws ClassCastException if the type of the specified element
	 *         is incompatible with this set
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified element is null and this
	 *         set does not permit null elements
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 */
	@Override
	public boolean contains(Object element) {
		// Checks if the list contains an e, respectively returning true or false
		return _list.contains(element);
	}

	/**
	 * Returns {@code true} if this set contains all of the elements of the
	 * specified collection.  If the specified collection is also a set, this
	 * method returns {@code true} if it is a <i>subset</i> of this set.
	 *
	 * @param  c collection to be checked for containment in this set
	 * @return {@code true} if this set contains all of the elements of the
	 *         specified collection
	 * @throws ClassCastException if the types of one or more elements
	 *         in the specified collection are incompatible with this
	 *         set
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified collection contains one
	 *         or more null elements and this set does not permit null
	 *         elements
	 * (<a href="Collection.html#optional-restrictions">optional</a>),
	 *         or if the specified collection is null
	 * @see    #contains(Object)
	 */
	@Override
	public boolean containsAll(Collection<?> collection) {
		return _list.containsAll(collection);
	}

	/**
	 * Returns the element at the specified position in this list.
	 *
	 * @param index index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *         ({@code index < 0 || index >= size()})
	 */
	@Override
	public E get(int index) {
		return _list.get(index);
	}

	/**
	 * Returns the index of the first occurrence of the specified element
	 * in this list, or -1 if this list does not contain the element.
	 * More formally, returns the lowest index {@code i} such that
	 * {@code Objects.equals(o, get(i))},
	 * or -1 if there is no such index.
	 *
	 * @param o element to search for
	 * @return the index of the first occurrence of the specified element in
	 *         this list, or -1 if this list does not contain the element
	 * @throws ClassCastException if the type of the specified element
	 *         is incompatible with this list
	 *         (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified element is null and this
	 *         list does not permit null elements
	 *         (<a href="Collection.html#optional-restrictions">optional</a>)
	 */
	@Override
	public int indexOf(Object element) {
		// Gets the index of the specified e and returns it
		return _list.indexOf(element);
	}

	/**
	 * Returns {@code true} if this set contains no elements.
	 *
	 * @return {@code true} if this set contains no elements
	 */
	@Override
	public boolean isEmpty() {
		// Checks to see if the list is empty and respectively returns true or false
		return _list.isEmpty();
	}

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 *
	 * @return an iterator over the elements in this list in proper sequence
	 */
	@Override
	public Iterator<E> iterator() {
		return _list.iterator();
	}

	/**
	 * Creates a {@link Spliterator} over the elements in this list.
	 *
	 * <p>The {@code Spliterator} reports {@link Spliterator#SIZED} and
	 * {@link Spliterator#ORDERED}.  Implementations should document the
	 * reporting of additional characteristic values.
	 *
	 * @implSpec
	 * The default implementation creates a
	 * <em><a href="Spliterator.html#binding">late-binding</a></em>
	 * spliterator as follows:
	 * <ul>
	 * <li>If the list is an instance of {@link RandomAccess} then the default
	 *     implementation creates a spliterator that traverses elements by
	 *     invoking the method {@link List#get}.  If such invocation results or
	 *     would result in an {@code IndexOutOfBoundsException} then the
	 *     spliterator will <em>fail-fast</em> and throw a
	 *     {@code ConcurrentModificationException}.
	 *     If the list is also an instance of {@link AbstractList} then the
	 *     spliterator will use the list's {@link AbstractList#modCount modCount}
	 *     field to provide additional <em>fail-fast</em> behavior.
	 * <li>Otherwise, the default implementation creates a spliterator from the
	 *     list's {@code Iterator}.  The spliterator inherits the
	 *     <em>fail-fast</em> of the list's iterator.
	 * </ul>
	 *
	 * @implNote
	 * The created {@code Spliterator} additionally reports
	 * {@link Spliterator#SUBSIZED}.
	 *
	 * @return a {@code Spliterator} over the elements in this list
	 * @since 1.8
	 */
	@Override
	public java.util.Spliterator<E> spliterator() {
		return _list.spliterator();
	}

	/**
	 * Returns the index of the last occurrence of the specified element
	 * in this list, or -1 if this list does not contain the element.
	 * More formally, returns the highest index {@code i} such that
	 * {@code Objects.equals(o, get(i))},
	 * or -1 if there is no such index.
	 *
	 * @param o element to search for
	 * @return the index of the last occurrence of the specified element in
	 *         this list, or -1 if this list does not contain the element
	 * @throws ClassCastException if the type of the specified element
	 *         is incompatible with this list
	 *         (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified element is null and this
	 *         list does not permit null elements
	 *         (<a href="Collection.html#optional-restrictions">optional</a>)
	 */
	@Override
	public int lastIndexOf(Object element) {
		// Finds the last occurrence of the element and returns the index
		return _list.lastIndexOf(element);
	}

	/**
	 * Returns a list iterator over the elements in this list (in proper
	 * sequence).
	 *
	 * @return a list iterator over the elements in this list (in proper
	 *         sequence)
	 */
	@Override
	public ListIterator<E> listIterator() {
		return listIterator();
	}

	/**
	 * Returns a list iterator over the elements in this list (in proper
	 * sequence), starting at the specified position in the list.
	 * The specified index indicates the first element that would be
	 * returned by an initial call to {@link ListIterator#next next}.
	 * An initial call to {@link ListIterator#previous previous} would
	 * return the element with the specified index minus one.
	 *
	 * @param index index of the first element to be returned from the
	 *        list iterator (by a call to {@link ListIterator#next next})
	 * @return a list iterator over the elements in this list (in proper
	 *         sequence), starting at the specified position in the list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *         ({@code index < 0 || index > size()})
	 */
	@Override
	public ListIterator<E> listIterator(int index) {
		return _list.listIterator(index);
	}

	/**
	 * Removes the first occurrence of the specified element from this list,
	 * if it is present (optional operation).  If this list does not contain
	 * the element, it is unchanged.  More formally, removes the element with
	 * the lowest index {@code i} such that
	 * {@code Objects.equals(o, get(i))}
	 * (if such an element exists).  Returns {@code true} if this list
	 * contained the specified element (or equivalently, if this list changed
	 * as a result of the call).
	 *
	 * @param o element to be removed from this list, if present
	 * @return {@code true} if this list contained the specified element
	 * @throws ClassCastException if the type of the specified element
	 *         is incompatible with this list
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified element is null and this
	 *         list does not permit null elements
	 * (<a href="Collection.html#optional-restrictions">optional</a>) {@code remove} operation
	 *         is not supported by this list
	 */
	@Override
	public boolean remove(Object e) {
		// Removes the specified e and returns true or false respectively
		return _list.remove(e);
	}

	/**
	 * Removes the element at the specified position in this list (optional
	 * operation).  Shifts any subsequent elements to the left (subtracts one
	 * from their indices).  Returns the element that was removed from the
	 * list.
	 *
	 * @param index the index of the element to be removed
	 * @return the element previously at the specified position
	 * @throws UnsupportedOperationException if the {@code remove} operation
	 *         is not supported by this list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *         ({@code index < 0 || index >= size()})
	 */
	@Override
	public E remove(int index) {
		// Removes the e at the specified index and returns true or false respectively
		return _list.remove(index);
	}

	/**
	 * Removes from this list all of its elements that are contained in the
	 * specified collection (optional operation).
	 *
	 * @param c collection containing elements to be removed from this list
	 * @return {@code true} if this list changed as a result of the call
	 * @throws UnsupportedOperationException if the {@code removeAll} operation
	 *         is not supported by this list
	 * @throws ClassCastException if the class of an element of this list
	 *         is incompatible with the specified collection
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if this list contains a null element and the
	 *         specified collection does not permit null elements
	 *         (<a href="Collection.html#optional-restrictions">optional</a>),
	 *         or if the specified collection is null
	 * @see #remove(Object)
	 * @see #contains(Object)
	 */
	@Override
	public boolean removeAll(Collection<?> collection) {
		return _list.removeAll(collection);
	}

	/**
	 * Retains only the elements in this list that are contained in the
	 * specified collection (optional operation).  In other words, removes
	 * from this list all of its elements that are not contained in the
	 * specified collection.
	 *
	 * @param c collection containing elements to be retained in this list
	 * @return {@code true} if this list changed as a result of the call
	 * @throws UnsupportedOperationException if the {@code retainAll} operation
	 *         is not supported by this list
	 * @throws ClassCastException if the class of an element of this list
	 *         is incompatible with the specified collection
	 * (<a href="Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if this list contains a null element and the
	 *         specified collection does not permit null elements
	 *         (<a href="Collection.html#optional-restrictions">optional</a>),
	 *         or if the specified collection is null
	 * @see #remove(Object)
	 * @see #contains(Object)
	 */
	@Override
	public boolean retainAll(Collection<?> collection) {
		return _list.retainAll(collection);
	}

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element (optional operation).
	 *
	 * @param index index of the element to replace
	 * @param element element to be stored at the specified position
	 * @return the element previously at the specified position
	 * @throws UnsupportedOperationException if the {@code set} operation
	 *         is not supported by this list
	 * @throws ClassCastException if the class of the specified element
	 *         prevents it from being added to this list
	 * @throws NullPointerException if the specified element is null and
	 *         this list does not permit null elements
	 * @throws IllegalArgumentException if some property of the specified
	 *         element prevents it from being added to this list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 *         ({@code index < 0 || index >= size()})
	 */
	@Override
	public E set(int index, E element) {
		// if e is already in the set, do nothing
		if (contains(element)) return null;
		// else we should be ok to set the e
		return _list.set(index, element);
	}

	/**
	 * Returns the number of elements in this set (its cardinality).  If this
	 * set contains more than {@code Integer.MAX_VALUE} elements, returns
	 * {@code Integer.MAX_VALUE}.
	 *
	 * @return the number of elements in this set (its cardinality)
	 */
	@Override
	public int size() {
		// Returns the number of elements in the list
		return _list.size();
	}

	/**
	 * Returns a view of the portion of this list between the specified
	 * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.  (If
	 * {@code fromIndex} and {@code toIndex} are equal, the returned list is
	 * empty.)  The returned list is backed by this list, so non-structural
	 * changes in the returned list are reflected in this list, and vice-versa.
	 * The returned list supports all of the optional list operations supported
	 * by this list.<p>
	 *
	 * This method eliminates the need for explicit range operations (of
	 * the sort that commonly exist for arrays).  Any operation that expects
	 * a list can be used as a range operation by passing a subList view
	 * instead of a whole list.  For example, the following idiom
	 * removes a range of elements from a list:
	 * <pre>{@code
	 *      list.subList(from, to).clear();
	 * }</pre>
	 * Similar idioms may be constructed for {@code indexOf} and
	 * {@code lastIndexOf}, and all of the algorithms in the
	 * {@code Collections} class can be applied to a subList.<p>
	 *
	 * The semantics of the list returned by this method become undefined if
	 * the backing list (i.e., this list) is <i>structurally modified</i> in
	 * any way other than via the returned list.  (Structural modifications are
	 * those that change the size of this list, or otherwise perturb it in such
	 * a fashion that iterations in progress may yield incorrect results.)
	 *
	 * @param fromIndex low endpoint (inclusive) of the subList
	 * @param toIndex high endpoint (exclusive) of the subList
	 * @return a view of the specified range within this list
	 * @throws IndexOutOfBoundsException for an illegal endpoint index value
	 *         ({@code fromIndex < 0 || toIndex > size ||
	 *         fromIndex > toIndex})
	 */
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return _list.subList(fromIndex, toIndex);
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence (from first to last element).
	 *
	 * <p>The returned array will be "safe" in that no references to it are
	 * maintained by this list.  (In other words, this method must
	 * allocate a new array even if this list is backed by an array).
	 * The caller is thus free to modify the returned array.
	 *
	 * <p>This method acts as bridge between array-based and collection-based
	 * APIs.
	 *
	 * @return an array containing all of the elements in this list in proper
	 *         sequence
	 * @see Arrays#asList(Object[])
	 */
	@Override
	public Object[] toArray() {
		return _list.toArray();
	}

	/**
	 * Returns an array containing all of the elements in this list in
	 * proper sequence (from first to last element); the runtime type of
	 * the returned array is that of the specified array.  If the list fits
	 * in the specified array, it is returned therein.  Otherwise, a new
	 * array is allocated with the runtime type of the specified array and
	 * the size of this list.
	 *
	 * <p>If the list fits in the specified array with room to spare (i.e.,
	 * the array has more elements than the list), the element in the array
	 * immediately following the end of the list is set to {@code null}.
	 * (This is useful in determining the length of the list <i>only</i> if
	 * the caller knows that the list does not contain any null elements.)
	 *
	 * <p>Like the {@link #toArray()} method, this method acts as bridge between
	 * array-based and collection-based APIs.  Further, this method allows
	 * precise control over the runtime type of the output array, and may,
	 * under certain circumstances, be used to save allocation costs.
	 *
	 * <p>Suppose {@code x} is a list known to contain only strings.
	 * The following code can be used to dump the list into a newly
	 * allocated array of {@code String}:
	 *
	 * <pre>{@code
	 *     String[] y = x.toArray(new String[0]);
	 * }</pre>
	 *
	 * Note that {@code toArray(new Object[0])} is identical in function to
	 * {@code toArray()}.
	 *
	 * @param a the array into which the elements of this list are to
	 *          be stored, if it is big enough; otherwise, a new array of the
	 *          same runtime type is allocated for this purpose.
	 * @return an array containing the elements of this list
	 * @throws ArrayStoreException if the runtime type of the specified array
	 *         is not a supertype of the runtime type of every element in
	 *         this list
	 * @throws NullPointerException if the specified array is null
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		return _list.toArray(a);
	}
}