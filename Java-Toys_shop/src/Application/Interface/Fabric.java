package Application.Interface;

import Application.Classes.AbcEntity;

import java.util.UUID;

public interface Fabric<E extends AbcEntity> {

    E generate(UUID uuid);

    E generate();

}
