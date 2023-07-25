package Application.Classes;

import Application.Interfaces.InterBox;

import java.util.ArrayList;
import java.util.List;

public abstract class AbsBox<T extends AbsEntity> extends AbsEntity implements InterBox<T> {

    protected List<T> box;

    public AbsBox(List<T> box) {
        this.setBox(box);
    }

    public AbsBox() {
        this.setBox(new ArrayList<>());
    }

}
