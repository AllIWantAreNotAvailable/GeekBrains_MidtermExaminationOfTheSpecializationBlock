package Model.Interfaces;

import Model.Classes.Toy;

public interface ToysListInterface<E extends Toy> extends EntityListInterface<E> {

    boolean equals(Object obj);

    int hashCode();

    String toString();


}
