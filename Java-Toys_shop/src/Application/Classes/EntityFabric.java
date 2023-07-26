package Application.Classes;

import Application.Interfaces.FabricInterface;

import java.util.*;

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
    public EntityList<Entity> generate(Map<UUID, String> uuidNamePairs) {
        EntityList<Entity> entityList = new EntityList<>(uuidNamePairs.size());
        for (Map.Entry<UUID, String> initValues :
                uuidNamePairs.entrySet()) {
            entityList.add(this.generate(initValues.getKey(), initValues.getValue()));
        }
        return entityList;
    }

    @Override
    public EntityList<Entity> generate(String[] names) {
        Map<UUID, String> uuidNamePairs = new HashMap<>();
        for (String name :
                names) {
            uuidNamePairs.put(getUUID(), name);
        }
        return this.generate(uuidNamePairs);
    }

    @Override
    public EntityList<Entity> generate(int numberOf) {
        EntityList<Entity> entityList = new EntityList<>(numberOf);
        for (int i = 0; i < numberOf; i++) {
            entityList.add(this.generate());
        }
        return entityList;
    }

}
