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

        int breedCLost = (int) agents.stream()
                .filter(agent -> agent.breedCLost)
                .count();
        int breedCGained = (int) agents.stream()
                .filter(agent -> agent.breedCGained)
                .count();
        int breedCRegained = (int) agents.stream()
                .filter(agent -> agent.breedCRegained)
                .count();

        return new Result(breedCAgents, breedNCAgents, breedCLost, breedCGained, breedCRegained);
    }
}
