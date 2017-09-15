package simulation.random;

public class MockRandom implements MyRandom {

    @Override
    public double nextDouble() {
        return 0.5;
    }
}
