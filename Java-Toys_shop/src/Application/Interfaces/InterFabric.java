package Application.Interfaces;

import Application.Classes.AbsBox;
import Application.Classes.AbsEntity;


public interface InterFabric<T extends AbsEntity, E extends AbsBox<T>> {

    T getEntity();

    E getEntity(int number);

}
