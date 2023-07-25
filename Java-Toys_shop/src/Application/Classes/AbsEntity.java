package Application.Classes;

import Application.Interfaces.InterEntity;

import java.util.UUID;

public abstract class AbsEntity implements InterEntity {
    protected UUID uuid;

    public AbsEntity() {
        this.initialize();
    }

    protected abstract void initialize();

}
