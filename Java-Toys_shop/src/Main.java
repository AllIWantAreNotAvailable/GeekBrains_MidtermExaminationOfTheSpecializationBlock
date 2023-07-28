import Model.Classes.Toy;
import Model.Classes.ToyFabric;
import Model.Classes.ToysList;
import Model.Classes.ToysListFabric;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // toyTests();
        // toyListTests();
        // toysFabricTests();
        // toyListFabricTests();
    }

    private static void toyTests() {
//        String defaultName = "Default toy #";
//
//        for (int i = 0; i < 10; i++) {
//            Toy<Toy<?>> toy = new Toy<>(String.format("%s%d", defaultName, i));
//            System.out.println(toy);
//        }
    }

    private static void toysFabricTests() {
//        String defaultName = "Default toy #";
//        ToyFabric<Toy<?>> toyFabric = new ToyFabric<>();
//
//        for (int i = 0; i < 10; i++) {
//            Toy<Toy<?>> toy = toyFabric.generate(String.format("%s%d", defaultName, i));
//            System.out.println(toy);
//        }
    }

    private static void toyListTests() {
//        List<Toy<?>> toys = new ArrayList<>();
//        String defaultName = "Default toy #";
//
//        for (int i = 0; i < 10; i++) {
//            Toy<Toy<?>> toy = new Toy<>(String.format("%s%d", defaultName, i));
//            toys.add(toy);
//        }
//
//        ToysList<Toy<?>> toysList = new ToysList<>(toys);
//        System.out.println(toysList);
    }

    private static void toyListFabricTests() {
//        List<Toy<?>> toys = new ArrayList<>();
//        String defaultName = "Default toy #";
//
//        ToyFabric<Toy<?>> toyFabric = new ToyFabric<>();
//        ToysListFabric<Toy<?>> toyToysListFabric = new ToysListFabric<>();
//
//        for (int i = 0; i < 10; i++) {
//            Toy<Toy<?>> toy = toyFabric.generate(String.format("%s%d", defaultName, i));
//            toys.add(toy);
//        }
//
//        ToysList<Toy<?>> toysList = toyToysListFabric.generate(toys);
//        System.out.println(toysList);
    }

}