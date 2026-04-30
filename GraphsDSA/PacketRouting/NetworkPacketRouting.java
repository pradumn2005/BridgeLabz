import java.util.*;

public class NetworkPacketRouting {
    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        String[] routers = {"R1", "R2", "R3", "R4", "R5", "R6"};
        for (String r : routers) {
            graph.put(r, new ArrayList<>());
        }
        
        addEdge(graph, "R1", "R2");
        addEdge(graph, "R1", "R3");
        addEdge(graph, "R2", "R4");
        addEdge(graph, "R3", "R4");
        addEdge(graph, "R4", "R5");
        addEdge(graph, "R5", "R6");
        
        System.out.println(isConnected(graph, routers.length));
        System.out.println(minHops(graph, "R1", "R6"));
    }

    static void addEdge(Map<String, List<String>> graph, String u, String v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    static boolean isConnected(Map<String, List<String>> graph, int totalNodes) {
        if (totalNodes == 0) return true;
        
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        String start = graph.keySet().iterator().next();
        
        q.add(start);
        visited.add(start);
        
        while (!q.isEmpty()) {
            String curr = q.poll();
            for (String neighbor : graph.get(curr)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    q.add(neighbor);
                }
            }
        }
        return visited.size() == totalNodes;
    }

    static int minHops(Map<String, List<String>> graph, String start, String target) {
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> hops = new HashMap<>();
        
        q.add(start);
        hops.put(start, 0);
        
        while (!q.isEmpty()) {
            String curr = q.poll();
            if (curr.equals(target)) {
                return hops.get(curr);
            }
            
            for (String neighbor : graph.get(curr)) {
                if (!hops.containsKey(neighbor)) {
                    hops.put(neighbor, hops.get(curr) + 1);
                    q.add(neighbor);
                }
            }
        }
        return -1;
    }
}
