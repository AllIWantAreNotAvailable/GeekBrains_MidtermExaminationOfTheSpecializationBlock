package Model.Interfaces;

import Model.Classes.Toy;
import Model.Classes.ToysList;
import Model.Classes.ToysListFabric;

import java.util.Map;
import java.util.UUID;

public interface LootBoxInterface extends ModelInterface {

    ToysListFabric getFabric();

    void setFabric(ToysListFabric fabric);

    Map<UUID, ToysList<Toy>> getLootMap();

    void setLootMap(Map<UUID, ToysList<Toy>> lootMap);

    Map<UUID, Integer> getLootingProbability();

    void setLootingProbability(Map<UUID, Integer> lootingProbability);

    ToysList<Toy> put(String toysName, int numberOf, int lootingProbability);

    Map<UUID, String> showLootingProbabilities() throws Exception;

    Integer changeLootingProbability(UUID uuid, int newLootingProbability);

    ToysList<Toy> remove(UUID uuid);

    Toy get() throws Exception;

}
