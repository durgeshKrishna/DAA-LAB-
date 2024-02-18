import java.util.*;
class dfs1 {
private void dfs1(int ch, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[ch] = true;
        System.out.print(ch + " ");
        for (int u : adj.get(ch)) {
            if (!vis[u]) {
                dfs1(u, vis, adj);
            }
        }
    }
    public int dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj, int source) {
        boolean[] vis = new boolean[V];
        int count=0;
        for(int i=0;i<V;i++){
        if(vis[i]==false)
           { dfs1(i, vis, adj);
            count++;
    }}
    return count;
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
            if (!directed) { 
                adj.get(v).add(u);
            }
        }
        System.out.print("Enter the source vertex for DFS: ");
        int source = scanner.nextInt();
        dfs1 dfsInstance = new dfs1(); 
        System.out.print("DFS Traversal from vertex " + source + ": ");
        int c=dfsInstance.dfsOfGraph(V, adj, source); 
        System.out.println("   "+c);    
    }
}
