import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    private Map<Integer, Vertex> vertexMap = new HashMap<>();

    public void addVertex(Vertex v) {
        vertexMap.put(v.getId(), v);
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        if (vertexMap.containsKey(from) && vertexMap.containsKey(to)) {
            adjList.get(from).add(to);
        }
    }

    public void printGraph() {
        for (Integer vId : adjList.keySet()) {
            System.out.println(vId + " is connected to: " + adjList.get(vId));
        }
    }

    // BFS Implementation using a Queue
    public void bfs(int start) {
        if (!adjList.containsKey(start)) return;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // DFS Implementation using Recursion
    public void dfs(int start) {
        if (!adjList.containsKey(start)) return;

        System.out.print("DFS Traversal: ");
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(start, visited);
        System.out.println();
    }

    private void dfsRecursive(int current, Set<Integer> visited) {
        visited.add(current);
        System.out.print(current + " ");

        for (int neighbor : adjList.get(current)) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }
}