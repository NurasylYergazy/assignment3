public class Main {
    public static void main(String[] args) {
        // 1. Demonstrate a small manual graph
        Graph smallGraph = new Graph();
        smallGraph.addVertex(new Vertex(0));
        smallGraph.addVertex(new Vertex(1));
        smallGraph.addVertex(new Vertex(2));
        smallGraph.addVertex(new Vertex(3));

        smallGraph.addEdge(0, 1);
        smallGraph.addEdge(1, 2);
        smallGraph.addEdge(2, 3);
        smallGraph.addEdge(3, 0);

        System.out.println("=== Manual Graph Demo ===");
        smallGraph.printGraph();

        Experiment exp = new Experiment();
        exp.runTraversals(smallGraph);

        // 2. Run the large scale performance tests
        System.out.println("\n=== Starting Performance Experiments ===");
        exp.runMultipleTests();

        exp.printResults();
    }
}