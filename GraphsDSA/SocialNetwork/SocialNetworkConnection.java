import java.util.*;

public class SocialNetworkConnection {
    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        String[] users = {"Alice", "Bob", "Charlie", "David", "Eve"};
        for (String u : users) {
            graph.put(u, new ArrayList<>());
        }
        
        addEdge(graph, "Alice", "Bob");
        addEdge(graph, "Alice", "Charlie");
        addEdge(graph, "Bob", "David");
        addEdge(graph, "Charlie", "Eve");
        addEdge(graph, "David", "Eve");
        
        System.out.println(graph.get("Alice"));
        System.out.println(graph.get("Bob").contains("Eve"));
        System.out.println(shortestPath(graph, "Alice", "Eve"));
    }

    static void addEdge(Map<String, List<String>> graph, String u, String v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    static int shortestPath(Map<String, List<String>> graph, String start, String target) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distances = new HashMap<>();
        
        queue.add(start);
        distances.put(start, 0);
        
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.equals(target)) {
                return distances.get(curr);
            }
            
            for (String neighbor : graph.get(curr)) {
                if (!distances.containsKey(neighbor)) {
                    distances.put(neighbor, distances.get(curr) + 1);
                    queue.add(neighbor);
                }
            }
        }
        return -1;
    }
}
