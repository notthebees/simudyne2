package simulation;

import simulation.agent.Agent;
import simulation.agent.AgentUpdater;
import simulation.agent.BreedUpdater;
import simulation.parsing.DataParser;
import simulation.random.MockRandom;
import simulation.results.FunctionalResultsCalculator;
import simulation.results.Result;
import simulation.results.ResultsCalculator;
import simulation.results.SimulationHistory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Agent> agents = null;
        try {
            agents = new DataParser().parse(new File(args[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }

        AgentUpdater updater = new BreedUpdater(new MockRandom());
        Simulation simulation = new Simulation(agents, updater);
        SimulationHistory history = simulation.run(15);

        ResultsCalculator resultsCalculator = new FunctionalResultsCalculator();
        List<Result> results = history.getResults(resultsCalculator);
        for (int i = 0; i < results.size(); i++) {
            Result result = results.get(i);
            System.out.println("Iteration " + Integer.toString(i));
            System.out.println(result.toString());
        }
    }
}
