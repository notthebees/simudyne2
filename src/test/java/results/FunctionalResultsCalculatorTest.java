package results;

import org.junit.Test;
import simulation.agent.Agent;
import simulation.results.FunctionalResultsCalculator;
import simulation.results.Result;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static simulation.agent.Breed.C;
import static simulation.agent.Breed.NC;

public class FunctionalResultsCalculatorTest {

    @Test
    public void calculatesNumberOfCAgentsAndNCAgents() throws Exception {
        List<Agent> agents = new ArrayList<>();
        agents.add(new Agent(C));
        agents.add(new Agent(NC));
        agents.add(new Agent(NC));

        FunctionalResultsCalculator calculator = new FunctionalResultsCalculator();
        Result result = calculator.calculateResults(agents);

        assertThat(result.breedCAgents, equalTo(1));
        assertThat(result.breedNCAgents, equalTo(2));
    }
}