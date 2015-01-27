package org.thebaseballrun;

import org.joda.time.DateTime;
import org.json.simple.JSONObject;

import java.util.List;

public class Neo4jRouteScheduler implements RouteScheduler {
    @Override
    public int loadRouteLocations(JSONObject points) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int loadRouteLocations(List<RouteLocation> points) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int loadSchedule(JSONObject schedule) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int loadSchedule(List<GameDay> schedule) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Route> computeRoutesOfLengthInDays(int lengthInDays) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Route> computeRoutesOfLengthInGames(int lengthInGames) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Route> computeRoutesOfLengthInDaysStartingAtLocation(RouteLocation start, int lengthInDays) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Route> computeRoutesOfLengthInGamesStartingAtLocation(RouteLocation start, int lengthInGames) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Route> computeRoutesInTimeFrame(DateTime start, DateTime end) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Route> computeRoutesInTimeFrameStartingAtLocation(DateTime start, DateTime end, RouteLocation startLocation) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
