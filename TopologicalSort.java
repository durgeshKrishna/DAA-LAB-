import java.util.*;

class TopologicalSort{
    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int N, ArrayList<ArrayList<Integer>> list) {
        // Using boolean array to mark visited nodes and currently 
        // marking all the nodes as false.
        boolean visited[] = new boolean[N];
        Arrays.fill(visited, false);
        Stack<Integer> st = new Stack<>();
        
        // Traversing over all the vertices.
        for (int i = 0; i < N; i++) {
            // If the current vertex is not visited, we call the topo function.
            if (!visited[i]) 
                topo(list, i, visited, st);
        }
        int A[] = new int[st.size()];
        int i = -1;
        while (!st.isEmpty()) {
            // Pushing elements of stack in list and popping them from stack.
            A[++i] = st.peek(); 
            st.pop();
        }
        // Returning the list.
        return A;
    }
    
    static void topo(ArrayList<ArrayList<Integer>> list, int it,
                     boolean visited[], Stack<Integer> s) {
        // Marking the current vertex as visited.
        visited[it] = true; 
        
        // Traversing over the adjacent vertices.
        for (int i = 0; i < list.get(it).size(); i++) {
            // If any vertex is not visited, we call the function recursively.
            if (!visited[list.get(it).get(i)]) 
                topo(list, list.get(it).get(i), visited, s);
        }
        // Pushing the current vertex into the stack.
        s.push(it); 
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int N = scanner.nextInt();

        ArrayList<ArrayList<Integer>> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();
        System.out.println("Enter edges (u v): ");
        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            list.get(u).add(v);
        }

        int[] topoOrder = topoSort(N, list);
        System.out.println("Topological order of vertices:");
        for (int vertex : topoOrder) {
            System.out.print(vertex + " ");
        }
    }
}
