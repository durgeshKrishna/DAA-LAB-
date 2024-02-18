import java.util.*;

public class MatrixToList{

    // Function to convert adjacency matrix to adjacency list
    static ArrayList<ArrayList<Integer>> convert(int[][] a, boolean directed) {
        int numVertices = a.length;
        ArrayList<ArrayList<Integer>> adjListArray = new ArrayList<>(numVertices);

        for (int i = 0; i < numVertices; i++) {
            adjListArray.add(new ArrayList<>());
        }

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (a[i][j] != 0) {
                    adjListArray.get(i).add(j);
                    if (!directed && i != j) { // If undirected, add reverse edge
                        adjListArray.get(j).add(i);
                    }
                }
            }
        }
        return adjListArray;
    }

    // Function to print the adjacency list
    static void printArrayList(ArrayList<ArrayList<Integer>> adjListArray) {
        // Print the adjacency list
        for (int v = 0; v < adjListArray.size(); v++) {
            System.out.print(v);
            for (Integer u : adjListArray.get(v)) {
                System.out.print(" -> " + u);
            }
            System.out.println();
        }
    }

    // Driver Code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask whether the graph is directed or undirected
        System.out.print("Is the graph directed? (1 for directed, 0 for undirected): ");
        int directedInput = scanner.nextInt();
        boolean directed = (directedInput == 1);

        // Given Adjacency Matrix
        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();
        int[][] a = new int[numVertices][numVertices];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        // function to convert adjacency matrix to adjacency list
        ArrayList<ArrayList<Integer>> adjListArray = convert(a, directed);
        System.out.println("Adjacency List:");
        printArrayList(adjListArray);
    }
}
