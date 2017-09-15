package simulation.agent;

import simulation.agent.Agent;

public interface AgentUpdater {
    Agent update(Agent agent, int iteration);
}
