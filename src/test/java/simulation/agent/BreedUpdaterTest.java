package simulation.agent;


import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;
import simulation.random.MyRandom;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static simulation.agent.Breed.C;
import static simulation.agent.Breed.NC;

public class BreedUpdaterTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Mock
    private MyRandom random;

    @Test
    public void switchesBreedToCWhenAffinityBelowThreshold() {
        BreedUpdater updater = new BreedUpdater(random);

        Agent agent = agent()
                .withBreed(NC)
                .withSocialGrade(1)
                .withPaymentAtPurchase(0)
                .withAttributeBrand(1)
                .withAttributePrice(1).build();

        context.checking(new Expectations() {{
            oneOf(random).nextDouble(); will(returnValue(0.0));
        }});

        Agent updatedAgent = updater.update(agent, 42);
        assertThat(updatedAgent.breed, equalTo(C));
    }

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
}