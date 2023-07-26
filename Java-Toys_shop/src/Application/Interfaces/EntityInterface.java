package Application.Interfaces;

import Application.Classes.Entity;

import java.util.UUID;

public interface EntityInterface extends Comparable<Entity> {

    UUID getUuid();

    void setUuid(UUID uuid);

    String getName();

    void setName(String name);

    boolean equals(Object obj);

    int hashCode();

    String toString();

}
