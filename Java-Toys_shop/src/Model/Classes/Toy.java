package Model.Classes;

import Model.Interfaces.ToyInterface;

import java.util.Objects;
import java.util.UUID;

public class Toy<E extends Toy<?>> extends Entity<E> implements ToyInterface<E> {

    private String toyName;

    public Toy(UUID uuid, String toyName) {
        super(uuid);
        this.setToyName(toyName);
    }

    public Toy(String toyName) {
        super();
        this.setToyName(toyName);
    }

    @Override
    public String getToyName() {
        return this.toyName;
    }

    @Override
    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Toy<?> that)) return false;
        return Objects.equals(getToyName(), that.getToyName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getUuid(), getToyName());
    }

    @Override
    public String toString() {
        return "Toy{" +
                "uuid=" + this.getUuid() +
                ", toyName='" + this.getToyName() + '\'' +
                '}';
    }

}
