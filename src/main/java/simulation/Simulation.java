package simulation;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final List<Result> results = new ArrayList<>();

    public Simulation(List<Agent> agents, FunctionalResultsCalculator resultProcessor) {

    }

    public List<Result> run(int numIterations) {
        results.add(new Result(0, 0, 0, 0, 0));
        for (int i = 0; i < numIterations; i++) {
            results.add(new Result(0, 0, 0, 0, 0));
        }
        return new ArrayList<>(results);
    }
}
