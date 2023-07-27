package Application.View.Classes;

import Application.View.Interfaces.ViewInterface;

import java.util.Scanner;

public class View implements ViewInterface {

    @Override
    public void output(String[] strings, String separator, String end) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string :
                strings) {
            stringBuilder.append(string)
                    .append(separator);
        }
        stringBuilder.append(end);
        System.out.printf("%s", stringBuilder);
    }

    @Override
    public void output(String[] strings, String separator) {
        this.output(strings, separator, "\n");
    }

    @Override
    public void output(String[] strings) {
        this.output(strings, " ", "\n");
    }

    @Override
    public String input(String[] introduction, String separator, String end) {
        this.output(introduction, separator, end);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public String input(String[] introduction, String separator) {
        this.output(introduction, separator, "\n");
        return this.input(introduction, separator, "\n>>> ");
    }

    @Override
    public String input(String[] introduction) {
        this.output(introduction, " ", "\n");
        return this.input(introduction, " ", "\n>>> ");
    }

}
