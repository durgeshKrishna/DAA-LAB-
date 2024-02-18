import java.util.*;

class GFG{

    // Function to print the in and out degrees
    // of all the vertices of the given graph
    static void findInOutDegree(List<List<Integer> > adjList, int n)
    {
        int in[] = new int[n];
        int out[] = new int[n];

        for (int i = 0; i < adjList.size(); i++) {

            List<Integer> list = adjList.get(i);

            // Out degree for ith vertex will be the count
            // of direct paths from i to other vertices
            out[i] = list.size();
            for (int j = 0; j < list.size(); j++)

                // Every vertex that has an incoming 
                // edge from i
                in[list.get(j)]++;
        }

        System.out.println("Vertex\tIn\tOut");
        for (int k = 0; k < n; k++) {
            System.out.println(k + "\t" + in[k] + "\t" + out[k]);
        }
    }

    // Driver code
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the number of vertices
        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();

        // Adjacency list representation of the graph
        List<List<Integer> > adjList = new ArrayList<>();

        // Prompt user to enter adjacency list for each vertex
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the number of neighbors for vertex " + i + ": ");
            int numNeighbors = scanner.nextInt();
            
            List<Integer> tmp = new ArrayList<>();
            System.out.print("Enter the neighbors for vertex " + i + ": ");
            for (int j = 0; j < numNeighbors; j++) {
                int neighbor = scanner.nextInt();
                tmp.add(neighbor);
            }
            adjList.add(tmp);
        }

        scanner.close();

        findInOutDegree(adjList, n);
    }
}
