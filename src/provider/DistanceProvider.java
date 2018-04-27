package provider;

import javafx.util.Pair;
import model.Load;

import java.util.Map;

public abstract class DistanceProvider {

    public double calculateDistance(Pair<Double, Double> startPosition,
                                    Map<Long, Load> loads,
                                    Map<Integer, Long> sequence) {
        final Load lastLoad = loads.get(sequence.get(sequence.size() - 1));
        double result = distance(startPosition.getKey(),
                                 startPosition.getValue(),
                                 lastLoad.getFiishLat(),
                                 lastLoad.getFinishLng());

        for (int i = 1; i < sequence.size(); ++i) {
            final Load load = loads.get(sequence.get(i));
            result += distance(startPosition, load) + load.getDist();
            startPosition = new Pair<>(load.getFiishLat(), load.getFinishLng());
        }

        return result;
    }

    public double distance(Pair<Double, Double> startPosition, Load load) {
        return distance(startPosition.getKey(), startPosition.getValue(), load.getStartLat(), load.getFinishLng());
    }

    public abstract double distance(double startLat, double startLng, double finishLat, double finishLng);
}
