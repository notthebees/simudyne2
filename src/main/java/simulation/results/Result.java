package simulation.results;

public class Result {
    public final int breedCAgents;
    public final int breedNCAgents;
    public final int breedCLost;
    public final int breedCGained;
    public final int breedCRegained;

    public Result(int breedCAgents, int breedNCAgents, int breedCLost, int breedCGained, int breedCRegained) {
        this.breedCAgents = breedCAgents;
        this.breedNCAgents = breedNCAgents;
        this.breedCLost = breedCLost;
        this.breedCGained = breedCGained;
        this.breedCRegained = breedCRegained;
    }
}
