package Application.Classes;

import java.util.Objects;
import java.util.UUID;

public class Toy extends AbcEntity {

    static private int counter;

    static {
        counter = 0;
    }

    private String toyName;

    public Toy(UUID uuid, String toyName) {
        super(uuid);
        this.setToyName(toyName);
    }

    public Toy(String toyName) {
        super();
        this.setToyName(toyName);
    }

    public Toy(UUID uuid) {
        this(uuid, getDefaultName());
    }

    public Toy() {
        this(getDefaultName());
    }

    private static String getDefaultName() {
        return String.format("No name №%d", Toy.counter++);
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Toy toy)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getToyName(), toy.getToyName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getToyName());
    }

    @Override
    public String toString() {
        return "Toy{" +
                "uuid=" + this.getUuid() +
                ", toyName='" + this.getToyName() + '\'' +
                '}';
    }

}
