/*
 * Copyright (c) 2018 Tideworks Technology, Inc.
 */
package provider;

/**
 * @author ivan.hladush(ihladush)
 * @since 0.11
 */
public class DecartDistanceProvider extends DistanceProvider {

    @Override
    public double distance(final double startLat, final double startLng, final double finishLat,
                           final double finishLng) {
        return Math.sqrt((finishLat - startLat) * (finishLat - startLat) +
                                 (finishLng - startLng) * (finishLng - startLng));
    }
}
