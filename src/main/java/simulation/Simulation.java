package simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Simulation {

    private final List<Result> results = new ArrayList<>();
    private List<Agent> agents;
    private final AgentUpdater updater;
    private final ResultsCalculator resultsCalculator;

    public Simulation(List<Agent> agents, ResultsCalculator resultsCalculator, AgentUpdater updater) {
        this.agents = agents;
        this.resultsCalculator = resultsCalculator;
        this.updater = updater;
    }

    public List<Result> run(int numIterations) {
        results.add(resultsCalculator.calculateResults(agents));
        for (int i = 0; i < numIterations; i++) {
            final int iteration = i + 1;
            agents = agents.stream()
                    .map(agent -> updater.update(agent, iteration))
                    .collect(toList());
            results.add(resultsCalculator.calculateResults(agents));
        }
        return new ArrayList<>(results);
    }
}
