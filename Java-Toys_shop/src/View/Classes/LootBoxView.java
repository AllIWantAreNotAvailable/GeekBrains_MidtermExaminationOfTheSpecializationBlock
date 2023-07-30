package View.Classes;

import View.Interfaces.LootBoxViewInterface;

import java.util.Scanner;

public class LootBoxView extends View implements LootBoxViewInterface {

    private Scanner scanner;

    public LootBoxView(Scanner scanner) {
        this.scanner = scanner;
    }

    public LootBoxView() {
        this.setScanner(new Scanner(System.in));
    }

    @Override
    public Scanner getScanner() {
        return scanner;
    }

    @Override
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void showMessage(String message) {
        System.out.printf("\n%s", message);
    }

    @Override
    public String scanInput(String introduction, boolean showInstruction) {
        String instruction = "\n(Впишите номер команды и нажмите ввод (клавиша Enter) для выбора)";
        this.showMessage(String.format("%s%s\n>>> ", introduction, showInstruction ? instruction : ""));
        return this.getScanner().nextLine();
    }

}
