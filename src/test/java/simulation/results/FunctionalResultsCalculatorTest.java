package simulation.results;

import org.junit.Test;
import simulation.agent.Agent;
import simulation.agent.AgentBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static simulation.agent.Breed.C;
import static simulation.agent.Breed.NC;

public class FunctionalResultsCalculatorTest {

    @Test
    public void calculatesNumberOfAgentsAndLostAndGained() {
        Agent agent1 = agent().withBreed(C).withBreedCGained().build();
        Agent agent2 = agent().withBreed(NC).withBreedCLost().build();
        Agent agent3 = agent().withBreed(NC).build();
        Agent agent4 = agent().withBreed(NC).withBreedCLost().build();

        List<Agent> agents = new ArrayList<>();
        agents.add(agent1);
        agents.add(agent2);
        agents.add(agent3);
        agents.add(agent4);

        SimulationHistory history = new SimulationHistory();
        history.add(agents);

        FunctionalResultsCalculator calculator = new FunctionalResultsCalculator();
        Result result = calculator.calculateResults(agents);

        assertThat(result.breedCAgents, equalTo(1));
        assertThat(result.breedNCAgents, equalTo(3));
        assertThat(result.breedCLost, equalTo(2));
        assertThat(result.breedCGained, equalTo(1));
    }

    private AgentBuilder agent() {
        return new AgentBuilder();
    }
}