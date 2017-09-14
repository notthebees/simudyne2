package simulation;

import static simulation.Breed.C;
import static simulation.Breed.NC;

public class BreedUpdater implements AgentUpdater {

    private final MyRandom random;

    public BreedUpdater(MyRandom random) {
        this.random = random;
    }

    @Override
    public Agent update(Agent agent, int iteration) {
        if (agent.autoRenew) {
            return agent;
        }

        double rand = random.nextDouble() * 3;
        double affinity = agent.paymentAtPurchase / agent.attributePrice + (rand * agent.attributePromotions * agent
                .inertiaForSwitch);
        if (agent.breed.equals(C)) {
            if (affinity < agent.socialGrade * agent.attributeBrand) {
                return new Agent(NC, agent.socialGrade, agent.paymentAtPurchase, agent.attributeBrand, agent
                        .attributePrice, agent.attributePromotions, false, agent.inertiaForSwitch);
            }
        }

        return agent;
    }
}
