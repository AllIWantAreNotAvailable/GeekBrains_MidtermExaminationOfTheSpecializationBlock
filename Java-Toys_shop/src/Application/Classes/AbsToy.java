package Application.Classes;

import Application.Interfaces.InterToy;

import java.util.Objects;

public abstract class AbsToy extends AbsEntity implements InterToy {
    protected String name;

    public AbsToy(String name) {
        super();
        this.setName(name);
    }

}
