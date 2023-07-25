package Application.Interfaces;

import Application.Classes.AbsEntity;

import java.util.List;

public interface InterBox<T extends AbsEntity> {

    void setBox(List<T> box);

    List<T> getBox();


    boolean isEmpty();

    void add(T entity);

    void add(List<T> entities);

    T pop();

    List<T> pop(int number);
}
