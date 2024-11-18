package sk.uniba.fmph.dcs.game_board;

import sk.uniba.fmph.dcs.stone_age.Effect;

import java.util.*;

public final class VariableBuilding implements Building {
    private final int numberOfResources;
    private final int numberOfResourceTypes;

    public VariableBuilding(int numberOfResources, int numberOfResourceTypes){
        this.numberOfResources = numberOfResources;
        this.numberOfResourceTypes = numberOfResourceTypes;
    }

    @Override
    public OptionalInt build(final Collection<Effect> resources) {
        if (resources == null || resources.isEmpty()) {
            return OptionalInt.empty();
        }

        if(!checkResourcesMatching(resources)){
            throw new IllegalArgumentException("Resources does not match the building requirements");
        }

        int sum = 0;
        for (Effect resource : resources) {
            sum += resource.points();
        }
        return OptionalInt.of(sum);
    }

    private boolean checkResourcesMatching(final Collection<Effect> resources){
        if(resources.size() > numberOfResources){
            return false;
        }
        int resourceTypesCounter = 0;
        Set<Effect> set = new HashSet<>();
        for(Effect resource: resources){
            if(!set.contains(resource)){
                set.add(resource);
                resourceTypesCounter++;
            }
        }
        return resourceTypesCounter == numberOfResourceTypes;

    }

    @Override
    public String state() {
        return "";
    };
}
