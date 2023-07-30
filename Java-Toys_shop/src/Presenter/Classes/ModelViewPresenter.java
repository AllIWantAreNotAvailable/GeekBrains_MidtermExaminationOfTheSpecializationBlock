package Presenter.Classes;

import Controller.Classes.LootBoxModelController;
import Controller.Classes.LootBoxViewController;
import Model.Classes.Toy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModelViewPresenter extends Presenter<LootBoxModelController, LootBoxViewController> {

    public ModelViewPresenter(LootBoxModelController modelController, LootBoxViewController viewController) {
        super(modelController, viewController);
    }

    public ModelViewPresenter() {
        this(new LootBoxModelController(), new LootBoxViewController());
    }

    private void makeLog(String logMessage) {
        Logger logger = Logger.getAnonymousLogger();
        FileHandler logHandler = null;
        try {
            logHandler = new FileHandler("win_logs.log");
            logger.addHandler(logHandler);
            String loggerString = String.format("%s\n", logMessage);
            logger.log(Level.INFO, loggerString);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        if (logHandler != null) {
            logHandler.close();
        }

    }

    private int parseUserChoice(String intro, boolean showInstruction) {
        int choice = 0;
        try {
            choice = Integer.parseInt(this.getViewController().scanInput(intro, showInstruction));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            this.getViewController().showMessage("Не удалось определить выбор. Ошибка ввода, повторите ввод.\n");
        } catch (Exception e) {
            e.printStackTrace();
            this.getViewController().showMessage("Непредвиденная ошибка, повторите ввод.\n");
        }
        return choice;
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
        if (!this.getModelController().isEmpty()) {
            UUID choice = UUID.fromString(this.getViewController().scanInput("Укажите UUID игрушки", false));
            this.getModelController().remove(choice);
        }
    }

    private void changePrizeProbability() {
        this.showPrizes();
        if (!this.getModelController().isEmpty()) {
            UUID choice = UUID.fromString(this.getViewController().scanInput("Укажите UUID игрушки", false));
            int newProbability = this.parseUserChoice("Укажите новую вероятность выпадения", false);
            this.getModelController().changeLootingProbability(choice, newProbability);
        }
    }

    private void addPrize() {
        boolean showInstructions = false;
        String toysName = this.getViewController().scanInput("Введите название игрушки:", showInstructions);
        int numberOf = this.parseUserChoice("Укажите количество для розыгрыша", showInstructions);
        String intro = "Введите вероятность выпадения (0 < ... <= 100)";
        int lootingProbability = this.parseUserChoice(intro, showInstructions);
        while (lootingProbability < 0 || 100 < lootingProbability) {
            this.getViewController().showMessage("Вероятность должна находится в диапазоне 0 < ... <= 100\n");
            lootingProbability  = this.parseUserChoice(intro, showInstructions);
        }
        this.getModelController().put(toysName, numberOf, lootingProbability);
    }

    private void showPrizes() {
        StringBuilder text = new StringBuilder();
        if (this.getModelController().isEmpty()) {
            text.append("Нет призов для розыгрыша!\n");
        } else {
            for (Map.Entry<UUID, String> entry :
                    this.getModelController().showLootingProbabilities().entrySet()) {
                text.append(String.format("UUID: %s -> %s\n", entry.getKey(), entry.getValue()));
            }
        }
        this.getViewController().showMessage(text.toString());
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
        boolean response = true;
        boolean goOn = true;
        while (goOn) {
            int choice = this.parseUserChoice(intro, true);
            switch (choice) {
                case 1 -> this.showPrizes();
                case 2 -> this.addPrize();
                case 3 -> this.changePrizeProbability();
                case 4 -> this.removePrize();
                case 5 -> goOn = false;
                case 6 -> {
                    response = false;
                    goOn = false;
                }
            }
        }
        return response;
    }

    private void nextTicket() {
        if (this.getModelController().isEmpty()) {
            this.getViewController().showMessage("Нет призов для розыгрыша!\n");
        } else  {
            Toy prize = this.getModelController().get();
            String winnerMessage = String.format("Поздравляем, вы выиграли:\n%s\n", prize);
            String loserMessage = "К сожалению, вы проиграли, повезет в следующий раз...\n";
            if (prize != null) {
                this.makeLog(prize.toString());
                this.getViewController().showMessage(winnerMessage);
            } else {
                this.getViewController().showMessage(loserMessage);
            }
        }
    }

    private boolean startLottery() {
        Map<Integer, String> mainMenu = new HashMap<>()
        {{
            put(1, "Разыграть билет.");
            put(2, "В главное меню.");
            put(3, "Закрыть программу.");

        }};
        String intro = getIntro(mainMenu);
        boolean response = true;
        boolean goOn = true;
        while (goOn) {
            int choice = this.parseUserChoice(intro, true);
            switch (choice) {
                case 1 -> this.nextTicket();
                case 2 -> goOn = false;
                case 3 -> {
                    response = false;
                    goOn = false;
                }
            }
        }
        return response;
    }

    private boolean mainMenu() {
        Map<Integer, String> mainMenu = new HashMap<>()
        {{
            put(1, "Настроить розыгрыш.");
            put(2, "Начать розыгрыш.");
            put(3, "Выйти.");

        }};
        String intro = getIntro(mainMenu);
        int choice = this.parseUserChoice(intro, true);
        return switch (choice) {
            case 1 -> this.setUp();
            case 2 -> this.startLottery();
            case 3 -> false;
            default -> true;
        };
    }

    @Override
    public void startApplication() {
        String message = """
                Добро пожаловать в приложение для розыгрыша игрушек!

                Перед тем как начать розыгрыш нужно добавить призы для победителей.
                
                """;
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
