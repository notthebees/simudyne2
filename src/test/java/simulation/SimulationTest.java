package simulation;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class SimulationTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Mock
    private ResultsCalculator resultsCalculator;

    @Test
    public void getsResultsFromResultsCalculator() {
        final ArrayList<Agent> agents = new ArrayList<>();
        Simulation simulation = new Simulation(agents, resultsCalculator, null);

        Result result = new Result(42, 42, 42, 42, 42);
        context.checking(new Expectations() {{
            oneOf(resultsCalculator).calculateResults(agents); will(returnValue(result));
        }});

        List<Result> results = simulation.run(0);
        assertThat(results, contains(result));
    }

    @Test
    public void outputsResultsForEachIterationPlusInitialResults() {
        Simulation simulation = new Simulation(new ArrayList<>(), new FunctionalResultsCalculator(), null);

        List<Result> results = simulation.run(13);

        assertThat(results.size(), equalTo(14));
    }
}