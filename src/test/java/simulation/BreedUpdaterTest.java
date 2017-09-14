package simulation;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static simulation.Breed.C;

public class BreedUpdaterTest {

    @Test
    public void doesNotUpdateIfAutoRenewTrue() {
        BreedUpdater updater = new BreedUpdater(null);
        Agent agent = new Agent(C, 0, 0, 0, 0, 0, true, 0);

        assertThat(updater.update(agent, 42), equalTo(agent));
    }
}