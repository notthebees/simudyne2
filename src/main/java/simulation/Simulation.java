package simulation;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private List<Result> results = new ArrayList<>();
    public Simulation(List<Agent> agents, ResultsCalculator resultProcessor) {

    }

    public List<Result> run(int numIterations) {
        results.add(new Result());
        for (int i = 0; i < numIterations; i++) {
            results.add(new Result());
        }
        return new ArrayList<>(results);
    }
}
