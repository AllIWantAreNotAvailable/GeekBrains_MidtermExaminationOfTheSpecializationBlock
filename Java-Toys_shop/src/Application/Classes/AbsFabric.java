package Application.Classes;

import Application.Interfaces.InterFabric;

public abstract class AbsFabric<T extends AbsEntity, E extends AbsBox<T>> implements InterFabric<T, E> {

    public AbsFabric() {
    }

}
