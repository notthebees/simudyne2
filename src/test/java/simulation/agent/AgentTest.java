package simulation.agent;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static simulation.agent.Breed.C;
import static simulation.agent.Breed.NC;

public class AgentTest {

    @Test
    public void setsBreedCGainedFlagWhenSwitchingFromNCToC() {
        Agent agent = agent().withBreed(NC).build();

        Agent updatedAgent = agent.switchBreed();
        assertThat(updatedAgent.breedCGained, equalTo(true));
        assertThat(updatedAgent.breedCLost, equalTo(false));
    }

    @Test
    public void setsBreedCLostFlagWhenSwitchingFromCToNC() {
        Agent agent = agent().withBreed(C).build();

        Agent updatedAgent = agent.switchBreed();
        assertThat(updatedAgent.breedCLost, equalTo(true));
        assertThat(updatedAgent.breedCGained, equalTo(false));
    }

    @Test
    public void switchCreatesCopiedAgentWithDifferentBreed() {
        int socialGrade = 1;
        int paymentAtPurchase = 2;
        double attributeBrand = 3;
        double attributePrice = 4;
        double attributePromotions = 5;
        int inertiaForSwitch = 6;
        Agent agent = agent()
                .withBreed(C)
                .withSocialGrade(socialGrade)
                .withPaymentAtPurchase(paymentAtPurchase)
                .withAttributeBrand(attributeBrand)
                .withAttributePrice(attributePrice)
                .withAttributePromotions(attributePromotions)
                .withInertiaForSwitch(inertiaForSwitch)
                .build();

        Agent updatedAgent = agent.switchBreed();
        assertThat(updatedAgent.breed, equalTo(NC));
        assertThat(updatedAgent.socialGrade, equalTo(socialGrade));
        assertThat(updatedAgent.paymentAtPurchase, equalTo(paymentAtPurchase));
        assertThat(updatedAgent.attributeBrand, equalTo(attributeBrand));
        assertThat(updatedAgent.attributePrice, equalTo(attributePrice));
        assertThat(updatedAgent.attributePromotions, equalTo(attributePromotions));
        assertThat(updatedAgent.autoRenew, equalTo(false));
        assertThat(updatedAgent.inertiaForSwitch, equalTo(inertiaForSwitch));

        Agent reUpdatedAgent = updatedAgent.switchBreed();
        assertThat(reUpdatedAgent.breed, equalTo(C));
        assertThat(reUpdatedAgent.socialGrade, equalTo(socialGrade));
        assertThat(reUpdatedAgent.paymentAtPurchase, equalTo(paymentAtPurchase));
        assertThat(reUpdatedAgent.attributeBrand, equalTo(attributeBrand));
        assertThat(reUpdatedAgent.attributePrice, equalTo(attributePrice));
        assertThat(reUpdatedAgent.attributePromotions, equalTo(attributePromotions));
        assertThat(reUpdatedAgent.autoRenew, equalTo(false));
        assertThat(reUpdatedAgent.inertiaForSwitch, equalTo(inertiaForSwitch));
    }

    private AgentBuilder agent() {
        return new AgentBuilder();
    }
}