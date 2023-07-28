package Model.Interfaces;

import java.util.UUID;

public interface EntityInterface extends ModelInterface {

    UUID getUuid();

    void setUuid(UUID uuid);

}
