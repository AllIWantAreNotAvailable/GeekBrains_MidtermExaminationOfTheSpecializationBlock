package Controller.Interfaces;

import View.Classes.View;

public interface ViewControllerInterface<V extends View> extends ControllerInterface {

    V getView();

    void setView(V view);

}
