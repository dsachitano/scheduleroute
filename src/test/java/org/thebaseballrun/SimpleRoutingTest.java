package org.thebaseballrun;

import com.google.common.collect.Lists;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Simple tests for RouteScheduler.
 */
public class SimpleRoutingTest
{
    private RouteScheduler router;

    @Before
    public void setup() {
        router = new Neo4jRouteScheduler();
    }

    @After
    public void cleanup() {

    }

    /**
     *
     */
    @Test
    public void testLoadRouteLocation() {
        int locationsAdded = router.loadRouteLocations(Lists.newArrayList(new RouteLocation(-12.3, 45.6, "Dodger Stadium", 123l)));
        Assert.assertEquals(1, locationsAdded);
    }
}
