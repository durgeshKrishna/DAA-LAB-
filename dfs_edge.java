package packages.a;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class graph2 {
    static int time = 0;
    static int[][] tree_edge ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); int flag = 0;
        System.out.print("Enter 0 for directed graph or 1 for undirected graph:");
        int d = sc.nextInt();
        System.out.printf("\nEnter the number of vertices:");
        int a = sc.nextInt();
        tree_edge = new int[a+1][a+1];
        for(int i = 0;i<=a;i++) {
            for(int j = 0;j<= a;j++) {
                tree_edge[i][j] = -1;
            }
        }
        int[][] adj_matrix = new int[a + 1][a + 1];
        System.out.printf("\nEnter the number of edges:");
        int b = sc.nextInt();
        for (int i = 0; i < b; i++) {
            System.out.printf("\nEnter the source and destination:");
            int m = sc.nextInt();
            int n = sc.nextInt();
            adj_matrix[m][n] = 1; tree_edge[m][n] = 0;
            if (d == 1) adj_matrix[n][m] = 1;
        }
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= a; j++) {
                System.out.print(adj_matrix[i][j] + " ");
            }
            System.out.println();
        }
        vertex1[] arr = DFS(adj_matrix);
        System.out.printf("\nNode     start_time     end_time\n");
        for (int i = 0; i < a; i++) {
            System.out.printf(" %d         %d             %d\n",arr[i].data,arr[i].start,arr[i].end);
        }
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= a; j++) {
                System.out.print(tree_edge[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 1; i <= a ; i++) {
            for (int j = 1; j <= a ; j++) {
                if(tree_edge[i][j] == 0){
                    int i1 = arr[i-1].start;  int i2 = arr[i-1].end;  int j1 = arr[j-1].start;  int j2 = arr[j-1].end;
                    if(i == j){
                        System.out.printf("\n%d--->%d  is BACKWARD EDGE",arr[i-1].data,arr[j-1].data); flag = 1;
                    }
                    if((i1<j1&&j1<i2)&&(i1<j2&&j2<i2)) System.out.printf("\n%d--->%d  is FORWARD EDGE",arr[i-1].data,arr[j-1].data);
                    else if((j1<i1&&i1<j2)&&(j1<i2&&i2<j2)) {
                        System.out.printf("\n%d--->%d  is BACKWARD EDGE",arr[i-1].data,arr[j-1].data); flag = 1;
                    }
                    else System.out.printf("\n%d--->%d  is CROSS EDGE",arr[i-1].data,arr[j-1].data);
                }
            }
        }
        if(flag == 1) System.out.println("\nTHE GRAPH HAS CYCLE");
        else System.out.println("\nTHE GRAPH DOES NOT HAVE CYCLE");
    }
    public static vertex1[] DFS(int[][] adj_matrix){
        int size = adj_matrix.length;
        vertex1[] arr = new vertex1[size];

        for (int i = 1; i < size; i++) {
            arr[i] = new vertex1("WHITE", -1, i,0,0);
        }

        for (int j = 1;j < size; j++){
            for (int i = 1; i < size; i++) {
                if (adj_matrix[arr[j].data][i] == 1 && Objects.equals(arr[j].color, "WHITE")){
                    DFS_VISIT(adj_matrix,arr,arr[j]);
                }
            }
        }
        return Arrays.copyOfRange(arr, 1, size);
    }
    public static void DFS_VISIT(int[][] adj_matrix,vertex1[] arr,vertex1 u){
        time = time + 1;
        u.start=time;
        u.color="GREY";
        for (int i = 1; i < adj_matrix.length; i++) {
            if (adj_matrix[u.data][i] == 1 && Objects.equals(arr[i].color, "WHITE")){
                arr[i].precedence=u.data;
                DFS_VISIT(adj_matrix, arr, arr[i]);
                tree_edge[u.data][arr[i].data] = 1;
            }
        }
        time = time + 1;
        u.end = time;
        u.color="BLACK";
    }
}
class vertex1{
    String color;
    int precedence;
    int data;
    int start;  int end;
    vertex1(String color,int precedence,int data,int start,int end){
        this.color=color;
        this.precedence=precedence;
        this.data=data;
        this.start=start;
        this.end=end;
    }
}
