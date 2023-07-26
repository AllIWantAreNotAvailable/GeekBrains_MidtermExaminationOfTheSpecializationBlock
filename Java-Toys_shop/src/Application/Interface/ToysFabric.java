package Application.Interface;

import Application.Classes.Toy;

import java.util.UUID;

public interface ToysFabric<E extends Toy> extends Fabric<E> {

    E generate(UUID uuid, String toyName);

    E generate(String toyName);

}
