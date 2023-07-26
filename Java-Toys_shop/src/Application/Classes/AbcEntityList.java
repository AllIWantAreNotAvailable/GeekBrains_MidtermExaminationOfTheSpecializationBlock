package Application.Classes;

import Application.Interface.EntityList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbcEntityList<E extends AbcEntity> implements EntityList<E> {

    List<E> list;

    public AbcEntityList(List<E> list) {
        this.setList(list);
    }

    public AbcEntityList() {
        this.setList(new ArrayList<>());
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbcEntityList<?> that)) return false;
        return Objects.equals(this.getList(), that.getList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getList());
    }

    @Override
    public String toString() {
        return "AbsEntityList{" +
                "list=" + this.getList() +
                '}';
    }

}
