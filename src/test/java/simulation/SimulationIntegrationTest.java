package simulation;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimulationIntegrationTest {

    @Test
    public void outputResultsForInitialData() throws Exception {
        File file = new File(getClass().getResource("/test_input.csv").getFile());
        DataParser parser = new DataParser();
        List<Agent> agents = parser.parse(file);

        Simulation simulation = new Simulation(agents, new FunctionalResultsCalculator());
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
