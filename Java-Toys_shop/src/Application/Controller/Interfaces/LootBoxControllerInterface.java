package Application.Controller.Interfaces;

import Application.Model.Classes.LootBox;
import Application.Model.Interfaces.LootBoxInterface;

public interface LootBoxControllerInterface extends LootBoxInterface {

    LootBox getLootBox();

    void setLootBox(LootBox lootBox);

}
