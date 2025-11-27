import java.util.*;
import java.io.*;
class Graph {
    int nodes;                      // number of nodes
    List<List<Edge>> adj;           // adjacency list
    BBSRandom rand;                 // random generator

    // Constructor: generates a new random graph
    public Graph() {
        this.rand = new BBSRandom();
        generateRandomGraph();
    }

    // Generate a random directed weighted graph
    public void generateRandomGraph() {
        nodes = rand.nextInt(13) + 3; // nodes between 3 and 15
        adj = new ArrayList<>();
        for (int i = 0; i < nodes; i++) adj.add(new ArrayList<>());


        BBSRandom rand_weight = new BBSRandom();
        int edges = rand.nextInt(nodes * 2) + nodes; // random number of edges
        //int edges = nodes*2;

        for (int i = 0; i < edges; i++) {
            int from = rand.nextInt(nodes);
            int to = rand.nextInt(nodes);
            while (to == from) to = rand.nextInt(nodes); // no self-loop
            int weight = rand_weight.nextInt(20) + 1;          // weights 1-20
            System.out.println("to " + to);
            System.out.println("from " + from);
            adj.get(from).add(new Edge(weight, to));
        }
    }

    // Print the graph in a readable format
    public void printGraph() {
        System.out.println("\nGraph (" + nodes + " nodes):");
        for (int i = 0; i < nodes; i++) {
            System.out.print("Node " + i + ": ");
            for (Edge e : adj.get(i)) System.out.print(i + e.toString() + "  ");
            System.out.println();
        }
    }
}
