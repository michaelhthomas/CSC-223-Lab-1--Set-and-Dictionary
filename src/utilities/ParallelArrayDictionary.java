package utilities;
 
import java.util.*;

public class ParallelArrayDictionary<Key, Value> implements Map<Key, Value>
{
	protected ArraySet<Key> _keys;
	protected ArrayList<Value> _values;

	public ParallelArrayDictionary()
	{
		_keys = new ArraySet<>();
		_values = new ArrayList<>();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub (leiby)
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub (leiby)
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub (leiby)
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub (leiby)
		return false;
	}

	@Override
	public Value get(Object key) {
		// TODO Auto-generated method stub (leiby)
		return null;
	}

	@Override
	public Value put(Key key, Value value) {
		// TODO Auto-generated method stub (leiby)
		return null;
	}

	@Override
	public Value remove(Object key) {
		// TODO Auto-generated method stub (leiby)
		return null;
	}

	@Override
	public void putAll(Map<? extends Key, ? extends Value> m) {
		// TODO Auto-generated method stub (thomas)
		
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
