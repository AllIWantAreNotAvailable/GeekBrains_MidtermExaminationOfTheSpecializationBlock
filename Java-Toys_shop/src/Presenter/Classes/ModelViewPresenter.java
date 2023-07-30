package Presenter.Classes;

import Controller.Classes.LootBoxModelController;
import Controller.Classes.LootBoxViewController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ModelViewPresenter extends Presenter<LootBoxModelController, LootBoxViewController> {

    public ModelViewPresenter(LootBoxModelController modelController, LootBoxViewController viewController) {
        super(modelController, viewController);
    }

    public ModelViewPresenter() {
        this(new LootBoxModelController(), new LootBoxViewController());
    }

    private int parseUserChoice(String intro, boolean showInstruction) throws NumberFormatException {
        return Integer.parseInt(this.getViewController().scanInput(intro, showInstruction));
    }

    private static String getIntro(Map<Integer, String> menu) {
        StringBuilder intro = new StringBuilder();
        for (Map.Entry<Integer, String> entry :
                menu.entrySet()) {
            intro.append(String.format("%d) %s\n", entry.getKey(), entry.getValue()));
        }
        return intro.toString();
    }

    private void removePrize() {
        this.showPrizes();
        UUID choice = UUID.fromString(this.getViewController().scanInput("Укажите UUID игрушки", false));
        this.getModelController().remove(choice);
    }

    private void changePrizeProbability() {
        this.showPrizes();
        UUID choice = UUID.fromString(this.getViewController().scanInput("Укажите UUID игрушки", false));
        int newProbability = this.parseUserChoice("Укажите новую вероятность выпадения", false);
        this.getModelController().changeLootingProbability(choice, newProbability);
    }

    private void addPrize() {
        boolean showInstructions = false;
        String toysName = this.getViewController().scanInput("Введите название игрушки", showInstructions);
        int numberOf = this.parseUserChoice("Укажите количество для розыгрыша", showInstructions);
        String intro = "Введите вероятность выпадения (0 < ... <= 100)";
        int lootingProbability = this.parseUserChoice(intro, showInstructions);
        while (lootingProbability < 0 || 100 < lootingProbability) {
            this.getViewController().showMessage("Вероятность должна находится в диапазоне 0 < ... <= 100");
            lootingProbability  = this.parseUserChoice(intro, showInstructions);
        }
        this.getModelController().put(toysName, numberOf, lootingProbability);
    }

    private void showPrizes() {
        StringBuilder text = new StringBuilder();
        for (Map.Entry<UUID, String> entry :
                this.getModelController().showLootingProbabilities().entrySet()) {
            text.append(String.format("UUID: %s -> %s\n", entry.getKey(), entry.getValue()));
        }
        this.getViewController().showMessage(text.toString());
    }

    private void setUp() {
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

    }

    private void mainMenu() {
        Map<Integer, String> mainMenu = new HashMap<>()
        {{
            put(1, "Настроить розыгрыш.");
            put(2, "Начать розыгрыш.");
            put(3, "Выйти.");

        }};
        String intro = getIntro(mainMenu);

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
            goOn = false;
        }

    }
}
