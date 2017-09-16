This is a second attempt at implementing an agent-based simulation, in which agents' breeds are updated over the course of 15 iterations.
On each iteration, the numbers of agents of breed C and NC are counted, as well as the numbers that have switched from one breed to the other.

This time round I have used Maven to build a Java program, using test-driven development to build reliable, object-oriented code.

Run the `simudyne2.jar` file from the command line, with an CSV input file as the sole argument.
An example input file is located in `src/main/resources`.
Thus from the root folder you can run the simulation with

`java -jar simudyne2.jar src/main/resources/input.csv`

The results will be printed to a file called `output`.
