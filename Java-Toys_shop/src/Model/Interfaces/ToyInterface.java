package Model.Interfaces;

public interface ToyInterface extends EntityInterface {

    String getToyName();

    void setToyName(String toyName);

    boolean equals(Object obj);

    int hashCode();

    String toString();

}
