package Application.Model.Interfaces;

import java.util.List;

public interface EntityListInterface<E extends EntityInterface> extends List<E> {

    boolean equals(Object obj);

    int hashCode();

    String toString();

}
