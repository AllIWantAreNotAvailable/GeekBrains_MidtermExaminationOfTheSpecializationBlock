package Model.Classes;

import Model.Interfaces.EntityInterface;

import java.util.UUID;

public abstract class Entity extends Model implements EntityInterface {

    private UUID uuid;

    public Entity(UUID uuid) {
        this.setUuid(uuid);
    }

    public Entity() {
        // todo Add UUID generator
        this.setUuid(null);
    }

    @Override
    public UUID getUuid() {
        return this.uuid;
    }

    @Override
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

}
