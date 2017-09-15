package simulation;

import org.junit.Test;
import simulation.agent.Agent;
import simulation.agent.AgentUpdater;
import simulation.agent.BreedUpdater;
import simulation.parsing.DataParser;
import simulation.random.MockRandom;
import simulation.results.FunctionalResultsCalculator;
import simulation.results.Result;

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
        Simulation simulation = new Simulation(agents, new FunctionalResultsCalculator(), updater);

        List<Result> results = simulation.run(1);
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

    @Test
    public void outputResultsForInitialData() throws Exception {
        File file = new File(getClass().getResource("/test_input.csv").getFile());
        DataParser parser = new DataParser();
        List<Agent> agents = parser.parse(file);

        Simulation simulation = new Simulation(agents, new FunctionalResultsCalculator(), null);
        List<Result> results = simulation.run(0);
        assertThat(results.size(), equalTo(1));

        Result result = results.get(0);
        assertThat(result.breedCAgents, equalTo(1));
        assertThat(result.breedNCAgents, equalTo(1));
        assertThat(result.breedCLost, equalTo(0));
        assertThat(result.breedCGained, equalTo(0));
        assertThat(result.breedCRegained, equalTo(0));
    }
}
