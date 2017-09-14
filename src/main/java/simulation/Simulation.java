package simulation;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final List<Result> results = new ArrayList<>();
    private final List<Agent> agents;
    private final ResultsCalculator resultsCalculator;

    public Simulation(List<Agent> agents, ResultsCalculator resultsCalculator, AgentUpdater updater) {
        this.agents = agents;
        this.resultsCalculator = resultsCalculator;
    }

    public List<Result> run(int numIterations) {
        results.add(resultsCalculator.calculateResults(agents));
        for (int i = 0; i < numIterations; i++) {
            results.add(resultsCalculator.calculateResults(agents));
        }
        return new ArrayList<>(results);
    }
}
