
package org.thebaseballrun;

public class RouteLocation {
    Double lng;
    Double lat;
    String name;
    String description;
    Long db_id;

    public RouteLocation(Double lng, Double lat, String name, Long db_id) {
        this.lng = lng;
        this.lat = lat;
        this.name = name;
        this.db_id = db_id;
    }

    public Double getLng() {
        return lng;
    }

    public Double getLat() {
        return lat;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getDb_id() {
        return db_id;
    }
}
