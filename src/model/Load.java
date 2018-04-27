/*
 * Copyright (c) 2018 Tideworks Technology, Inc.
 */
package model;

/**
 * @author ivan.hladush(ihladush)
 * @since 0.11
 */
public class Load {

    Long loadId;
    double startLng;
    double startLat;
    double finishLng;
    double fiishLat;
    double dist;

    public Load() {
    }

    public Load(final long loadId,
                final double startLng,
                final double startLat,
                final double finishLng,
                final double fiishLat,
                final double dist) {
        this.loadId = loadId;
        this.startLng = startLng;
        this.startLat = startLat;
        this.finishLng = finishLng;
        this.fiishLat = fiishLat;
        this.dist = dist;
    }

    public double getStartLng() {
        return startLng;
    }

    public void setStartLng(final double startLng) {
        this.startLng = startLng;
    }

    public double getStartLat() {
        return startLat;
    }

    public void setStartLat(final double startLat) {
        this.startLat = startLat;
    }

    public double getFinishLng() {
        return finishLng;
    }

    public void setFinishLng(final double finishLng) {
        this.finishLng = finishLng;
    }

    public double getFiishLat() {
        return fiishLat;
    }

    public void setFiishLat(final double fiishLat) {
        this.fiishLat = fiishLat;
    }

    public double getDist() {
        return dist;
    }

    public void setDist(final double dist) {
        this.dist = dist;
    }

    public Long getLoadId() {
        return loadId;
    }

    public void setLoadId(final long loadId) {
        this.loadId = loadId;
    }

    @Override
    public String toString() {
        return "Load{" +
                "startLng=" + startLng +
                ", startLat=" + startLat +
                ", finishLng=" + finishLng +
                ", fiishLat=" + fiishLat +
                ", dist=" + dist +
                '}';
    }
}
