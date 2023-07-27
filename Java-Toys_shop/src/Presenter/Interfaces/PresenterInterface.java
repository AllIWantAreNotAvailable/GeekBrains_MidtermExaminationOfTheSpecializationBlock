package Presenter.Interfaces;

import Controller.Classes.ModelController;
import Controller.Classes.ViewController;
import Presenter.Classes.Presenter;

public interface PresenterInterface<P extends Presenter<? extends ViewController<?>, ? extends ModelController<?>>> {

    void mainLoop();

}
