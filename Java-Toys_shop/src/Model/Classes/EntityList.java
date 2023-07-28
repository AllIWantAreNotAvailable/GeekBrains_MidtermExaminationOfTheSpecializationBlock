package Model.Classes;

import Model.Interfaces.EntityListInterface;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public abstract class EntityList<E extends Entity> extends Entity implements EntityListInterface<E> {

    private List<E> entityList;

    public EntityList(UUID uuid, List<E> entityList) {
        super(uuid);
        this.setEntityList(entityList);
    }

    public EntityList(UUID uuid) {
        this(uuid, new ArrayList<>());
    }

    public EntityList(List<E> entityList) {
        super();
        this.setEntityList(entityList);
    }

    public EntityList() {
        this(new ArrayList<>());
    }

    @Override
    public List<E> getEntityList() {
        return this.entityList;
    }

    @Override
    public void setEntityList(List<E> entityList) {
        this.entityList = entityList;
    }

    @Override
    public int size() {
        return this.getEntityList().size();
    }

    @Override
    public boolean isEmpty() {
        return this.getEntityList().isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.getEntityList().contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return this.getEntityList().iterator();
    }

    @Override
    public Object[] toArray() {
        return this.getEntityList().toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return this.getEntityList().toArray(a);
    }

    @Override
    public boolean add(E e) {
        return this.getEntityList().add(e);
    }

    @Override
    public boolean remove(Object o) {
        return this.getEntityList().remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.getEntityList().containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return this.getEntityList().addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return this.getEntityList().addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.getEntityList().removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.getEntityList().retainAll(c);
    }

    @Override
    public void clear() {
        this.getEntityList().clear();
    }

    @Override
    public E get(int index) {
        return this.getEntityList().get(index);
    }

    @Override
    public E set(int index, E element) {
        return this.getEntityList().set(index, element);
    }

    @Override
    public void add(int index, E element) {
        this.getEntityList().add(index, element);
    }

    @Override
    public E remove(int index) {
        return this.getEntityList().remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return this.getEntityList().indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return this.getEntityList().lastIndexOf(o);
    }

    @Override
    public ListIterator<E> listIterator() {
        return this.getEntityList().listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return this.getEntityList().listIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return this.getEntityList().subList(fromIndex, toIndex);
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        this.getEntityList().replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super E> c) {
        this.getEntityList().sort(c);
    }

    @Override
    public Spliterator<E> spliterator() {
        return this.getEntityList().spliterator();
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return this.getEntityList().toArray(generator);
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return this.getEntityList().removeIf(filter);
    }

    @Override
    public Stream<E> stream() {
        return this.getEntityList().stream();
    }

    @Override
    public Stream<E> parallelStream() {
        return this.getEntityList().parallelStream();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        this.getEntityList().forEach(action);
    }

}
