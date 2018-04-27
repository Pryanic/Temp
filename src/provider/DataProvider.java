/*
 * Copyright (c) 2018 Tideworks Technology, Inc.
 */
package provider;


import model.Load;
import model.Truck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author ivan.hladush(ihladush)
 * @since 0.11
 */
public class DataProvider {

    private static final Random rnd = new Random(1234);
    private static DistanceProvider distanceProvider = new GeoDistanceProvider();

    public static List<Truck> createTrucks() {
        final List<Truck> result = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            final double startLat = 2 * rnd.nextDouble();
            final double startLng = 2 * rnd.nextDouble();
            result.add(new Truck(startLat, startLng));
        }
        return result;
    }

    public static List<Load> createLoads() {
        final List<Load> result = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            final double startLat = 2 * rnd.nextDouble();
            final double startLng = 2 * rnd.nextDouble();
            final double finishLat = 2 * rnd.nextDouble();
            final double finishLng = 2 * rnd.nextDouble();
            final double distance = distanceProvider.distance(startLat, startLng, finishLat, finishLng);
            result.add(new Load(i, startLat, startLng, finishLat, finishLng, distance));
        }
        return result;
    }
}
