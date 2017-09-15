package simulation.results;

import simulation.agent.Agent;

import java.util.List;

public interface ResultsCalculator {

    Result calculateResults(List<Agent> agents);

    List<Result> calculateResults(SimulationHistory history);
}
