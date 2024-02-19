import java.io.*;
import java.util.*;

public class Graph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 0 for directed graph or 1 for undirected graph:");
        int d = sc.nextInt();
        System.out.printf("\nEnter the number of vertices:");
        int a = sc.nextInt();
        int[][] adj_matrix = new int[a + 1][a + 1];
        System.out.printf("\nEnter the number of edges:");
        int b = sc.nextInt();
        for (int i = 0; i < b; i++) {
            System.out.printf("\nEnter the source and destination:");
            int m = sc.nextInt();
            int n = sc.nextInt();
            adj_matrix[m][n] = 1;
            if (d == 1) adj_matrix[n][m] = 1;
        }
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= a; j++) {
                System.out.print(adj_matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.printf("\nEnter the source:");
        int source = sc.nextInt();
        vertex[] arr = BFS(adj_matrix, source);
        System.out.printf("\nNode          Distance");
        for (int i = 0; i < a; i++) {
            System.out.printf(" %d        %d ", arr[i].data, arr[i].distance);
        }
    }

    // 1 --> white 0 --> grey -1 --> black
    public static vertex[] BFS(int[][] adj_matrix, int source) {
        int size = adj_matrix.length;
        vertex[] arr = new vertex[size];

        for (int i = 1; i < size; i++) {
            arr[i] = new vertex(1, Integer.MAX_VALUE, -1, i);
        }

        vertex s = new vertex(0, 0, -1, source);
        Queue<vertex> Q = new LinkedList<>();
        Q.add(s);

        while (!Q.isEmpty()) {
            vertex u = Q.poll();

            for (int i = 1; i < size; i++) {
                if (adj_matrix[u.data][i] == 1 && arr[i].color == 1) {
                    arr[i].color = 0;
                    arr[i].distance = u.distance + 1;
                    arr[i].precedence = u.data;
                    Q.add(arr[i]);
                }
            }

            u.color = -1;
        }

        return Arrays.copyOfRange(arr, 1, size); // Exclude the unused element at index 0
    }
}
class vertex {
    int color;
    int distance;
    int precedence;
    int data;

    public vertex(int color, int distance, int precedence, int data) {
        this.color = color;
        this.distance = distance;
        this.precedence = precedence;
        this.data = data;
    }
}


	
