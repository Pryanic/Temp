import calculator.NNATSPCalculator;
import calculator.TSPCalculator;
import javafx.util.Pair;
import model.Load;
import provider.DecartDistanceProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    static DecartDistanceProvider decartDistanceProvide = new DecartDistanceProvider();
    static TSPCalculator calculator = new NNATSPCalculator();

    public static void main(String[] args) {
//        final Load load1 = new Load(10, 0., 3, 0., 3., 0.);
//        final Load load2 = new Load(23, 2., 3, 2., 3., 0.);
//        final Load load3 = new Load(36, 2., 0, 2., 0., 0.);
//        final List<Load> loads = new ArrayList<>();
//        loads.add(load1);
//        loads.add(load2);
//        loads.add(load3);
//        final Pair<Double, Double> startPosition = new Pair<>(0., 0.);
//        final Map<Integer, Long> result = calculator.calculate(startPosition, loads);
//        System.out.println(result);
        final Map<Long, Map<Long, Double>> map = new HashMap<>();
        final HashMap<Long, Double> first = new HashMap<>();
        first.put(0L, 0.0);
        first.put(1L, 10.0);
        first.put(2L, 20.0);
        first.put(4L, 30.0);
        map.put(0L, first);

        final HashMap<Long, Double> second = new HashMap<>();
        second.put(0L, 20.0);
        second.put(1L, 0.0);
        second.put(2L, 30.0);
        second.put(3L, 40.0);
        map.put(1L, second);

        final HashMap<Long, Double> third = new HashMap<>();
        third.put(0L, 30.0);
        third.put(1L, 40.0);
        third.put(2L, 0.0);
        third.put(3L, 50.0);
        map.put(2L, third);


        final HashMap<Long, Double> fourth = new HashMap<>();
        fourth.put(0L, 40.0);
        fourth.put(1L, 50.0);
        fourth.put(2L, 60.0);
        fourth.put(3L, 0.0);
        map.put(3L, fourth);
        final Map<Integer, Long> integerLongMap = calculator.calculateViaDistance(map);
        System.out.println(integerLongMap);
//        System.out.println(decartDistanceProvide.calculateDistance(startPosition, loads.stream().collect(
//                Collectors.toMap(Load::getLoadId, x -> x)), result));
    }


}

