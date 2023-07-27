package Application.Controller.Classes;

import Application.Controller.Interfaces.LootBoxControllerInterface;
import Application.Model.Classes.Entity;
import Application.Model.Classes.EntityFabric;
import Application.Model.Classes.EntityList;
import Application.Model.Classes.LootBox;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class LootBoxController implements LootBoxControllerInterface {

    private LootBox lootBox;

    public LootBoxController(LootBox lootBox) {
        this.setLootBox(lootBox);
    }

    @Override
    public LootBox getLootBox() {
        return lootBox;
    }

    @Override
    public void setLootBox(LootBox lootBox) {
        this.lootBox = lootBox;
    }

    @Override
    public EntityFabric getFabric() {
        return this.getLootBox().getFabric();
    }

    @Override
    public void setFabric(EntityFabric fabric) {
        this.getLootBox().setFabric(fabric);
    }

    @Override
    public Map<UUID, EntityList<Entity>> getLoot() {
        return this.getLootBox().getLoot();
    }

    @Override
    public void setLoot(Map<UUID, EntityList<Entity>> loot) {
        this.getLootBox().setLoot(loot);
    }

    @Override
    public Map<UUID, Integer> getProbabilities() {
        return this.getLootBox().getProbabilities();
    }

    @Override
    public void setProbabilities(Map<UUID, Integer> probabilities) {
        this.getLootBox().setProbabilities(probabilities);
    }

    @Override
    public Map<UUID, List<Boolean>> getLottery() {
        return this.getLootBox().getLottery();
    }

    @Override
    public void setLottery(Map<UUID, List<Boolean>> lottery) {
        this.getLootBox().setLottery(lottery);
    }

    @Override
    public void turnOn() throws Exception {
        this.getLootBox().turnOn();
    }

    @Override
    public void turnOff() {
        this.getLootBox().turnOff();
    }

    @Override
    public Boolean isWorking() {
        return this.getLootBox().isWorking();
    }

    @Override
    public void addLoot(int numberOf, String name, int lootingProbability) {
        this.getLootBox().addLoot(numberOf, name, lootingProbability);
    }

    @Override
    public Entity generate() throws Exception {
        return this.getLootBox().generate();
    }

}
