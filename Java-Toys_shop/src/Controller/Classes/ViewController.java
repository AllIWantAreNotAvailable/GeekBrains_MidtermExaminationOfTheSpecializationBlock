package Controller.Classes;

import View.Classes.View;
import View.Interfaces.ViewInterface;

public abstract class ViewController<V extends View<?>> extends Controller<ViewController<V>> implements ViewInterface<V> {
}
