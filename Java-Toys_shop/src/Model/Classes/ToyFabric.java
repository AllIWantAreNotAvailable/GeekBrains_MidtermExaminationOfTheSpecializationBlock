package Model.Classes;

import java.util.UUID;

public class ToyFabric {

    public Toy generate(UUID uuid, String toyName) {
        return new Toy(uuid, toyName);
    }

    public Toy generate(String toyName) {
        return new Toy(toyName);
    }

}
