package simulation.agent;

import simulation.BrandFactor;
import simulation.random.MyRandom;

public class BreedUpdater implements AgentUpdater {

    private final MyRandom random;

    public BreedUpdater(MyRandom random) {
        this.random = random;
    }

    @Override
    public Agent update(Agent agent, int iteration) {
        if (agent.toSwitch(random.nextDouble() * 3, BrandFactor.calculate(iteration))) {
            return agent.switchBreed();
        }
        return agent;
    }
}
