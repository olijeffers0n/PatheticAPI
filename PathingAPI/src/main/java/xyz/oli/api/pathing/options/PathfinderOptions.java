package xyz.oli.api.pathing.options;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import xyz.oli.api.pathing.strategy.PathfinderStrategy;
import xyz.oli.api.wrapper.PathLocation;

@Value
@Builder
@AllArgsConstructor
/* not sure if still needed for only 3 args */
public class PathfinderOptions {
    
    PathLocation start;
    PathLocation target;
    PathfinderStrategy strategy;

    public PathfinderOptions(@NonNull PathfinderOptionsBuilder builder) {
        this.start = builder.start;
        this.target = builder.target;
        this.strategy = builder.strategy;
    }
}