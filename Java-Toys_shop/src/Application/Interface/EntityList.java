package Application.Interface;

import Application.Classes.AbcEntity;

import java.util.NoSuchElementException;

public interface EntityList<E extends AbcEntity> extends Iterable<E> {

    boolean isEmpty();

    int size();

    void clear();

    boolean add(E entity);

    void add(int index, E element);

    E get(int index);

    E pop() throws NoSuchElementException;

}
