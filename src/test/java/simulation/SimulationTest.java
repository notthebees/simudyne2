package simulation;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;
import simulation.agent.Agent;
import simulation.agent.AgentUpdater;
import simulation.results.ResultsCalculator;

import java.util.ArrayList;
import java.util.List;

import static simulation.agent.Breed.C;
import static simulation.agent.Breed.NC;

public class SimulationTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Mock
    private ResultsCalculator resultsCalculator;

    @Mock
    private AgentUpdater updater;

    @Test
    public void appliesUpdaterToAgentsOnEachIteration() throws Exception {
        Agent agent1 = new Agent(C);
        Agent agent2 = new Agent(NC);
        Agent updatedAgent1 = new Agent(NC);
        Agent updatedAgent2 = new Agent(C);

        final List<Agent> agents = new ArrayList<>();
        agents.add(agent1);
        agents.add(agent2);
        Simulation simulation = new Simulation(agents, resultsCalculator, updater);

        context.checking(new Expectations() {{
            oneOf(updater).update(agent1, 1); will(returnValue(updatedAgent1));
            oneOf(updater).update(agent2, 1); will(returnValue(updatedAgent2));

            oneOf(updater).update(updatedAgent1, 2);
            oneOf(updater).update(updatedAgent2, 2);

            ignoring(resultsCalculator);
        }});

        simulation.run(2);
    }
}