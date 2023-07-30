package Controller.Classes;

import Controller.Interfaces.ModelControllerInterface;
import Model.Classes.Model;

public abstract class ModelController<M extends Model> extends Controller implements ModelControllerInterface<M> {

    private M model;

    public ModelController(M model) {
        this.setModel(model);
    }

    @Override
    public M getModel() {
        return model;
    }

    @Override
    public void setModel(M model) {
        this.model = model;
    }

}
