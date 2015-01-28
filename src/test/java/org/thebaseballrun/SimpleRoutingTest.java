package org.thebaseballrun;

import com.google.common.collect.Sets;
import junit.framework.Assert;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.test.TestGraphDatabaseFactory;
import org.neo4j.tooling.GlobalGraphOperations;

/**
 * Simple tests for RouteScheduler.
 */
public class SimpleRoutingTest
{
    private GraphDatabaseService graphDb;
    private RouteScheduler router;

    @Before
    public void setup() {
        graphDb = new TestGraphDatabaseFactory().newImpermanentDatabase();
        router = new Neo4jRouteScheduler(graphDb);
    }

    @After
    public void cleanup() {
        graphDb.shutdown();
    }

    /**
     *
     */
    @Test
    public void testLoadRouteLocation() {

        // create some test data
        RouteLocation dodgerStadium = new RouteLocation(118.2400, 34.0736, "Dodger Stadium", 12345l);
        RouteLocation buschStadium = new RouteLocation(90.1931, 38.6225, "Busch Stadium", 67890l);
        DateTime gameTime = DateTime.now();
        GameDay fakeDodgersGame = new GameDay(gameTime, dodgerStadium, buschStadium);

        // load test data
        int locationsAdded = router.loadRouteNodes(Sets.newHashSet(fakeDodgersGame));
        Assert.assertEquals(1, locationsAdded);

        // peek into the db to check what was written
        int nodeCount = 0;
        try (Transaction tx = graphDb.beginTx()) {
            Iterable<Node> allNodes = GlobalGraphOperations.at(graphDb).getAllNodes();
            for (Node node : allNodes) {
                nodeCount++;
                Assert.assertEquals("Dodger Stadium", node.getProperty("name"));
                Assert.assertEquals(12345l, node.getProperty("gid"));
                DateTime retrievedDate = DateTime.parse((String) node.getProperty("date"));
                Assert.assertTrue(gameTime.isEqual(retrievedDate));
            }
        }

        Assert.assertEquals(1, nodeCount); // we expect only one node, so fail if there are more or less
    }
}
