import java.util.*;

public class NetworkDelayTime {
    
    public int networkDelayTime(int[][] times, int N, int K) {
        // Create a map to store the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], k -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        // Min-heap to store the nodes to be processed
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[]{K, 0});

        // Distance map to store the shortest time to reach each node
        Map<Integer, Integer> dist = new HashMap<>();
        
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int node = current[0];
            int time = current[1];

            if (dist.containsKey(node)) {
                continue;
            }
            dist.put(node, time);

            if (!graph.containsKey(node)) {
                continue;
            }

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int nextTime = time + neighbor[1];
                if (!dist.containsKey(nextNode)) {
                    minHeap.offer(new int[]{nextNode, nextTime});
                }
            }
        }

        if (dist.size() != N) {
            return -1;
        }
        
        int maxTime = 0;
        for (int time : dist.values()) {
            maxTime = Math.max(maxTime, time);
        }
        
        return maxTime;
    }

    public static void main(String[] args) {
        NetworkDelayTime solution = new NetworkDelayTime();
        
        int[][] times1 = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int N1 = 4;
        int K1 = 2;
        System.out.println("Network Delay Time: " + solution.networkDelayTime(times1, N1, K1)); // Output: 2

        int[][] times2 = {{1, 2, 1}};
        int N2 = 2;
        int K2 = 1;
        System.out.println("Network Delay Time: " + solution.networkDelayTime(times2, N2, K2)); // Output: 1

        int[][] times3 = {{1, 2, 1}};
        int N3 = 2;
        int K3 = 2;
        System.out.println("Network Delay Time: " + solution.networkDelayTime(times3, N3, K3)); // Output: -1
    }
}
