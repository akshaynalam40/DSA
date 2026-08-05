class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : invocations) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] vis = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(k);
        vis[k] = true;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj.get(u)) {
                if (!vis[v]) {
                    vis[v] = true;
                    q.offer(v);
                }
            }
        }

        // Check whether any non-suspicious method invokes a suspicious one
        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            if (!vis[u] && vis[v]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}