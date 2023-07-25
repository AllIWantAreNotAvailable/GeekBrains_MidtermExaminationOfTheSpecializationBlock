package Application.Classes;

import java.util.Objects;
import java.util.UUID;

public class PrizeToy extends AbsToy {

    public PrizeToy(String name) {
        super(name);
    }

    @Override
    public UUID getUuid() {
        return super.uuid;
    }

    @Override
    public void setUuid(UUID uuid) {
        super.uuid = uuid;
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public void setName(String name) {
        super.name = name;
    }

    @Override
    protected void initialize() {
        // todo UUID generator
        this.setUuid(null);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AbsToy absToy)) return false;
        return Objects.equals(getName(), absToy.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getName());
    }

    @Override
    public String toString() {
        return "PrizeToy{" +
                "uuid=" + this.getUuid() +
                ", name='" + this.getName() + '\'' +
                '}';
    }

}
