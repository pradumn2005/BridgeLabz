import java.util.*;

public class CityRoadNetwork {
    static class Edge {
        String target;
        int weight;
        
        Edge(String target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Map<String, List<Edge>> graph = new HashMap<>();
        String[] intersections = {"A", "B", "C", "D", "E"};
        for (String i : intersections) {
            graph.put(i, new ArrayList<>());
        }
        
        graph.get("A").add(new Edge("B", 5));
        graph.get("B").add(new Edge("C", 3));
        graph.get("C").add(new Edge("B", 3));
        graph.get("A").add(new Edge("D", 7));
        graph.get("D").add(new Edge("A", 7));
        graph.get("D").add(new Edge("E", 2));
        graph.get("C").add(new Edge("E", 4));
        
        System.out.println(getReachable(graph, "A"));
        System.out.println(fewestTurns(graph, "A", "E"));
    }

    static Set<String> getReachable(Map<String, List<Edge>> graph, String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        
        q.add(start);
        visited.add(start);
        
        while (!q.isEmpty()) {
            String curr = q.poll();
            for (Edge edge : graph.get(curr)) {
                if (!visited.contains(edge.target)) {
                    visited.add(edge.target);
                    q.add(edge.target);
                }
            }
        }
        return visited;
    }

    static int fewestTurns(Map<String, List<Edge>> graph, String start, String target) {
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> turns = new HashMap<>();
        
        q.add(start);
        turns.put(start, 0);
        
        while (!q.isEmpty()) {
            String curr = q.poll();
            if (curr.equals(target)) {
                return turns.get(curr);
            }
            
            for (Edge edge : graph.get(curr)) {
                if (!turns.containsKey(edge.target)) {
                    turns.put(edge.target, turns.get(curr) + 1);
                    q.add(edge.target);
                }
            }
        }
        return -1;
    }
}
