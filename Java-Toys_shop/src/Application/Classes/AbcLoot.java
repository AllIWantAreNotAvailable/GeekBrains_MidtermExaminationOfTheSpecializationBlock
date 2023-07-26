package Application.Classes;

import Application.Interface.Fabric;
import Application.Interface.Loot;

import java.util.List;

public abstract class AbcLoot<L extends AbcEntityList<E>, E extends AbcEntity, F extends Fabric<E>> implements Loot<E> {

    private F fabric;
    private L lootList;
    private int ratio;
    private List<Boolean> probabilityList;

    public AbcLoot(F fabric) {
        this.setFabric(fabric);
    }

    public abstract void initialize(int ratio, int numberOFToys, String toysName);

    public abstract void initialize(int ratio, int numberOFToys);

    public F getFabric() {
        return fabric;
    }

    public void setFabric(F fabric) {
        this.fabric = fabric;
    }

    public L getLootList() {
        return lootList;
    }

    public void setLootList(L lootList) {
        this.lootList = lootList;
    }

    public int getRatio() {
        return ratio;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }

    public List<Boolean> getProbabilityList() {
        return probabilityList;
    }

    public void setProbabilityList(List<Boolean> probabilityList) {
        this.probabilityList = probabilityList;
    }

}
