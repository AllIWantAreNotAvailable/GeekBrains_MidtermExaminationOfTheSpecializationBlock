package Application.Classes;

import Application.Interfaces.EntityInterface;
import Application.Interfaces.EntityListInterface;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class EntityList<E extends EntityInterface> implements EntityListInterface<E> {

    List<E> list;

    public EntityList(List<E> list) {
        this.setList(list);
    }

    public EntityList(int initialCapacity) {
        this(new ArrayList<>(initialCapacity));
    }

    public List<E> getList() {
        return this.list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    @Override
    public int size() {
        return this.getList().size();
    }

    @Override
    public boolean isEmpty() {
        return this.getList().isEmpty();
    }

    @Override
    public boolean contains(Object obj) {
        return this.getList().contains(obj);
    }

    @Override
    public Iterator<E> iterator() {
        return this.getList().iterator();
    }

    @Override
    public Object[] toArray() {
        return this.getList().toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return this.getList().toArray(a);
    }

    @Override
    public boolean add(E entity) {
        return this.getList().add(entity);
    }

    @Override
    public boolean remove(Object obj) {
        return this.getList().remove(obj);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return this.getList().containsAll(collection);
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        return this.getList().addAll(collection);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        return this.getList().addAll(index, collection);
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return this.getList().removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return this.getList().retainAll(collection);
    }

    @Override
    public void clear() {
        this.getList().clear();
    }

    @Override
    public E get(int index) {
        return this.getList().get(index);
    }

    @Override
    public E set(int index, E element) {
        return this.getList().set(index, element);
    }

    @Override
    public void add(int index, E element) {
        this.getList().add(index, element);
    }

    @Override
    public E remove(int index) {
        return this.getList().remove(index);
    }

    @Override
    public int indexOf(Object obj) {
        return this.getList().indexOf(obj);
    }

    @Override
    public int lastIndexOf(Object obj) {
        return this.getList().lastIndexOf(obj);
    }

    @Override
    public ListIterator<E> listIterator() {
        return this.getList().listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return this.getList().listIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return this.getList().subList(fromIndex, toIndex);
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        this.getList().replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super E> comparator) {
        this.getList().sort(comparator);
    }

    @Override
    public Spliterator<E> spliterator() {
        return this.getList().spliterator();
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return this.getList().toArray(generator);
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return this.getList().removeIf(filter);
    }

    @Override
    public Stream<E> stream() {
        return this.getList().stream();
    }

    @Override
    public Stream<E> parallelStream() {
        return this.getList().parallelStream();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        this.getList().forEach(action);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EntityList<?> entities)) return false;
        return Objects.equals(getList(), entities.getList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getList());
    }

    @Override
    public String toString() {
        return "EntityList{" +
                "size=" + this.size() +
                ", list=" + this.getList() +
                '}';
    }

}
