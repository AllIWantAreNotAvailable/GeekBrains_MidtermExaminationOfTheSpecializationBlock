package Application.Model.Classes;

import Application.Model.Interfaces.LootBoxInterface;

import java.util.*;

public class LootBox implements LootBoxInterface {

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

    @Override
    public EntityFabric getFabric() {
        return fabric;
    }

    @Override
    public void setFabric(EntityFabric fabric) {
        this.fabric = fabric;
    }

    @Override
    public Map<UUID, EntityList<Entity>> getLoot() {
        return loot;
    }

    @Override
    public void setLoot(Map<UUID, EntityList<Entity>> loot) {
        this.loot = loot;
    }

    @Override
    public Map<UUID, Integer> getProbabilities() {
        return probabilities;
    }

    @Override
    public void setProbabilities(Map<UUID, Integer> probabilities) {
        this.probabilities = probabilities;
    }

    @Override
    public Map<UUID, List<Boolean>> getLottery() {
        return lottery;
    }

    @Override
    public void setLottery(Map<UUID, List<Boolean>> lottery) {
        this.lottery = lottery;
    }

    private boolean checkNumberOfPrizes() {
        boolean flag = true;
        if (0 < this.getLoot().size()) {
            for (EntityList<Entity> loot :
                    getLoot().values()) {
                flag = !loot.isEmpty();
                if (flag) break;
            }
        } else {
            flag = false;
        }
        return flag;
    }

    @Override
    public void turnOn() throws Exception {
        boolean flag = checkNumberOfPrizes();
        this.working = flag;
        if (!flag) throw new Exception("Нет призов!");
    }

    @Override
    public void turnOff() {
        this.working = false;
    }

    @Override
    public Boolean isWorking() {
        return this.working && checkNumberOfPrizes();
    }

    @Override
    public void addLoot(int numberOf, String name, int lootingProbability) {

        EntityList<Entity> newLoot = this.getFabric().generate(numberOf, name);
        UUID newLootUuid = newLoot.getUuid();
        this.getLoot().put(newLootUuid, newLoot);
        this.getProbabilities().put(newLootUuid, lootingProbability);

        int probabilityRate = 100;
        List<Boolean> lottery = new ArrayList<>(Arrays.asList(new Boolean[probabilityRate]));
        Collections.fill(lottery, false);
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

    @Override
    public Entity generate() throws Exception {

        Entity prize = null;

        if (!this.checkNumberOfPrizes()) {
            this.turnOff();
            throw new Exception("Все призы закончились, розыгрыш остановлен");
        } else if (!this.isWorking()) {
            throw new Exception("Розыгрыш еще не начался");
        }

        List<UUID> uuids = new ArrayList<>(this.getLoot().keySet());
        Deque<UUID> deque = new LinkedList<>();
        Random random = new Random();
        while (!uuids.isEmpty()) {
            deque.addLast(uuids.remove(random.nextInt(0, uuids.size())));
        }

        UUID uuid;
        while (!deque.isEmpty()) {
            uuid = deque.pollFirst();
            List<Boolean> lottery = this.getLottery().get(uuid);
            if (lottery.get(random.nextInt(0, lottery.size()))) {
                EntityList<Entity> loot = this.getLoot().get(uuid);
                if (loot.isEmpty()) {
                    continue;
                }
                prize = loot.remove(0);
                break;
            }
        }

        return prize;
    }

}
