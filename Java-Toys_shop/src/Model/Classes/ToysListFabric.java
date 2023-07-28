package Model.Classes;

import java.util.List;
import java.util.UUID;

public class ToysListFabric {

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

    public ToysList<Toy> generate(UUID uuid, List<Toy> toysList) {
        return new ToysList<>(uuid, toysList);
    }

    public ToysList<Toy> generate(List<Toy> toysList) {
        return new ToysList<>(toysList);
    }

    public ToysList<Toy> generate(UUID uuid) {
        return new ToysList<>(uuid);
    }

    public ToysList<Toy> generate() {
        return new ToysList<>();
    }

    public ToysList<Toy> generate(String toysName, int numberOf) {
        ToysList<Toy> toys = this.generate();

        for (int i = 0; i < numberOf; i++) {
            toys.add(this.getFabric().generate(toysName));
        }

        return toys;
    }

}
