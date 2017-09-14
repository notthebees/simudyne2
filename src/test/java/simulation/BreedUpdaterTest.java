package simulation;


import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static simulation.Breed.C;
import static simulation.Breed.NC;

public class BreedUpdaterTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Mock
    private MyRandom random;

    @Test
    public void switchesBreedToNCWhenAffinityBelowThreshold() {
        BreedUpdater updater = new BreedUpdater(random);

        Agent agent = agent()
                .withBreed(C)
                .withSocialGrade(1)
                .withPaymentAtPurchase(0)
                .withAttributeBrand(1)
                .withAttributePrice(1).build();

        context.checking(new Expectations() {{
            oneOf(random).nextDouble(); will(returnValue(0.0));
        }});

        Agent updatedAgent = updater.update(agent, 42);
        assertThat(updatedAgent.breed, equalTo(NC));
    }

    private AgentBuilder agent() {
        return new AgentBuilder();
    }

    @Test
    public void doesNotUpdateIfAutoRenewTrue() {
        BreedUpdater updater = new BreedUpdater(null);
        Agent agent = agent().withAutoRenew().build();

        assertThat(updater.update(agent, 42), equalTo(agent));
    }
}