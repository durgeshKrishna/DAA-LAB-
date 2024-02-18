import java.util.*;

class dfs{

    private void dfs(int ch, boolean[] vis, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj) {
        // marking vertex as visited and adding it to output list.
        vis[ch] = true;
        ans.add(ch);

        // iterating over connected components of the vertex and if any
        // of them is not visited then calling the function recursively.
        for (int i = 0; i < adj.get(ch).size(); i++)
            if (!vis[adj.get(ch).get(i)])
                dfs(adj.get(ch).get(i), vis, ans, adj);
    }

    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj, int source) {
        // using a boolean list to mark all the vertices as not visited.
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<Integer>();
        dfs(source, vis, ans, adj);

        // returning the output list.
        return ans;
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

    System.out.print("Enter the source vertex for DFS: ");
    int source = scanner.nextInt();

    dfs dfsInstance = new dfs(); // Create an instance of the dfs class
    ArrayList<Integer> dfsTraversal = dfsInstance.dfsOfGraph(V, adj, source); // Call the method on the instance
    System.out.println("DFS Traversal from vertex " + source + ": " + dfsTraversal);
}

}
