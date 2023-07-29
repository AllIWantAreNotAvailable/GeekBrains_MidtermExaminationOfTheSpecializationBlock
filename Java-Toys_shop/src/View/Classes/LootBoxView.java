package View.Classes;

import Model.Classes.Toy;

import java.util.Scanner;

public class LootBoxView {

    private Scanner scanner;

    public LootBoxView(Scanner scanner) {
        this.scanner = scanner;
    }

    public LootBoxView() {
        this.setScanner(new Scanner(System.in));
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Boolean askQuestion(String question) {
        System.out.printf("%s?\nВыберите вариант:\n1. Да\n2. Нет", question);
        int choice = this.getScanner().nextInt();
        return switch (choice) {
            case 1 -> true;
            case 2 -> false;
            default -> null;
        };
    }

    public String getToysName() {
        String intro = "Введите название игрушки";
        System.out.printf("%s: ", intro);
        return this.getScanner().nextLine();
    }

    public Integer getNumberOfToys() {
        String intro = "Введите количество игрушек";
        System.out.printf("%s: ", intro);
        return this.getScanner().nextInt();
    }

    public Integer getLootingProbability(){
        String intro = "Введите вероятность выпадения игрушки";
        System.out.printf("%s: ", intro);
        return this.getScanner().nextInt();
    }

    public void showWinning(Toy toy) {
        if (toy == null) {
            System.out.println("К сожалению, вы ничего не выиграли... попробуйте в следующий раз");
        } else {
            System.out.printf("Поздравляем, вы выиграли:\n%s", toy);
        }
    }

}
