package simulation;

public class MockRandom implements MyRandom {

    @Override
    public double nextDouble() {
        return 0.5;
    }
}
