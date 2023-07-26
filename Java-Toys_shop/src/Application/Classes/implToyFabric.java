package Application.Classes;

import Application.Interface.ToysFabric;

import java.util.UUID;

public class implToyFabric implements ToysFabric<Toy> {

    @Override
    public Toy generate(UUID uuid, String toyName) {
        return new Toy(uuid, toyName);
    }

    @Override
    public Toy generate(String toyName) {
        return new Toy(toyName);
    }

    @Override
    public Toy generate(UUID uuid) {
        return new Toy(uuid);
    }

    @Override
    public Toy generate() {
        return new Toy();
    }
}
