import java.util.*;

class ListToMatrix{
    // Function to insert vertices to adjacency list
    static void insert(Vector<Integer>[] adj, int u, int v, boolean directed) {
        // Insert a vertex v to vertex u
        adj[u].add(v);
        if (!directed) // If undirected, add the reverse edge
            adj[v].add(u);
    }

    // Function to display adjacency list
    static void printList(Vector<Integer>[] adj, int V) {
        for (int i = 0; i < V; i++) {
            System.out.print(i);

            for (int j : adj[i])
                System.out.print(" --> " + j);

            System.out.println();
        }
        System.out.println();
    }

    // Function to convert adjacency list to adjacency matrix
    static int[][] convert(Vector<Integer>[] adj, int V) {
        // Initialize a matrix
        int[][] matrix = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j : adj[i])
                matrix[i][j] = 1;
        }
        return matrix;
    }

    // Function to display adjacency matrix
    static void printMatrix(int[][] adj, int V) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Is the graph directed? (1 for directed, 0 for undirected): ");
        int directedInput = scanner.nextInt();
        boolean directed = (directedInput == 1);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        @SuppressWarnings("unchecked")
        Vector<Integer>[] adjList = new Vector[V];
        for (int i = 0; i < adjList.length; i++)
            adjList[i] = new Vector<Integer>();

        // Inserting edges
        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();
        System.out.println("Enter edges (u v): ");
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            insert(adjList, u, v, directed);
        }

        // Display adjacency list
        System.out.print("Adjacency List: \n");
        printList(adjList, V);

        // Function call which returns adjacency matrix after conversion
        int[][] adjMatrix = convert(adjList, V);

        // Display adjacency matrix
        System.out.print("Adjacency Matrix: \n");
        printMatrix(adjMatrix, V);
    }
}
