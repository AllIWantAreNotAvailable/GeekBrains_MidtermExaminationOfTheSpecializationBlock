package Model.Classes;

import java.util.List;
import java.util.UUID;

public class ToysListFabric<E extends Toy> {

    private ToyFabric fabric;

    public ToysListFabric(ToyFabric fabric) {
        this.setFabric(fabric);
    }

    public ToyFabric getFabric() {
        return fabric;
    }

    public void setFabric(ToyFabric fabric) {
        this.fabric = fabric;
    }

    public ToysList<E> ToysList(UUID uuid, List<E> entityList) {
        return new ToysList<>();
    }

    public ToysList<E> ToysList(UUID uuid) {
        return new ToysList<>();
    }

    public ToysList<E> ToysList(List<E> entityList) {
        return new ToysList<>();
    }

    public ToysList<E> ToysList() {
        return new ToysList<>();
    }

}
