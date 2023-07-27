package Application.Model.Classes;

import Application.Model.Interfaces.FabricInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class EntityFabric implements FabricInterface<Entity, EntityList<Entity>> {

    static private final String defaultName;
    static private int index;

    static {
        index = 0;
        defaultName = "Default #";
    }

    private String getDefaultName() {
        return String.format("%s%d", EntityFabric.defaultName, EntityFabric.index++);
    }

    private UUID getUUID() {
        // todo Realize UUID.randomUUID() functionality
        return UUID.randomUUID();
    }

    @Override
    public Entity generate(UUID uuid, String name) {
        return new Entity(uuid, name);
    }

    @Override
    public Entity generate(String name) {
        return new Entity(getUUID(), name);
    }

    @Override
    public Entity generate() {
        return new Entity(getUUID(), getDefaultName());
    }

    @Override
    public EntityList<Entity> generate(List<UUID> uuids, String name) {
        List<Entity> entities = new ArrayList<>(uuids.size());
        for (UUID uuid :
                uuids) {
            entities.add(this.generate(uuid, name));
        }
        return new EntityList<>(getUUID(), entities);
    }

    @Override
    public EntityList<Entity> generate(int numberOf, String name) {
        List<UUID> uuids = new ArrayList<>(numberOf);
        for (int i = 0; i < numberOf; i++) {
            uuids.add(getUUID());
        };
        return this.generate(uuids, name);
    }

    @Override
    public EntityList<Entity> generate(int numberOf) {
        return this.generate(numberOf, getDefaultName());
    }

}
