package Controller.Classes;

import View.Classes.View;
import Controller.Interfaces.ViewControllerInterface;
import View.Interfaces.ViewInterface;

public abstract class ViewController<V extends View> implements ViewControllerInterface<V>, ViewInterface {

    private V view;

    public ViewController(V view) {
        this.setView(view);
    }

    public V getView() {
        return view;
    }

    public void setView(V view) {
        this.view = view;
    }

}
