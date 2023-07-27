package Application.Controller.Interfaces;

import Application.View.Classes.View;
import Application.View.Interfaces.ViewInterface;

public interface ViewControllerInterface extends ViewInterface {

    View getView();

    void setView(View view);

}
