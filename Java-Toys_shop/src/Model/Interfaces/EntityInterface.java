package Model.Interfaces;

import Model.Classes.Entity;

import java.util.UUID;

public interface EntityInterface<E extends Entity<?>> extends ModelInterface<E> {

    UUID getUuid();

    void setUuid(UUID uuid);

}
