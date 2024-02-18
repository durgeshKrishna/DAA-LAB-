import java.util.*;

class Directed_DC{
    boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack, ArrayList<ArrayList<Integer>> adj) {
        // marking the current node as visited and part of the recursion stack.
        if (recStack[i]) return true;

        if (visited[i]) return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = adj.get(i);

        // calling function recursively for all the vertices adjacent to this vertex.
        for (Integer c : children)
            if (isCyclicUtil(c, visited, recStack, adj)) return true;

        // removing the vertex from recursion stack.
        recStack[i] = false;

        return false;
    }

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // marking all vertices as not visited and not a part of the recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        // calling the recursive helper function to detect cycle in different DFS trees.
        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack, adj)) return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
        }

      Directed_DC solution = new Directed_DC();
        boolean hasCycle = solution.isCyclic(V, adj);
        if (hasCycle)
            System.out.println("The graph contains a cycle.");
        else
            System.out.println("The graph does not contain a cycle.");
    }
}
