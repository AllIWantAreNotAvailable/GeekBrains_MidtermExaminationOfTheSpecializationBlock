package Controller.Classes;

import Model.Classes.LootBox;
import Model.Classes.Toy;
import Model.Classes.ToysList;
import Model.Classes.ToysListFabric;
import Model.Interfaces.LootBoxInterface;

import java.util.Map;
import java.util.UUID;

public class LootBoxModelController extends ModelController<LootBox> implements LootBoxInterface {

    public LootBoxModelController(LootBox model) {
        super(model);
    }

    public LootBoxModelController() {
        this(new LootBox());
    }

    @Override
    public ToysListFabric getFabric() {
        return super.getModel().getFabric();
    }

    @Override
    public void setFabric(ToysListFabric fabric) {
        super.getModel().setFabric(fabric);
    }

    @Override
    public Map<UUID, ToysList<Toy>> getLootMap() {
        return super.getModel().getLootMap();
    }

    @Override
    public void setLootMap(Map<UUID, ToysList<Toy>> lootMap) {
        super.getModel().setLootMap(lootMap);
    }

    @Override
    public Map<UUID, Integer> getLootingProbability() {
        return super.getModel().getLootingProbability();
    }

    @Override
    public void setLootingProbability(Map<UUID, Integer> lootingProbability) {
        super.getModel().setLootingProbability(lootingProbability);
    }

    @Override
    public ToysList<Toy> put(String toysName, int numberOf, int lootingProbability) {
        return super.getModel().put(toysName, numberOf, lootingProbability);
    }

    @Override
    public Map<UUID, String> showLootingProbabilities() {

        try {
            return super.getModel().showLootingProbabilities();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Integer changeLootingProbability(UUID uuid, int newLootingProbability) {
        return super.getModel().changeLootingProbability(uuid, newLootingProbability);
    }

    @Override
    public ToysList<Toy> remove(UUID uuid) {
        return this.getModel().remove(uuid);
    }

    @Override
    public Toy get() {

        try {
            return super.getModel().get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
