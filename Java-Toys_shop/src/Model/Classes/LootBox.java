package Model.Classes;

import java.util.*;

public class LootBox extends Model {

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

    public ToysListFabric getFabric() {
        return this.fabric;
    }

    public void setFabric(ToysListFabric fabric) {
        this.fabric = fabric;
    }

    public Map<UUID, ToysList<Toy>> getLootMap() {
        return this.lootMap;
    }

    public void setLootMap(Map<UUID, ToysList<Toy>> lootMap) {
        this.lootMap = lootMap;
    }

    public Map<UUID, Integer> getLootingProbability() {
        return lootingProbability;
    }

    public void setLootingProbability(Map<UUID, Integer> lootingProbability) {
        this.lootingProbability = lootingProbability;
    }

    public ToysList<Toy> put(String toysName, int numberOf, int lootingProbability) {
        ToysList<Toy> toysList = this.getFabric().generate(toysName, numberOf);
        this.getLootingProbability().put(toysList.getUuid(), lootingProbability);
        return this.getLootMap().put(toysList.getUuid(), toysList);
    }

    public Toy get() {
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
                if (toysList.isEmpty()){
                    continue;
                }
                prize = toysList.remove(0);
            }
        }

        return prize;
    }

}
