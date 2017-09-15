package simulation;

import org.junit.Test;
import simulation.agent.Agent;
import simulation.agent.AgentUpdater;
import simulation.agent.BreedUpdater;
import simulation.parsing.DataParser;
import simulation.random.MockRandom;
import simulation.results.FunctionalResultsCalculator;
import simulation.results.Result;
import simulation.results.ResultsCalculator;
import simulation.results.SimulationHistory;

import java.io.File;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimulationIntegrationTest {

    @Test
    public void outputResultsForInitialDataPlusOneIteration() throws Exception {
        File file = new File(getClass().getResource("/test_input.csv").getFile());
        DataParser parser = new DataParser();
        List<Agent> agents = parser.parse(file);

        AgentUpdater updater = new BreedUpdater(new MockRandom());
        Simulation simulation = new Simulation(agents, updater);
        SimulationHistory history = simulation.run(1);

        ResultsCalculator resultsCalculator = new FunctionalResultsCalculator();
        List<Result> results = history.getResults(resultsCalculator);
        assertThat(results.size(), equalTo(2));

        Result result0 = results.get(0);
        assertThat(result0.breedCAgents, equalTo(1));
        assertThat(result0.breedNCAgents, equalTo(1));
        assertThat(result0.breedCLost, equalTo(0));
        assertThat(result0.breedCGained, equalTo(0));
        assertThat(result0.breedCRegained, equalTo(0));

        Result result1 = results.get(1);
        assertThat(result1.breedCAgents, equalTo(0));
        assertThat(result1.breedNCAgents, equalTo(2));
        assertThat(result1.breedCLost, equalTo(1));
        assertThat(result1.breedCGained, equalTo(0));
        assertThat(result1.breedCRegained, equalTo(0));
    }
}
