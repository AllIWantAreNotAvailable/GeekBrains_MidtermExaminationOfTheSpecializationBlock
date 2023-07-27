package Application.Model.Classes;

import Application.Model.Interfaces.EntityInterface;

import java.util.Objects;
import java.util.UUID;

public class Entity implements EntityInterface, Comparable<Entity> {

    private UUID uuid;
    private String name;

    public Entity(UUID uuid, String name) {
        this.setUuid(uuid);
        this.setName(name);
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Entity that)) return false;
        return Objects.equals(this.getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getUuid(), this.getName());
    }

    @Override
    public String toString() {
        return "Entity{" +
                "uuid=" + this.getUuid() +
                ", name='" + this.getName() + '\'' +
                '}';
    }

    @Override
    public int compareTo(Entity right) {
        return new EntityComparator().compare(this, right);
    }

}
