import java.util.Random;

public class Experiment {

    public void runTraversals(Graph g) {
        // For small graphs, we want to see the actual order
        System.out.println("Running traversals for provided graph...");
        g.bfs(0);
        g.dfs(0);
    }

    public void runMultipleTests() {
        int[] sizes = {10, 30, 100};

        for (int size : sizes) {
            Graph g = generateGraph(size);
            System.out.println("\n--- Testing Graph Size: " + size + " ---");

            // Measure BFS
            long startBFS = System.nanoTime();
            g.bfs(0);
            long endBFS = System.nanoTime();

            // Measure DFS
            long startDFS = System.nanoTime();
            g.dfs(0);
            long endDFS = System.nanoTime();

            System.out.println("BFS Time: " + (endBFS - startBFS) + " ns");
            System.out.println("DFS Time: " + (endDFS - startDFS) + " ns");
        }
    }

    // Helper to create a graph with random edges
    private Graph generateGraph(int size) {
        Graph g = new Graph();
        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(i));
        }

        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            // Add a few random edges for each vertex
            int target = rand.nextInt(size);
            g.addEdge(i, target);

            // Add a second random edge to increase density
            int target2 = rand.nextInt(size);
            g.addEdge(i, target2);
        }
        return g;
    }

    public void printResults() {
        System.out.println("Experimentation complete.");
    }
}