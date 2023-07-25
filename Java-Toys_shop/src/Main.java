import Application.Classes.PrizeToy;
import Application.Classes.ToyBox;
import Application.Classes.ToyFabric;
import Application.Interfaces.InterFabric;

public class Main {
    public static void main(String[] args) {
        InterFabric<PrizeToy, ToyBox<PrizeToy>> fabric = new ToyFabric();
        System.out.println(fabric.getEntity());
        System.out.println(new ToyBox<PrizeToy>());
        System.out.println(fabric.getEntity(10));
    }
}