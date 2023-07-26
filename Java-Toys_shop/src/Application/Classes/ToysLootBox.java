package Application.Classes;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ToysLootBox extends AbcLoot<ToysList, Toy, implToyFabric> {

    public ToysLootBox(implToyFabric fabric) {
        super(fabric);
    }

    @Override
    public void initialize(int ratio, int numberOFToys, String toyName) {

        initLootingProbability(ratio);

        ToysList toysList = new ToysList();
        for (int i = 0; i < numberOFToys; i++) {
            toysList.add(this.getFabric().generate(toyName));
        }
        this.setLootList(toysList);

    }

    @Override
    public void initialize(int ratio, int numberOFToys) {

        initLootingProbability(ratio);

        ToysList toysList = new ToysList();
        for (int i = 0; i < numberOFToys; i++) {
            toysList.add(this.getFabric().generate());
        }
        this.setLootList(toysList);

    }

    private void initLootingProbability(int ratio) {
        this.setRatio(ratio);
        List<Boolean> list = Arrays.asList(new Boolean[100]);
        list.replaceAll(ignored -> false);
        Random random = new Random();
        while (0 < ratio--) {
            int index = random.nextInt(0, list.size());
            list.set(index, true);
        }
        this.setProbabilityList(list);
    }

    @Override
    public boolean isEmpty() {
        return this.getLootList().isEmpty();
    }

    @Override
    public int size() {
        return this.getLootList().size();
    }

    @Override
    public void bringBack(Toy toy) {
        this.getLootList().add(toy);
    }

    @Override
    public Toy open() {
        int randInt = new Random().nextInt(0, 100);
        return this.getProbabilityList().get(randInt) ? this.getLootList().pop() : null;
    }
}
