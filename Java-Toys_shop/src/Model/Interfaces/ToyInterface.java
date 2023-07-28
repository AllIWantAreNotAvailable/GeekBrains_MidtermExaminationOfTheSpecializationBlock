package Model.Interfaces;

import Model.Classes.Toy;

public interface ToyInterface<E extends Toy<?>> extends EntityInterface<E>{

    String getToyName();

    void setToyName(String toyName);

    boolean equals(Object obj);

    int hashCode();

    String toString();

}
