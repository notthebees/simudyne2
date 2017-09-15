package simulation.results;

import org.junit.Test;
import simulation.agent.Agent;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static simulation.agent.Breed.C;
import static simulation.agent.Breed.NC;

public class FunctionalResultsCalculatorTest {

    @Test
    public void calculatesNumberOfCAgentsAndNCAgentsForSingleIterationInSimulationHistory() {
        List<Agent> agents = new ArrayList<>();
        agents.add(new Agent(C));
        agents.add(new Agent(NC));
        agents.add(new Agent(NC));

        SimulationHistory history = new SimulationHistory();
        history.add(agents);

        FunctionalResultsCalculator calculator = new FunctionalResultsCalculator();
        List<Result> results = calculator.calculateResults(history);
        Result result = results.get(0);

        assertThat(result.breedCAgents, equalTo(1));
        assertThat(result.breedNCAgents, equalTo(2));
    }
}