package Application.Classes;

import java.util.*;
import java.util.function.Consumer;

public class ToysList extends AbcEntityList<Toy> {

    UUID uuid;

    public ToysList(UUID uuid, List<Toy> list) {
        super(list);
        this.setUuid(uuid);
    }

    public ToysList(UUID uuid) {
        super();
        this.setUuid(uuid);
    }

    public ToysList() {
        super();
        this.setUuid(UUID.randomUUID());
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean isEmpty() {
        return this.getList().isEmpty();
    }

    @Override
    public int size() {
        return this.getList().size();
    }

    @Override
    public void clear() {
        this.getList().clear();
    }

    @Override
    public boolean add(Toy toy) {
        return this.getList().add(toy);
    }

    @Override
    public void add(int index, Toy toy) {
        this.getList().add(index, toy);
    }

    @Override
    public Toy get(int index) throws IndexOutOfBoundsException {
        return this.getList().remove(index);
    }

    @Override
    public Toy pop() throws NoSuchElementException {

        Toy toy;
        try {
            toy = this.get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
        return toy;
    }

    @Override
    public Iterator<Toy> iterator() {
        return this.getList().iterator();
    }

    @Override
    public void forEach(Consumer<? super Toy> action) {
        super.forEach(action);
    }

    @Override
    public Spliterator<Toy> spliterator() {
        return super.spliterator();
    }

}
