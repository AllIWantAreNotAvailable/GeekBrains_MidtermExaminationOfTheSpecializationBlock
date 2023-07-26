package Application.Interface;

import Application.Classes.AbcEntity;

public interface Loot<E extends AbcEntity> {

    boolean isEmpty();

    int size();

    void bringBack(E entity);

    E open();

}
