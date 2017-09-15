package simulation.results;

import org.junit.Test;
import simulation.agent.Agent;
import simulation.agent.AgentBuilder;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static simulation.agent.Breed.C;
import static simulation.agent.Breed.NC;

public class FunctionalResultsCalculatorTest {

    @Test
    public void calculatesNumberOfAgentsAndLostGainedAndRegained() {
        Agent agent1 = agent().withBreed(C).withBreedCGained().build();
        Agent agent2 = agent().withBreed(NC).withBreedCLost().build();
        Agent agent3 = agent().withBreed(NC).build();
        Agent agent4 = agent().withBreed(NC).withBreedCLost().build();
        Agent agent5 = agent().withBreed(C).withBreedCGained().withBreedCRegained().build();

        List<Agent> agents = newArrayList(agent1, agent2, agent3, agent4, agent5);

        SimulationHistory history = new SimulationHistory();
        history.add(agents);

        FunctionalResultsCalculator calculator = new FunctionalResultsCalculator();
        Result result = calculator.calculateResults(agents);

        assertThat(result.breedCAgents, equalTo(2));
        assertThat(result.breedNCAgents, equalTo(3));
        assertThat(result.breedCLost, equalTo(2));
        assertThat(result.breedCGained, equalTo(2));
        assertThat(result.breedCRegained, equalTo(1));
    }

    private AgentBuilder agent() {
        return new AgentBuilder();
    }
}