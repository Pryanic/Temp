/*
 * Copyright (c) 2018 Tideworks Technology, Inc.
 */
package model;

/**
 * @author ivan.hladush(ihladush)
 * @since 0.11
 */
public class Truck {

    double lng;
    double lat;

    public Truck() {
    }

    public Truck(final double lng, final double lat) {
        this.lng = lng;
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "lng=" + lng +
                ", lat=" + lat +
                '}';
    }
}
