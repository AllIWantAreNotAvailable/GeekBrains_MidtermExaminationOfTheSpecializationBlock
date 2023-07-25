package Application.Classes;

import java.util.ArrayList;
import java.util.List;

public class ToyFabric extends AbsFabric<PrizeToy, ToyBox<PrizeToy>> {

    private static int count;

    static {
        count = 0;
    }

    public ToyFabric() {
    }

    private static String getDefaultName() {
        return String.format("No name toy №%d", ++ToyFabric.count);
    }

    @Override
    public PrizeToy getEntity() {
        return new PrizeToy(ToyFabric.getDefaultName());
    }

    public PrizeToy getEntity(String name) {
        return new PrizeToy(name);
    }

    @Override
    public ToyBox<PrizeToy> getEntity(int number) {
        List<PrizeToy> temp = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            temp.add(new PrizeToy(ToyFabric.getDefaultName()));
        }
        return new ToyBox<>(temp);
    }

    public ToyBox<PrizeToy> getEntity(String name, int number) {
        List<PrizeToy> temp = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            temp.add(new PrizeToy(name));
        }
        return new ToyBox<>(temp);
    }

}
