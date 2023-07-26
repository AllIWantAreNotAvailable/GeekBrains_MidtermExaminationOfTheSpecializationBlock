package Application.Classes;

import java.util.Comparator;

public class EntityComparator implements Comparator<Entity> {

    @Override
    public int compare(Entity left, Entity right) {
        return left.getName().compareTo(right.getName());
    }

    @Override
    public Comparator<Entity> reversed() {
        return Comparator.super.reversed();
    }

}
