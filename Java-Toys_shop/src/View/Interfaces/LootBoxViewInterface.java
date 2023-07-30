package View.Interfaces;

import java.util.Scanner;

public interface LootBoxViewInterface extends ViewInterface {

    Scanner getScanner();

    void setScanner(Scanner scanner);

    void showMessage(String message);

    String scanInput(String introduction);

}
