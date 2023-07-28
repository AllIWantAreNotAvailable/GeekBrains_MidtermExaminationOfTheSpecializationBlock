import Model.Classes.Toy;
import Model.Classes.ToyFabric;
import Model.Classes.ToysList;
import Model.Classes.ToysListFabric;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
         toyTests();
         toysFabricTests();
         toyListTests();
         toyListFabricTests();
    }

    private static void toyTests() {
        String defaultName = "Default toy #";

        for (int i = 0; i < 10; i++) {
            Toy toy = new Toy(String.format("%s%d", defaultName, i));
            System.out.println(toy);
        }
    }

    private static void toysFabricTests() {
        String defaultName = "Default toy #";
        ToyFabric toyFabric = new ToyFabric();

        for (int i = 0; i < 10; i++) {
            Toy toy = toyFabric.generate(String.format("%s%d", defaultName, i));
            System.out.println(toy);
        }
    }

    private static void toyListTests() {
        List<Toy> toys = new ArrayList<>();
        String defaultName = "Default toy #";

        for (int i = 0; i < 10; i++) {
            Toy toy = new Toy(String.format("%s%d", defaultName, i));
            toys.add(toy);
        }

        ToysList<Toy> toysList = new ToysList<>(toys);
        System.out.println(toysList);
    }

    private static void toyListFabricTests() {
        ToysListFabric toysListFabric = new ToysListFabric(new ToyFabric());
        ToysList<Toy> toysList = toysListFabric.generate("Default toy", 10);
        System.out.println(toysList);
    }

}