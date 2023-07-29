import Model.Classes.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
        lootingTests();
    }

    private static void lootingTests() throws Exception {
        LootBox lootBox = new LootBox();
        lootBox.put("Prize", 1, 20);
        lootBox.put("Bronze prize", 1, 15);
        lootBox.put("Silver prize", 1, 10);
        lootBox.put("Gold prize", 1, 5);
        lootBox.put("Super prize", 1, 1);

        Map<UUID, String> map = lootBox.showLootingProbabilities();
        extracted(map);
        Scanner scanner = new Scanner(System.in);
        System.out.printf("UUID: ");
        UUID uuid = UUID.fromString(scanner.nextLine());
        System.out.printf("new Probability: ");
        int lootingProbability = scanner.nextInt();
        lootBox.changeLootingProbability(uuid, lootingProbability);
        map = lootBox.showLootingProbabilities();
        extracted(map);
    }

    private static void extracted(Map<UUID, String> map) {
        for (Map.Entry<UUID, String> entry :
                map.entrySet()) {
            System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());
        }
    }
}