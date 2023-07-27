package Controller.Classes;

import Model.Classes.Model;
import Model.Interfaces.ModelInterface;

public abstract class ModelController<M extends Model<?>> extends Controller<ModelController<M>> implements ModelInterface<M> {
}
