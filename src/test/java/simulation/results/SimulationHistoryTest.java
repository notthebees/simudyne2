package simulation.results;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;
import simulation.agent.Agent;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class SimulationHistoryTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Mock
    private ResultsCalculator calculator;

    @Test
    public void appliesResultsCalculatorToEachIterationOfHistory() throws Exception {
        List<Agent> agents1 = new ArrayList<>();
        List<Agent> agents2 = new ArrayList<>();

        SimulationHistory history = new SimulationHistory();
        history.add(agents1);
        history.add(agents2);
        Result result1 = new Result(42, 42, 42, 42, 42);
        Result result2 = new Result(43, 43, 43, 43, 43);

        context.checking(new Expectations() {{
            oneOf(calculator).calculateResults(agents1); will(returnValue(result1));
            oneOf(calculator).calculateResults(agents2); will(returnValue(result2));
        }});

        List<Result> results = history.getResults(calculator);
        assertThat(results, contains(result1, result2));
    }
}