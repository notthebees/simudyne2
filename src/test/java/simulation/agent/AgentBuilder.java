package simulation.agent;

import static simulation.agent.Breed.C;

public class AgentBuilder {
    private Breed breed = C;
    private int socialGrade = 0;
    private int paymentAtPurchase = 0;
    private double attributeBrand = 0;
    private double attributePrice = 0;
    private double attributePromotions = 0;
    private boolean autoRenew = false;
    private int inertiaForSwitch = 0;

    public AgentBuilder withBreed(Breed breed) {
        this.breed = breed;
        return this;
    }

    public AgentBuilder withSocialGrade(int socialGrade) {
        this.socialGrade = socialGrade;
        return this;
    }

    public AgentBuilder withPaymentAtPurchase(int paymentAtPurchase) {
        this.paymentAtPurchase = paymentAtPurchase;
        return this;
    }

    public AgentBuilder withAttributeBrand(int attributeBrand) {
        this.attributeBrand = attributeBrand;
        return this;
    }

    public AgentBuilder withAttributePrice(double attributePrice) {
        this.attributePrice = attributePrice;
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
