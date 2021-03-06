package simulation.agent;

import static simulation.agent.Breed.C;

@SuppressWarnings("WeakerAccess")
public class AgentBuilder {
    private Breed breed = C;
    private int socialGrade = 0;
    private int paymentAtPurchase = 0;
    private double attributeBrand = 0;
    private double attributePrice = 0;
    private double attributePromotions = 0;
    private boolean autoRenew = false;
    private int inertiaForSwitch = 0;
    private boolean breedCLost;
    private boolean breedCGained;
    private boolean breedCRegained;

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

    public AgentBuilder withAttributeBrand(double attributeBrand) {
        this.attributeBrand = attributeBrand;
        return this;
    }

    public AgentBuilder withAttributePrice(double attributePrice) {
        this.attributePrice = attributePrice;
        return this;
    }

    public AgentBuilder withAttributePromotions(double attributePromotions) {
        this.attributePromotions = attributePromotions;
        return this;
    }

    public AgentBuilder withAutoRenew() {
        this.autoRenew = true;
        return this;
    }

    public AgentBuilder withInertiaForSwitch(int inertiaForSwitch) {
        this.inertiaForSwitch = inertiaForSwitch;
        return this;
    }

    public AgentBuilder withBreedCLost() {
        breedCLost = true;
        return this;
    }

    public AgentBuilder withBreedCGained() {
        breedCGained = true;
        return this;
    }

    public AgentBuilder withBreedCRegained() {
        breedCRegained = true;
        return this;
    }

    public Agent build() {
        return new Agent(breed, socialGrade, paymentAtPurchase, attributeBrand, attributePrice, attributePromotions,
                autoRenew, inertiaForSwitch, breedCLost, breedCGained, breedCRegained);
    }
}
