package org.thebaseballrun;


import org.joda.time.DateTime;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Set;

public interface RouteScheduler {

    // Load Data
    public int loadRouteNodes(JSONObject points);
    public int loadRouteNodes(Set<GameDay> points);

    public int loadSchedule(JSONObject schedule);
    public int loadSchedule(List<GameDay> schedule);

    // Route Queries
    public List<Route> computeRoutesOfLengthInDays(int lengthInDays);
    public List<Route> computeRoutesOfLengthInGames(int lengthInGames);

    public List<Route> computeRoutesOfLengthInDaysStartingAtLocation(RouteLocation start, int lengthInDays);
    public List<Route> computeRoutesOfLengthInGamesStartingAtLocation(RouteLocation start, int lengthInGames);

    public List<Route> computeRoutesInTimeFrame(DateTime start, DateTime end);
    public List<Route> computeRoutesInTimeFrameStartingAtLocation(DateTime start, DateTime end, RouteLocation startLocation);
}
