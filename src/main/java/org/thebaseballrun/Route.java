package org.thebaseballrun;

import java.util.List;

public class Route {
    List<RouteLocation> routeStops;

    public Route(List<RouteLocation> routeStops) {
        this.routeStops = routeStops;
    }

    public List<RouteLocation> getRouteStops() {
        return routeStops;
    }

    public void addStopToRoute(RouteLocation newStop) {
        routeStops.add(newStop);
    }
}
