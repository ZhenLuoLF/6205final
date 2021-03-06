import java.util.*;
class LargestTree{
    static void addEdge(LinkedList<Integer> adj[], int u, int v)
    {
        //TO-DO:
        adj[u].add(v);
    }

    static int DFS(int u, LinkedList<Integer> adj[], Vector<Boolean> visited) {
        // Iterate through all the nodes and perform DFS if the node is not yet visited
        //TO-DO:
        int size = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(u);
        while (!stack.isEmpty()) {
            int n = stack.pop();
            size++;
            visited.add(n, true);
            for (Integer i : adj[n]) {
                if (!visited.get(i)) {
                    stack.push(i);
                    System.out.println(i);
                }
            }
        }

        return size;
    }

    public int largestTree(LinkedList<Integer> adj[], int V)
    {
        //TO-DO:
        int max = 0;
        Vector<Boolean> visited = new Vector<>(V);
        for(int i = 0; i < V; i++){
            visited.add(i, false);
        }
        for(int i = 0; i<V; i++) {
            if (!visited.get(i)) {
                max = Math.max(max, DFS(i, adj, visited));
            }
        }

        return max;
    }
}
