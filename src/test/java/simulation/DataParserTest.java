package simulation;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static simulation.Breed.C;
import static simulation.Breed.NC;

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