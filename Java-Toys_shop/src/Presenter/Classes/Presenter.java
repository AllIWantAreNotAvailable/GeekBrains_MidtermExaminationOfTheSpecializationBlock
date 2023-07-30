package Presenter.Classes;

import Controller.Classes.ModelController;
import Controller.Classes.ViewController;
import Presenter.Interface.PresentInterface;

public abstract class Presenter<M extends ModelController<?>, V extends ViewController<?>> implements PresentInterface<M, V> {

    private M modelController;
    private V viewController;

    public Presenter(M modelController, V viewController) {
        this.setModelController(modelController);
        this.setViewController(viewController);
    }

    protected abstract void mainLoop();

    @Override
    public M getModelController() {
        return modelController;
    }

    @Override
    public void setModelController(M modelController) {
        this.modelController = modelController;
    }

    @Override
    public V getViewController() {
        return viewController;
    }

    @Override
    public void setViewController(V viewController) {
        this.viewController = viewController;
    }

}
