package Application.Model.Interfaces;

import Application.Model.Classes.Entity;
import Application.Model.Classes.EntityFabric;
import Application.Model.Classes.EntityList;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface LootBoxInterface {

    EntityFabric getFabric();

    void setFabric(EntityFabric fabric);

    Map<UUID, EntityList<Entity>> getLoot();

    void setLoot(Map<UUID, EntityList<Entity>> loot);

    Map<UUID, Integer> getProbabilities();

    void setProbabilities(Map<UUID, Integer> probabilities);

    Map<UUID, List<Boolean>> getLottery();

    void setLottery(Map<UUID, List<Boolean>> lottery);

    void turnOn() throws Exception;

    void turnOff();

    Boolean isWorking();

    void addLoot(int numberOf, String name, int lootingProbability);

    Entity generate() throws Exception;

}
