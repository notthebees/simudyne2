package simulation.agent;

import static simulation.agent.Breed.C;
import static simulation.agent.Breed.NC;

public class Agent {
    public final Breed breed;
    public final int socialGrade;
    public final int paymentAtPurchase;
    public final double attributeBrand;
    public final double attributePrice;
    public final double attributePromotions;
    public final boolean autoRenew;
    public final int inertiaForSwitch;
    public final boolean breedCLost;
    public final boolean breedCGained;
    public final boolean breedCRegained;

    public Agent(
            Breed breed,
            int socialGrade,
            int paymentAtPurchase,
            double attributeBrand,
            double attributePrice,
            double attributePromotions,
            boolean autoRenew,
            int inertiaForSwitch,
            boolean breedCLost,
            boolean breedCGained,
            boolean breedCRegained)
    {
        this.breed = breed;
        this.socialGrade = socialGrade;
        this.paymentAtPurchase = paymentAtPurchase;
        this.attributeBrand = attributeBrand;
        this.attributePrice = attributePrice;
        this.attributePromotions = attributePromotions;
        this.autoRenew = autoRenew;
        this.inertiaForSwitch = inertiaForSwitch;
        this.breedCLost = breedCLost;
        this.breedCGained = breedCGained;
        this.breedCRegained = breedCRegained;
    }

    public Agent(Breed breed) {
        this(breed, 0, 0, 0, 0, 0, false, 0, false, false, false);
    }

    public boolean toSwitch(double rand, double brandFactor) {
        return !autoRenew && (breed.equals(C) && affinity(rand) < socialGrade * attributeBrand) ||
                breed.equals(NC) && affinity(rand) < socialGrade * attributeBrand * brandFactor;
    }

    private double affinity(double rand) {
        return paymentAtPurchase / attributePrice + (rand * attributePromotions * inertiaForSwitch);
    }

    public Agent switchBreed() {
        if (breed.equals(C)) {
            return new Agent(NC, socialGrade, paymentAtPurchase, attributeBrand, attributePrice, attributePromotions,
                    false, inertiaForSwitch, true, false, false);
        } else {
            if (breedCLost) {
                return new Agent(C, socialGrade, paymentAtPurchase, attributeBrand, attributePrice, attributePromotions,
                        false, inertiaForSwitch, false, true, true);
            } else {
                return new Agent(C, socialGrade, paymentAtPurchase, attributeBrand, attributePrice, attributePromotions,
                        false, inertiaForSwitch, false, true, false);
            }
        }
    }
}
