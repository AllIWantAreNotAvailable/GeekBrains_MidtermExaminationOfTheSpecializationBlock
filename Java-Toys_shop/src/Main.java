import Model.Classes.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        lootingTests();
    }

    private static void lootingTests() {
        LootBox lootBox = new LootBox();
        lootBox.put("Prize", 1, 20);
        lootBox.put("Bronze prize", 1, 15);
        lootBox.put("Silver prize", 1, 10);
        lootBox.put("Gold prize", 1, 5);
        lootBox.put("Super prize", 1, 1);

        List<Toy> prizes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Toy prize = lootBox.get();
            if (prize != null) {
                prizes.add(prize);
            }
        }
        for (int i = 0; i < prizes.size(); i++) {
            System.out.printf("%d) %s\n", i + 1, prizes.get(i));
        }

    }
}