package org.thebaseballrun;

import org.joda.time.DateTime;
import org.json.simple.JSONObject;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import java.util.List;
import java.util.Set;

public class Neo4jRouteScheduler implements RouteScheduler {

    GraphDatabaseService neo4jgraph = null;

    public Neo4jRouteScheduler(GraphDatabaseService neo4jgraph) {
        this.neo4jgraph = neo4jgraph;
    }

    @Override
    public int loadRouteNodes(JSONObject points) {
        return 0;
    }

    @Override
    public int loadRouteNodes(Set<GameDay> points) {
        int nodesAdded = 0;

        try (Transaction tx = neo4jgraph.beginTx()) {
            for (GameDay game : points) {
                Node homeGameNode = neo4jgraph.createNode();
                homeGameNode.setProperty("date", game.getGameTime().toString());
                homeGameNode.setProperty("name", game.getHomeTeam().getName());
                homeGameNode.setProperty("gid",  game.getHomeTeam().getDb_id());

                nodesAdded++;
            }
            tx.success();
        }

        return nodesAdded;
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
