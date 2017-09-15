package simulation.agent;

import simulation.random.MyRandom;

import static simulation.agent.Breed.C;

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
        if (agent.breed.equals(C)) {
            if (agent.affinity(rand) < agent.socialGrade * agent.attributeBrand) {
                return agent.switchBreed();
            }
        } else {
            if (agent.affinity(rand) < agent.socialGrade * agent.attributeBrand * brandFactor(iteration)) {
                return agent.switchBreed();
            }
        }

        return agent;
    }

    private double brandFactor(int iteration) {
        return 0.1 + (iteration - 1) / 5;
    }
}
