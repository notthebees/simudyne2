package simulation;

import simulation.agent.Agent;
import simulation.agent.AgentUpdater;
import simulation.results.SimulationHistory;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Simulation {

    private List<Agent> agents;
    private final AgentUpdater updater;

    public Simulation(List<Agent> agents, AgentUpdater updater) {
        this.agents = agents;
        this.updater = updater;
    }

    public SimulationHistory run(int numIterations) {
        SimulationHistory history = new SimulationHistory();
        history.add(agents);
        for (int i = 0; i < numIterations; i++) {
            final int iteration = i + 1;
            agents = agents.stream()
                    .map(agent -> updater.update(agent, iteration))
                    .collect(toList());
            history.add(agents);
        }
        return history;
    }
}
