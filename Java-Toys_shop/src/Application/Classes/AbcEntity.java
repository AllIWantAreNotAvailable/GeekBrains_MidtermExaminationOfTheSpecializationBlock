package Application.Classes;

import java.util.Objects;
import java.util.UUID;

public abstract class AbcEntity {

    protected UUID uuid;

    public AbcEntity(UUID uuid) {
        this.setUuid(uuid);
    }

    public AbcEntity() {
        this.setUuid(UUID.randomUUID());
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbcEntity absEntity)) return false;
        return Objects.equals(this.getUuid(), absEntity.getUuid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getUuid());
    }

    @Override
    public String toString() {
        return "AbsEntity{" +
                "uuid=" + this.getUuid() +
                '}';
    }

}
