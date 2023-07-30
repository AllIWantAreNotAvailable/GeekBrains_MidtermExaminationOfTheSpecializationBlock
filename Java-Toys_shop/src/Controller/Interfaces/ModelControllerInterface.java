package Controller.Interfaces;

import Model.Classes.Model;

public interface ModelControllerInterface<M extends Model> extends ControllerInterface {

    M getModel();

    void setModel(M model);

}
