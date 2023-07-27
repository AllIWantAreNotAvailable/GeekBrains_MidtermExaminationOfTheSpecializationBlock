package Application.Controller.Classes;

import Application.Controller.Interfaces.ViewControllerInterface;
import Application.View.Classes.View;

public class ViewController implements ViewControllerInterface {

    private View view;

    public ViewController(View view) {
        this.view = view;
    }

    @Override
    public View getView() {
        return view;
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void output(String[] strings, String separator, String end) {
        this.getView().output(strings, separator, end);
    }

    @Override
    public void output(String[] strings, String separator) {
        this.getView().output(strings, separator);
    }

    @Override
    public void output(String[] strings) {
        this.getView().output(strings);
    }

    @Override
    public String input(String[] introduction, String separator, String end) {
        return this.getView().input(introduction, separator, end);
    }

    @Override
    public String input(String[] introduction, String separator) {
        return this.getView().input(introduction, separator);
    }

    @Override
    public String input(String[] introduction) {
        return this.getView().input(introduction);
    }

}
