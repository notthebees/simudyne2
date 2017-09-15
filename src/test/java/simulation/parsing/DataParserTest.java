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
    public void parsesListOfAgents() throws Exception {
        DataParser parser = new DataParser();
        File file = new File(getClass().getResource("/test_input.csv").getFile());

        List<Agent> agents = parser.parse(file);
        assertThat(agents.size(), equalTo(2));

        assertThat(agents.get(0).breed, equalTo(C));
        assertThat(agents.get(0).socialGrade, equalTo(3));
        assertThat(agents.get(0).paymentAtPurchase, equalTo(250));
        assertThat(agents.get(0).attributeBrand, equalTo(25.3));
        assertThat(agents.get(0).attributePrice, equalTo(16.6));
        assertThat(agents.get(0).attributePromotions, equalTo(5.1));
        assertThat(agents.get(0).autoRenew, equalTo(false));
        assertThat(agents.get(0).inertiaForSwitch, equalTo(4));

        assertThat(agents.get(1).breed, equalTo(NC));
        assertThat(agents.get(1).socialGrade, equalTo(2));
        assertThat(agents.get(1).paymentAtPurchase, equalTo(375));
        assertThat(agents.get(1).attributeBrand, equalTo(12.8));
        assertThat(agents.get(1).attributePrice, equalTo(24.0));
        assertThat(agents.get(1).attributePromotions, equalTo(2.8));
        assertThat(agents.get(1).autoRenew, equalTo(false));
        assertThat(agents.get(1).inertiaForSwitch, equalTo(10));
    }
}