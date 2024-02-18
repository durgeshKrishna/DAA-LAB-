import java.util.*;

class Bfs{
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj, int source) {
        boolean[] visited = new boolean[V];
        visited[source] = true;
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> bfs = new ArrayList<>();
        q.add(source);
        while (!q.isEmpty()) {
            int u = q.poll();
            bfs.add(u);
            for (int i : adj.get(u)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Is the graph directed? (1 for directed, 0 for undirected): ");
        int directedInput = scanner.nextInt();
        boolean directed = (directedInput == 1);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();
        System.out.println("Enter edges (u v): ");
        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adj.get(u).add(v);
            if (!directed) { // If undirected, add reverse edge
                adj.get(v).add(u);
            }
        }

        System.out.print("Enter the source vertex for BFS: ");
        int source = scanner.nextInt();

        Bfs bfs = new Bfs(); // Corrected variable name
        ArrayList<Integer> bfsTraversal = bfs.bfsOfGraph(V, adj, source); // Corrected variable name
        System.out.println("BFS Traversal from vertex " + source + ": " + bfsTraversal);
        
    }
}
