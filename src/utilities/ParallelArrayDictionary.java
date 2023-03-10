/**
* 
* Implements a set-based ParallelArrayDictionary, using an arraylist for the keys and the
* values.  implements methods for modifying and getting data about the dictionaryh
*
* @author Michael Leiby, Michael Thomas
* @date January 17, 2023
*/

package utilities;
 
import java.util.*;

public class ParallelArrayDictionary<Key, Value> implements Map<Key, Value>
{
	protected ArraySet<Key> _keys;
	protected ArrayList<Value> _values;

	/**
	 * Create a new empty ParallelArrayDictionary.
	 */
	public ParallelArrayDictionary() {
		_keys = new ArraySet<>();
		_values = new ArrayList<>();
	}

	@Override
	public int size() {
		return _keys.size();
	}

	@Override
	public boolean isEmpty() {
		return _keys.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return _keys.contains(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return _values.contains(value);
	}

	@Override
	public Value get(Object key) {
		// returns the value associated with the key if the key is contained within the dictionary
		if (_keys.contains(key)) return _values.get(_keys.indexOf(key));
		return null;
	}

	@Override
	public Value put(Key key, Value value) {
		if (_keys.contains(key)) {
			_values.set(_keys.indexOf(key), value);
			return value;
		}
		
		if(_keys.add(key)) {
			// only add value if key is added successfully
			_values.add(value);
		};

		return value;
	}

	@Override
	public Value remove(Object key) {
		if (!_keys.contains(key)) return null;
		
		// stores the value, removes the value and key from the dictionary, returns the value
		Value removed = _values.remove(_keys.indexOf(key));
		_keys.remove(key);
		return removed;
	}

	@Override
	public void putAll(Map<? extends Key, ? extends Value> m) {
		for (Entry<? extends Key, ? extends Value> entry : m.entrySet()) {
			if (_keys.add(entry.getKey())) {
				// only add the value if the key is added successfully
				_values.add(entry.getValue());
			}
		}
	}

	@Override
	public void clear() {
		_keys.clear();
		_values.clear();
	}

	@Override
	public Set<Key> keySet() {
		return _keys;
	}

	@Override
	public Collection<Value> values() {
		return _values;
	}

	@Override
	public Set<Entry<Key, Value>> entrySet() {
		Set<Entry<Key, Value>> entrySet = new ArraySet<>();

		for (int i = 0; i < _keys.size(); i++) {
			Key key = _keys.get(i);
			Value val = _values.get(i);

			entrySet.add(new AbstractMap.SimpleEntry<Key, Value>(key, val));
		}

		return entrySet;
	}

}