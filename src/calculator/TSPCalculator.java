/*
 * Copyright (c) 2018 Tideworks Technology, Inc.
 */
package calculator;

import javafx.util.Pair;
import model.Load;

import java.util.List;
import java.util.Map;

/**
 * @author ivan.hladush(ihladush)
 * @since 0.11
 */
public interface TSPCalculator {

    Map<Integer, Long> calculate(Pair<Double, Double> startLocation, List<Load> loads);

    Map<Integer, Long> calculateViaDistance(Map<Long, Map<Long, Double>>  distances);
}
