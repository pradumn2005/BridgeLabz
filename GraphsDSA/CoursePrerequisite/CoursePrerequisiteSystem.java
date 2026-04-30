import java.util.*;

public class CoursePrerequisiteSystem {
    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        String[] courses = {"CS101", "CS102", "CS201", "CS202", "MATH101"};
        for (String c : courses) {
            graph.put(c, new ArrayList<>());
        }
        
        graph.get("CS101").add("CS102");
        graph.get("CS101").add("CS201");
        graph.get("CS102").add("CS202");
        graph.get("MATH101").add("CS201");
        
        System.out.println(hasCycle(graph));
        System.out.println(topologicalSort(graph));
    }

    static boolean hasCycle(Map<String, List<String>> graph) {
        Set<String> visited = new HashSet<>();
        Set<String> recStack = new HashSet<>();
        
        for (String node : graph.keySet()) {
            if (dfsCycle(node, graph, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    static boolean dfsCycle(String node, Map<String, List<String>> graph, Set<String> visited, Set<String> recStack) {
        if (recStack.contains(node)) return true;
        if (visited.contains(node)) return false;
        
        visited.add(node);
        recStack.add(node);
        
        for (String neighbor : graph.get(node)) {
            if (dfsCycle(neighbor, graph, visited, recStack)) {
                return true;
            }
        }
        
        recStack.remove(node);
        return false;
    }

    static List<String> topologicalSort(Map<String, List<String>> graph) {
        Map<String, Integer> inDegree = new HashMap<>();
        for (String node : graph.keySet()) {
            inDegree.put(node, 0);
        }
        
        for (String node : graph.keySet()) {
            for (String neighbor : graph.get(node)) {
                inDegree.put(neighbor, inDegree.get(neighbor) + 1);
            }
        }
        
        Queue<String> q = new LinkedList<>();
        for (String node : inDegree.keySet()) {
            if (inDegree.get(node) == 0) {
                q.add(node);
            }
        }
        
        List<String> order = new ArrayList<>();
        while (!q.isEmpty()) {
            String curr = q.poll();
            order.add(curr);
            
            for (String neighbor : graph.get(curr)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    q.add(neighbor);
                }
            }
        }
        return order;
    }
}
