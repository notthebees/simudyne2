package simulation.parsing;

import org.junit.Test;
import simulation.agent.Agent;

import java.io.File;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static simulation.agent.Breed.C;
import static simulation.agent.Breed.NC;

public class DataParserTest {

    @Test
    public void parsesListOfAgentsWithBreeds() throws Exception {
        DataParser parser = new DataParser();
        File file = new File(getClass().getResource("/test_input.csv").getFile());

        List<Agent> agents = parser.parse(file);
        assertThat(agents.size(), equalTo(2));
        assertThat(agents.get(0).breed, equalTo(C));
        assertThat(agents.get(1).breed, equalTo(NC));
    }
}