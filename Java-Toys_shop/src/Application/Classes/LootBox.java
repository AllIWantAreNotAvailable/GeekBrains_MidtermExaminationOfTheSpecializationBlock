package Application.Classes;

import java.util.List;
import java.util.Map;

public class LootBox<F extends AbsFabric<E, T>, T extends AbsBox<E>, E extends AbsEntity> {

    private F fabric;
    private Map<Float, List<T>> lootBox;

    public LootBox(F fabric) {
        this.setFabric(fabric);
    }

    public F getFabric() {
        return this.fabric;
    }

    public void setFabric(F fabric) {
        this.fabric = fabric;
    }

    public Map<Float, List<T>> getLootBox() {
        return this.lootBox;
    }

    public void setLootBox(Map<Float, List<T>> lootBox) {
        this.lootBox = lootBox;
    }

    
}
