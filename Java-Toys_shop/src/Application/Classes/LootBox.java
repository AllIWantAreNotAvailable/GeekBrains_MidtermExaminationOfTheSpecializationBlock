package Application.Classes;

import java.util.*;

public class LootBox {

    EntityFabric fabric;
    Map<UUID, EntityList<Entity>> loot;
    Map<UUID, Integer> probabilities;
    Map<UUID, List<Boolean>> lottery;
    Boolean working;

    public LootBox(EntityFabric fabric) {
        this.setFabric(fabric);
        this.setLoot(new HashMap<>());
        this.setProbabilities(new HashMap<>());
        this.setLottery(new HashMap<>());
        this.turnOff();
    }

    public EntityFabric getFabric() {
        return fabric;
    }

    public void setFabric(EntityFabric fabric) {
        this.fabric = fabric;
    }

    public Map<UUID, EntityList<Entity>> getLoot() {
        return loot;
    }

    public void setLoot(Map<UUID, EntityList<Entity>> loot) {
        this.loot = loot;
    }

    public Map<UUID, Integer> getProbabilities() {
        return probabilities;
    }

    public void setProbabilities(Map<UUID, Integer> probabilities) {
        this.probabilities = probabilities;
    }

    public Map<UUID, List<Boolean>> getLottery() {
        return lottery;
    }

    public void setLottery(Map<UUID, List<Boolean>> lottery) {
        this.lottery = lottery;
    }

    public void turnOn() throws Exception {
        boolean flag = false;
        if (0 < this.getLoot().size()) {
            for (EntityList<Entity> loot :
                    getLoot().values()) {
                if (!loot.isEmpty()) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }
        } else {
            flag = true;
        }
        this.working = !flag;
        if (flag) throw new Exception("Нет призов!");
    }

    public void turnOff() {
        this.working = false;
    }

    public Boolean isWorking() {
        try {
            this.turnOn();
            this.turnOff();
            return this.working;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void addLoot(int numberOf, String name, int lootingProbability) {
        EntityList<Entity> newLoot = this.getFabric().generate(numberOf, name);
        UUID newLootUuid = newLoot.getUuid();
        this.getLoot().put(newLootUuid, newLoot);
        this.getProbabilities().put(newLootUuid, lootingProbability);

        int probabilityRate = 100;
        List<Boolean> lottery = new ArrayList<>(Arrays.asList(new Boolean[probabilityRate]));
        Random random = new Random();
        while (0 < lootingProbability) {
            int randInt = random.nextInt(0, probabilityRate);
            if (!lottery.get(randInt)) {
                lottery.set(randInt, true);
                lootingProbability--;
            }
        }
        this.getLottery().put(newLootUuid, lottery);
    }

}
