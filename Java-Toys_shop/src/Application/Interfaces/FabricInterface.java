package Application.Interfaces;

import java.util.List;
import java.util.UUID;

public interface FabricInterface<E extends EntityInterface, L extends EntityListInterface<E>> {

    E generate(UUID uuid, String name);

    E generate (String name);

    E generate();

    L generate(List<UUID> uuids, String name);

    L generate(int numberOf, String name);

    L generate(int numberOf);

}
