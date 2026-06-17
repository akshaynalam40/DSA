class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            revAdj.add(new ArrayList<>());
        }
        int[] outdegree = new int[n];
        for(int i = 0; i < n; i++) {
            outdegree[i] = graph[i].length;
            for (int neigh : graph[i]) {
                revAdj.get(neigh).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);
            for (int prev : revAdj.get(node)) {
                outdegree[prev]--;
                if (outdegree[prev] == 0) {
                    queue.offer(prev);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}