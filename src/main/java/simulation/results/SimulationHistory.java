package simulation.results;

import simulation.agent.Agent;

import java.util.ArrayList;
import java.util.List;

public class SimulationHistory {

    private final List<List<Agent>> history = new ArrayList<>();

    public void add(List<Agent> agents) {
        history.add(agents);
    }

    public List<Agent> get(int i) {
        return history.get(i);
    }

    public List<Result> getResults(ResultsCalculator resultsCalculator) {
        List<Result> results = new ArrayList<>();
        for (List<Agent> agents : history) {
            results.add(resultsCalculator.calculateResults(agents));
        }
        return results;
    }
}
