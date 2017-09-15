package simulation;

import simulation.agent.Agent;
import simulation.agent.AgentUpdater;
import simulation.results.Result;
import simulation.results.ResultsCalculator;
import simulation.results.SimulationHistory;

import java.util.ArrayList;
import java.util.List;

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

    public SimulationHistory run(int numIterations) {
        SimulationHistory history = new SimulationHistory();
        results.add(resultsCalculator.calculateResults(agents));
        history.add(agents);
        for (int i = 0; i < numIterations; i++) {
            final int iteration = i + 1;
            agents = agents.stream()
                    .map(agent -> updater.update(agent, iteration))
                    .collect(toList());
            results.add(resultsCalculator.calculateResults(agents));
            history.add(agents);
        }
        return history;
    }
}
