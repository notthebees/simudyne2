package simulation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static simulation.AgentType.C;
import static simulation.AgentType.NC;

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