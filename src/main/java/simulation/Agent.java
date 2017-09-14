package simulation;

public class Agent {

    public final Breed breed;

    public final boolean autoRenew;

    public Agent(Breed breed, boolean autoRenew) {
        this.breed = breed;
        this.autoRenew = autoRenew;
    }

    public Agent(Breed breed) {
        this(breed, false);
    }
}
