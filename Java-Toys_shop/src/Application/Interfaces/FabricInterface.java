package Application.Interfaces;

import java.util.Map;
import java.util.UUID;

public interface FabricInterface<E extends EntityInterface, L extends EntityListInterface<E>> {

    E generate(UUID uuid, String name);

    E generate (String name);

    E generate();

    L generate(Map<UUID, String> uuidNamePairs);

    L generate(String[] names);

    L generate(int numberOf);

}
