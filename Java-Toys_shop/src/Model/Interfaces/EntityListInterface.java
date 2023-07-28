package Model.Interfaces;

import Model.Classes.Entity;

import java.util.List;

public interface EntityListInterface<E extends Entity<?>> extends ModelInterface<E>, List<E> {

    List<E> getEntityList();

    void setEntityList(List<E> entityList);

}
