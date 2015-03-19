package at.int32.android.utils.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Repository<T> implements List<T> {

	private List<T> data;
	
	public Repository() {
		data = new CopyOnWriteArrayList<T>();
	}

	@Override
	public boolean add(T object) {
		if(!data.contains(object))
			return data.add(object);
		
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> collection) {
		return data.addAll(collection);
	}

	@Override
	public void clear() {
		data.clear();
	}

	@Override
	public boolean contains(Object object) {
		return data.contains(object);
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		return data.containsAll(collection);
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		return data.iterator();
	}

	@Override
	public boolean remove(Object object) {
		return data.remove(object);
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		return data.removeAll(collection);
	}

	@Override
	public boolean retainAll(Collection<?> collection) {
		return data.retainAll(collection);
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public Object[] toArray() {
		return data.toArray();
	}

	@Override
	public <T> T[] toArray(T[] array) {
		return data.toArray(array);
	}

	@Override
	public void add(int location, T object) {
		data.add(location, object);
	}

	@Override
	public boolean addAll(int location, Collection<? extends T> collection) {
		return data.addAll(location, collection);
	}

	@Override
	public T get(int location) {
		return data.get(location);
	}

	@Override
	public int indexOf(Object object) {
		return data.indexOf(object);
	}

	@Override
	public int lastIndexOf(Object object) {
		return data.lastIndexOf(object);
	}

	@Override
	public ListIterator<T> listIterator() {
		return data.listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int location) {
		return data.listIterator(location);
	}

	@Override
	public T remove(int location) {
		return data.remove(location);
	}

	@Override
	public T set(int location, T object) {
		return data.set(location, object);
	}

	@Override
	public List<T> subList(int start, int end) {
		return data.subList(start, end);
	}

}
