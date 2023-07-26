import Application.Classes.ToysLootBox;
import Application.Classes.implToyFabric;

public class Main {
    public static void main(String[] args) {
        ToysLootBox lootBox = new ToysLootBox(new implToyFabric());
        lootBox.initialize(1, 10);
        for (int i = 0; i < 10; i++) {
            System.out.println(lootBox.open());
        }
    }

}