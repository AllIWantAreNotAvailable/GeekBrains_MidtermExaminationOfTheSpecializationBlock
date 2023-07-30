package Model.Classes;

import Model.Interfaces.LootBoxInterface;

import java.util.*;

public class LootBox extends Model implements LootBoxInterface {

    private ToysListFabric fabric;
    private Map<UUID, ToysList<Toy>> lootMap;
    private Map<UUID, Integer> lootingProbability;

    public LootBox(ToysListFabric fabric) {
        this.setFabric(fabric);
        this.setLootMap(new HashMap<>());
        this.setLootingProbability(new HashMap<>());
    }

    public LootBox() {
        this(new ToysListFabric());
    }

    @Override
    public ToysListFabric getFabric() {
        return this.fabric;
    }

    @Override
    public void setFabric(ToysListFabric fabric) {
        this.fabric = fabric;
    }

    @Override
    public Map<UUID, ToysList<Toy>> getLootMap() {
        return this.lootMap;
    }

    @Override
    public void setLootMap(Map<UUID, ToysList<Toy>> lootMap) {
        this.lootMap = lootMap;
    }

    @Override
    public Map<UUID, Integer> getLootingProbability() {
        return lootingProbability;
    }

    @Override
    public void setLootingProbability(Map<UUID, Integer> lootingProbability) {
        this.lootingProbability = lootingProbability;
    }

    private void cleanEmpty() {
        List<UUID> emptyUuids = new ArrayList<>();
        for (Map.Entry<UUID, ToysList<Toy>> entry :
                this.getLootMap().entrySet()) {
            if (entry.getValue().isEmpty()) {
                emptyUuids.add(entry.getKey());
            }
        }
        for (UUID uuid :
                emptyUuids) {
            this.getLootMap().remove(uuid);
            this.getLootingProbability().remove(uuid);
        }
    }

    private boolean isEmpty() {
        this.cleanEmpty();
        return this.getLootMap().isEmpty();
    }

    @Override
    public ToysList<Toy> put(String toysName, int numberOf, int lootingProbability) {
        ToysList<Toy> toysList = this.getFabric().generate(toysName, numberOf);
        this.getLootingProbability().put(toysList.getUuid(), lootingProbability);
        return this.getLootMap().put(toysList.getUuid(), toysList);
    }

    @Override
    public Map<UUID, String> showLootingProbabilities() throws Exception {

        if (this.isEmpty()) {
            throw new Exception("Нет призов для розыгрыша!");
        }

        Map<UUID, String> map = new HashMap<>();
        for (Map.Entry<UUID, ToysList<Toy>> entry :
                this.getLootMap().entrySet()) {
            Integer probability = this.getLootingProbability().get(entry.getKey());
            String toyName = this.getLootMap().get(entry.getKey()).get(0).getToyName();
            map.put(entry.getKey(), String.format("Игрушка '%s' выпадет с вероятностью %d%c", toyName, probability, '%'));
        }
        return map;
    }

    @Override
    public Integer changeLootingProbability(UUID uuid, int newLootingProbability) {
        return this.getLootingProbability().put(uuid, newLootingProbability);
    }

    @Override
    public Toy get() throws Exception {

        if (this.isEmpty()) {
            throw new Exception("Нет призов для розыгрыша!");
        }

        Toy prize = null;
        Random random = new Random();
        List<UUID> uuids = new ArrayList<>(this.getLootMap().keySet());
        Deque<UUID> deque = new LinkedList<>();
        List<Boolean> lottery = new ArrayList<>(Arrays.asList(new Boolean[100]));

        while (!uuids.isEmpty()) {
            deque.addLast(uuids.remove(random.nextInt(0, uuids.size())));
        }

        while (!deque.isEmpty()) {
            UUID curUUID = deque.removeFirst();
            Integer probability = this.getLootingProbability().get(curUUID);

            Collections.fill(lottery, false);
            while (0 < probability) {
                int index = random.nextInt(0, lottery.size());
                if (lottery.get(index)) {
                    continue;
                }
                lottery.set(index, true);
                probability--;
            }

            int lotteryTicket = random.nextInt(0, lottery.size());
            Boolean isPrize = lottery.get(lotteryTicket);
            if (isPrize) {
                ToysList<Toy> toysList = this.getLootMap().get(curUUID);
                if (toysList.isEmpty()) {
                    continue;
                }
                prize = toysList.remove(0);
            }

        }

        return prize;

    }

}
