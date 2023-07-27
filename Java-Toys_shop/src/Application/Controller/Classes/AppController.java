package Application.Controller.Classes;

import Application.Controller.Interfaces.LootBoxControllerInterface;
import Application.Controller.Interfaces.ViewControllerInterface;
import Application.Model.Classes.EntityFabric;
import Application.Model.Classes.LootBox;
import Application.View.Classes.View;

public class AppController {

    private ViewControllerInterface view;

    private LootBoxControllerInterface model;

    public AppController() {

        ViewControllerInterface viewController = new ViewController(new View());
        this.setView(viewController);

        EntityFabric fabric = new EntityFabric();
        LootBox lootBox = new LootBox(fabric);
        LootBoxControllerInterface lootBoxController = new LootBoxController(lootBox);
        this.setModel(lootBoxController);
        
    }

    public ViewControllerInterface getView() {
        return view;
    }

    public void setView(ViewControllerInterface view) {
        this.view = view;
    }

    public LootBoxControllerInterface getModel() {
        return model;
    }

    public void setModel(LootBoxControllerInterface model) {
        this.model = model;
    }

    public void mainLoot() {

    }

}
