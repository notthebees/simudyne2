package simulation;

import static simulation.Breed.C;

public class AgentBuilder {
    private Breed breed = C;
    private int socialGrade = 0;
    private int paymentAtPurchase = 0;
    private double attributeBrand = 0;
    private double attributePrice = 0;
    private double attributePromotions = 0;
    private boolean autoRenew = false;
    private int inertiaForSwitch = 0;

    public AgentBuilder with(Breed breed) {
        this.breed = breed;
        return this;
    }

    public AgentBuilder withAutoRenew() {
        this.autoRenew = true;
        return this;
    }

    public Agent build() {
        return new Agent(breed, socialGrade, paymentAtPurchase, attributeBrand, attributePrice, attributePromotions,
                autoRenew, inertiaForSwitch);
    }
}
