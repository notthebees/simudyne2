package simulation;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BreedUpdaterTest {

    @Test
    public void doesNotUpdateIfAutoRenewTrue() {
        BreedUpdater updater = new BreedUpdater(null);
        Agent agent = new AgentBuilder().withAutoRenew().build();

        assertThat(updater.update(agent, 42), equalTo(agent));
    }
}