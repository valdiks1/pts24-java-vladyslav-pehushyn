package sk.uniba.fmph.dcs.game_board;

import sk.uniba.fmph.dcs.stone_age.Effect;
import java.util.Collection;
import java.util.OptionalInt;

public final class ArbitraryBuilding implements Building {
    private final int maxNumberOfResources = 7;

    public OptionalInt build(final Collection<Effect> resources) {
        if (resources == null || resources.isEmpty() || resources.size() > maxNumberOfResources ) {
            return OptionalInt.empty();
        }

        int sum = 0;
        for (Effect resource : resources) {
            sum += resource.points();
        }
        return OptionalInt.of(sum);
    }

    @Override
    public String state() {
        return "";
    }
}
