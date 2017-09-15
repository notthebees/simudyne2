package simulation.results;

import simulation.agent.Agent;

import java.util.List;

import static simulation.agent.Breed.C;

public class FunctionalResultsCalculator implements ResultsCalculator {

    @Override
    public Result calculateResults(List<Agent> agents) {
        int breedCAgents = (int) agents.stream()
                .filter(agent -> agent.breed.equals(C))
                .count();
        int breedNCAgents = agents.size() - breedCAgents;

        return new Result(breedCAgents, breedNCAgents, 0, 0, 0);
    }
}
