import java.util.*;

public class dfs_edge{

    static class Graph {
        private int vertices;
        private List<List<Integer>> adjacencyList;
        private int[][] treeEdge;

        public Graph(int vertices) {
            this.vertices = vertices;
            this.adjacencyList = new ArrayList<>(vertices);
            this.treeEdge = new int[vertices + 1][vertices + 1];

            for (int i = 0; i < vertices; i++) {
                adjacencyList.add(new LinkedList<>());
            }
        }

        public void addEdge(int source, int destination) {
            adjacencyList.get(source).add(destination);
            treeEdge[source][destination] = 0;
        }

        public void depthFirstSearch(int startVertex) {
            int[] startTime = new int[vertices];
            int[] endTime = new int[vertices];
            int[] predecessor = new int[vertices];

            Arrays.fill(predecessor, -1);
            Arrays.fill(endTime, -1);
            int time = 0;

            Stack<Integer> stack = new Stack<>();
            stack.push(startVertex);

            while (!stack.isEmpty()) {
                int currentVertex = stack.peek();

                if (startTime[currentVertex] == 0) {
                    startTime[currentVertex] = ++time;
                    System.out.println("Visited: " + currentVertex +
                            " (Start Time: " + startTime[currentVertex] +
                            ", Predecessor: " + predecessor[currentVertex] + ")");
                }

                boolean allNeighborsVisited = true;

                for (int neighbor : adjacencyList.get(currentVertex)) {
                    if (startTime[neighbor] == 0) {
                        allNeighborsVisited = false;
                        predecessor[neighbor] = currentVertex;
                        stack.push(neighbor);

                        // Classification of edges (Tree Edge)
                        System.out.println("Tree Edge: " + currentVertex + " -> " + neighbor);
                        break;
                    } else {
                        // Classification of edges (Back Edge, Forward Edge, Cross Edge)
                        classifyEdge(currentVertex, neighbor, startTime, endTime, predecessor);
                    }
                }

                if (allNeighborsVisited) {
                    stack.pop();
                    if (endTime[currentVertex] == -1) {
                        endTime[currentVertex] = ++time;
                        System.out.println("End Time: " + endTime[currentVertex] +
                                " near Node " + currentVertex);
                    }
                }
            }
        }

        private void classifyEdge(int currentVertex, int neighbor, int[] startTime, int[] endTime, int[] predecessor) {
            if (predecessor[currentVertex] != neighbor) {
                // Back Edge
                if (startTime[neighbor] < startTime[currentVertex] && endTime[currentVertex] < endTime[neighbor]) {
                    System.out.println("Back Edge: " + currentVertex + " -> " + neighbor);
                }
                // Forward Edge
                if (startTime[currentVertex] < startTime[neighbor] && endTime[neighbor] < endTime[currentVertex]) {
                    System.out.println("Forward Edge: " + currentVertex + " -> " + neighbor);
                }
                // Cross Edge
                if (startTime[neighbor] < endTime[neighbor] && startTime[currentVertex] < endTime[currentVertex]) {
                    System.out.println("Cross Edge: " + currentVertex + " -> " + neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 0 for directed graph or 1 for undirected graph: ");
        int d = scanner.nextInt();

        System.out.print("\nEnter the number of vertices: ");
        int numVertices = scanner.nextInt();

        Graph graph = new Graph(numVertices);

        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        System.out.println("Enter the edges (source and destination) separated by space:");
        for (int i = 0; i < numEdges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);

            if (d == 1)
                graph.addEdge(destination, source);
        }

        System.out.print("Enter the starting vertex for DFS: ");
        int startVertex = scanner.nextInt();

        System.out.println("Depth-First Search starting from vertex " + startVertex + ":");
        graph.depthFirstSearch(startVertex);

        scanner.close();
    }
}
