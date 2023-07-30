package Presenter.Interface;

import Controller.Classes.ModelController;
import Controller.Classes.ViewController;

public interface PresentInterface<M extends ModelController<?>, V extends ViewController<?>> {

    M getModelController();

    void setModelController(M modelController);

    V getViewController();

    void setViewController(V viewController);

    void startApplication();

}
