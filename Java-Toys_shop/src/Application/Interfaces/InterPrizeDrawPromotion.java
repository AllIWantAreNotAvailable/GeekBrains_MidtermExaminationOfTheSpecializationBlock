package Application.Interfaces;

import Application.Classes.AbsToy;

import java.util.List;

public interface InterPrizeDrawPromotion<T extends AbsToy> {

    T generate();

    List<T> generate(int number);

}
