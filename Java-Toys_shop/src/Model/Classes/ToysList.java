package Model.Classes;

import Model.Interfaces.ToysListInterface;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ToysList<E extends Toy<?>> extends EntityList<E> implements ToysListInterface<E> {

    public ToysList(UUID uuid, List<E> entityList) {
        super(uuid, entityList);
    }

    public ToysList(UUID uuid) {
        super(uuid);
    }

    public ToysList(List<E> entityList) {
        super(entityList);
    }

    public ToysList() {
        super();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ToysList<?> that)) return false;
        return Objects.equals(this.getEntityList(), that.getEntityList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getUuid(), this.getEntityList());
    }

    @Override
    public String toString() {
        return "ToysList{" +
                "uuid=" + this.getUuid() +
                ", toysList='" + this.getEntityList() + '\'' +
                '}';
    }

}
