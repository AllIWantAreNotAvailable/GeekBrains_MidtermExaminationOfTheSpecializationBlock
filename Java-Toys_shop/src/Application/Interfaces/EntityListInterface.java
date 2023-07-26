package Application.Interfaces;

import Application.Classes.Entity;

import java.util.List;

public interface EntityListInterface<E extends EntityInterface> extends List<E> {

    boolean equals(Object obj);

    int hashCode();

    String toString();

}
