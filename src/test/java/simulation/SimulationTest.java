package simulation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimulationTest {

    @Test
    public void outputsResultsForEachIterationPlusInitialResults() throws Exception {
        Simulation simulation = new Simulation(new ArrayList<>(), new FunctionalResultsCalculator());

        List<Result> results = simulation.run(13);

        assertThat(results.size(), equalTo(14));
    }
}