import java.util.*;

class Bfs1{
    // Function to return Breadth First Traversal of given graph.
    public void bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj, int source, boolean[] visited) {
        visited[source] = true;
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> bfs = new ArrayList<>();
        q.add(source);
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.printf("%d ",u);
            for (int i : adj.get(u)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    int BfsDis(ArrayList<ArrayList<Integer>> adj, int V) {
        int count=0;
        boolean[] visited = new boolean[V]; // Initialize the visited array
        for (int i = 0; i < V; i++) {
            if (!visited[i]) // Corrected loop condition
              {  bfsOfGraph(V, adj, i, visited);
                   count++;
               }
        }
        return count;
    }
    static void printGRaph(ArrayList<ArrayList<Integer>> adj){
        for(int i=0;i<adj.size();i++)
        {   System.out.print(i+"->");
            for(int j=0;j<adj.get(i).size();j++){
                    System.out.print(adj.get(i).get(j)+" ");
            }
            System.out.println(" ");
        }
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

        Bfs1 bfs = new Bfs1();
        int res=bfs.BfsDis(adj, V);
        System.out.println("No of islands is "+ res);
        printGRaph(adj);
    }
}
