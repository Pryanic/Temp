package calculator;/*
 * Copyright (c) 2018 Tideworks Technology, Inc.
 */

import javafx.util.Pair;
import model.Load;
import provider.DistanceProvider;
import provider.GeoDistanceProvider;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author ivan.hladush(ihladush)
 * @since 0.11
 */
public class NNATSPCalculator implements TSPCalculator {

    private static DistanceProvider distanceProvider = new GeoDistanceProvider();

    @Override
    public Map<Integer, Long> calculate(Pair<Double, Double> startLocation, List<Load> loads) {
        final Map<Long, Map<Long, Double>> distances = new HashMap<>();
        distances.put(0L, new HashMap<>());

        for (Load load : loads) {
            final Long loadId = load.getLoadId();
            distances.put(loadId, new HashMap<>());
            distances.get(0L).put(loadId, distanceProvider.distance(startLocation, load) + load.getDist());
            distances.get(loadId).put(0L, distanceProvider.distance(startLocation, load));
            final Pair<Double, Double> loadStartLocation = new Pair<>(load.getFiishLat(), load.getFinishLng());

            for (Load load1 : loads) {
                if (!load1.getLoadId().equals(loadId)) {
                    distances.get(loadId).put(load1.getLoadId(),
                                              distanceProvider.distance(loadStartLocation, load1) + load1.getDist());
                }
            }
        }

        return calculateViaDistance(distances);
    }

    @Override
    public Map<Integer, Long> calculateViaDistance(final Map<Long, Map<Long, Double>> distances) {
        final Map<Integer, Long> result = new HashMap<>();
        final Set<Long> used = new HashSet<>();

        long start = 0L;

        for (int i = 0; i < distances.size(); ++i) {
            used.add(start);
            result.put(i, start);
            start = findNotUsedMin(distances.get(start), used);
        }

        return result;
    }

    private Long findNotUsedMin(final Map<Long, Double> distances, Set<Long> used) {
        double minDistance = Integer.MAX_VALUE + 1.0;
        Long result = -1L;

        for (Map.Entry<Long, Double> entry : distances.entrySet()) {
            if (entry.getValue() <= minDistance && !used.contains(entry.getKey())) {
                result = entry.getKey();
                minDistance = entry.getValue();
            }
        }

        return result;
    }

}
