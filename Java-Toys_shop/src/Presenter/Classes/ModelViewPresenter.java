package Presenter.Classes;

import Controller.Classes.LootBoxModelController;
import Controller.Classes.LootBoxViewController;

import java.util.HashMap;
import java.util.Map;

public class ModelViewPresenter extends Presenter<LootBoxModelController, LootBoxViewController> {

    public ModelViewPresenter(LootBoxModelController modelController, LootBoxViewController viewController) {
        super(modelController, viewController);
    }

    public ModelViewPresenter() {
        this(new LootBoxModelController(), new LootBoxViewController());
    }

    private int parseUserChoice(String intro) throws NumberFormatException {
        return Integer.parseInt(this.getViewController().scanInput(intro));
    }

    private static String getIntro(Map<Integer, String> mainMenu) {
        StringBuilder intro = new StringBuilder();
        for (Map.Entry<Integer, String> entry :
                mainMenu.entrySet()) {
            intro.append(String.format("%d) %s\n", entry.getKey(), entry.getValue()));
        }
        return intro.toString();
    }

    private boolean setUp() {
        Map<Integer, String> setUpMenu = new HashMap<>()
        {{
            put(1, "Показать все призы.");
            put(2, "Добавить приз.");
            put(3, "Изменить вероятность выпадения приза.");
            put(4, "Удалить приз.");
            put(5, "В главное меню.");
            put(6, "Закрыть программу.");

        }};
        String intro = getIntro(setUpMenu);
        return switch (parseUserChoice(intro)) {
            case 1 -> true;
            case 2 -> true;
            case 3 -> true;
            case 4 -> true;
            case 5 -> true;
            case 6 -> false;
            default -> true;
        };

    }

    private boolean mainMenu() {
        Map<Integer, String> mainMenu = new HashMap<>()
        {{
            put(1, "Настроить розыгрыш.");
            put(2, "Начать розыгрыш.");
            put(3, "Выйти.");

        }};
        String intro = getIntro(mainMenu);
        return switch (parseUserChoice(intro)) {
            case 1 -> true;
            case 2 -> true;
            case 3 -> false;
            default -> true;
        };
    }

    @Override
    public void startApplication() {
        String message = "Добро пожаловать в приложение для розыгрыша игрушек!\n\n" +
                "Перед тем как начать розыгрыш нужно добавить призы для победителей.\n";
        super.getViewController().showMessage(message);
        this.mainLoop();
    }

    @Override
    protected void mainLoop() {

        boolean goOn = true;
        while (goOn) {
            goOn = this.mainMenu();
        }

    }
}
