package at.int32.android.utils.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class RepositoryMap<K, V> implements Map<K, V> {

	private ConcurrentHashMap<K, V> data;

	public RepositoryMap() {
		data = new ConcurrentHashMap<K, V>();
	}

	@Override
	public void clear() {
		data.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return data.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return data.containsValue(value);
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return data.entrySet();
	}

	@Override
	public V get(Object key) {
		return data.get(key);
	}
	
	public V get(int position) {
		return new ArrayList<V>(data.values()).get(position);
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public Set<K> keySet() {
		return data.keySet();
	}

	@Override
	public V put(K key, V value) {
		return data.put(key, value);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> map) {
		data.putAll(map);
	}

	@Override
	public V remove(Object key) {
		return data.remove(key);
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public Collection<V> values() {
		return data.values();
	}

	public Repository<V> valuesAsRepository() {
		return toRepository(data.values());
	}

	public Repository<K> keysAsRepository() {
		return toRepository(data.keySet());
	}

	private <T> Repository<T> toRepository(Collection<T> set) {
		Repository<T> repo = new Repository<T>();
		repo.addAll(set);
		return repo;
	}

}
