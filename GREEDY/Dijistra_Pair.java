package Greedy;
import java.util.*;
class Dijistra_Pair {
    public final int Key;
    public final int Value;
    Dijistra_Pair(int Key, int Value){
        this.Key = Key;
        this.Value = Value;
    }
}
class DIJKSTRA
 {
    static int[] parent = new int[4];
    static ArrayList<ArrayList<Dijistra_Pair>> l = new ArrayList<>();
    public static void main(String[] args) {
        Arrays.fill(parent,-1);
        for (int i=0;i<5;i++){
            l.add(new ArrayList<Dijistra_Pair>());
        }
        /*undirected-weighted graph: */
        addedge(0, 1, 10);
        addedge(0, 2, 6);
        addedge(0, 3, 5);
        addedge(1, 3, 15);
        addedge(2, 3, 4);
        dijkstra(4);
    }
    public static void addedge(int u,int v,int weight){
        l.get(u).add(new Dijistra_Pair(v,weight));
        l.get(v).add(new Dijistra_Pair(u,weight));
    }
    public static void dijkstra(int V){
        PriorityQueue<Dijistra_Pair> pq = new PriorityQueue<>(Comparator.comparingInt((Dijistra_Pair o) -> o.Value));
        int src = 0; // Taking vertex 0 as source
        // Create a distance array
        int dist[] = new int[V];
// Initialize all distances as INFINITE
        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;
        // Distance of source vertex from itself is always 0
        dist[src] = 0;
        // Add source node to the priority queue
        pq.add(new Dijistra_Pair(src, dist[src]));
        // Process the vertices
        while (!pq.isEmpty()) {
            int u = pq.poll().Key;

            for (Dijistra_Pair p : l.get(u)) {
                int v = p.Key;
                int weight = p.Value;

                // Relaxation step
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    parent[v] = u;
                    pq.add(new Dijistra_Pair(v, dist[v]));
                }
            }
        }
       printShortestDistances(dist, V);
    }
    public static void printShortestDistances(int dist[], int V){
        System.out.println("Vertex \tDistancefromSource \tParent");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t" + dist[i] + " \t\t\t\t\t" + parent[i]);
    }
}
