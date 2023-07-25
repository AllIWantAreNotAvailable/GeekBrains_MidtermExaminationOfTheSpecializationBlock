package Application.Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class ToyBox<T extends AbsToy> extends AbsBox<T> {

    public ToyBox(List<T> box) {
        super(box);
    }

    public ToyBox() {
        super(new ArrayList<>());
    }

    @Override
    protected void initialize() {
        this.setUuid(null);
    }

    @Override
    public void setBox(List<T> box) {
        super.box = box;
    }

    @Override
    public List<T> getBox() {
        return super.box;
    }

    @Override
    public UUID getUuid() {
        return super.uuid;
    }

    @Override
    public void setUuid(UUID uuid) {
        super.uuid = uuid;
    }

    @Override
    public boolean isEmpty() {
        return this.getBox().isEmpty();
    }

    @Override
    public void add(T entity) {
        this.getBox().add(entity);
    }

    @Override
    public void add(List<T> toys) {
        Random random = new Random();
        for (T toy :
                toys) {
            this.getBox().add(random.nextInt(0, this.getBox().size()), toy);
        }
    }

    @Override
    public T pop() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.getBox().remove(0);
        }
    }

    @Override
    public List<T> pop(int number) {
        List<T> temp = new ArrayList<>(number);
        for (int i = 0; i < number; i++) {
            T popped = this.pop();
            if (popped == null) break;
            else temp.add(popped);
        }
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(String.format("ToyBox{uuid='%s', ", getUuid()));
        if (this.isEmpty()) stringBuilder.append(String.format("isEmpty=%b", this.isEmpty()));
        else stringBuilder.append(String.format("box=%s", getBox()));
        return stringBuilder.append('}').toString();
    }
}
