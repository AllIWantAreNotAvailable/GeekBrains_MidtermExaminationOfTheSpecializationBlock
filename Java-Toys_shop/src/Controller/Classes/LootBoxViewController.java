package Controller.Classes;

import View.Classes.LootBoxView;
import View.Interfaces.LootBoxViewInterface;

import java.util.Scanner;

public class LootBoxViewController extends ViewController<LootBoxView> implements LootBoxViewInterface {

    public LootBoxViewController(LootBoxView view) {
        super(view);
    }

    public LootBoxViewController() {
        this(new LootBoxView());
    }

    @Override
    public Scanner getScanner() {
        return super.getView().getScanner();
    }

    @Override
    public void setScanner(Scanner scanner) {
        super.getView().setScanner(scanner);
    }

    @Override
    public void showMessage(String message) {
        super.getView().showMessage(message);
    }

    @Override
    public String scanInput(String introduction) {
        return super.getView().scanInput(introduction);
    }

}
