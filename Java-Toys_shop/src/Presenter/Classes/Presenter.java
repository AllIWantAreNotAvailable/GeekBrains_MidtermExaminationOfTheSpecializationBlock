package Presenter.Classes;

import Controller.Classes.ModelController;
import Controller.Classes.ViewController;
import Model.Classes.Model;
import Presenter.Interfaces.PresenterInterface;
import View.Classes.View;

public abstract class Presenter<V extends ViewController<? extends View<?>>, M extends ModelController<? extends Model<?>>> implements PresenterInterface {

}
