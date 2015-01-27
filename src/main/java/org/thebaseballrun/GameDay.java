package org.thebaseballrun;

import org.joda.time.DateTime;

/**
 * A GameDay object represents a specific baseball game:
 * it includes the time of the game, the location (encoded
 * as the homeTeam), and the opponent.
 */
public class GameDay {

    DateTime gameTime;
    RouteLocation homeTeam;
    RouteLocation visitingTeam;

    public GameDay(DateTime gameTime, RouteLocation homeTeam, RouteLocation visitingTeam) {
        this.gameTime = gameTime;
        this.homeTeam = homeTeam;
        this.visitingTeam = visitingTeam;
    }

    public DateTime getGameTime() {
        return gameTime;
    }

    public RouteLocation getHomeTeam() {
        return homeTeam;
    }

    public RouteLocation getVisitingTeam() {
        return visitingTeam;
    }
}
