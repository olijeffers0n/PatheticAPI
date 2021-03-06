package xyz.ollieee.model.strategy;

import lombok.NonNull;
import xyz.ollieee.api.pathing.strategy.PathfinderStrategy;
import xyz.ollieee.api.wrapper.PathBlock;

/**
 * A {@link PathfinderStrategy} to find the direct path to a given endpoint
 */
public class DirectPathfinderStrategy implements PathfinderStrategy {

    @Override
    public boolean isValid(@NonNull PathBlock current, PathBlock previous, PathBlock previouser) {
        return current.isPassable();
    }

}
